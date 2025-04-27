package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.PatientBO;
import healthcarecenter.bo.ProgramBO;
import healthcarecenter.bo.SessionsBO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.SessionsDTO;
import healthcarecenter.dto.tm.CartTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class SessionsController implements Initializable {

    @FXML
    private Button btnAddTable, btnPlace, btnRefresh;

    @FXML
    private ComboBox<String> cmbPatientId, cmbProgramId;

    @FXML
    private TableView<CartTM> tblSession;

    @FXML
    private TableColumn<CartTM, String> colProgramId, colProgramName, colPayment, colTotal;

    @FXML
    private TableColumn<CartTM, Button> colAction;

    @FXML
    private Label lblPatientName, lblProgramName, lblPayment, lblTherapistId, lblSessionId, sessionDate;

    ObservableList<CartTM> cartList = FXCollections.observableArrayList();

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);
    ProgramBO programBO = (ProgramBO) BOFactory.getInstance().getBO(BOFactory.BOType.Program);
    SessionsBO sessionsBO = (SessionsBO) BOFactory.getInstance().getBO(BOFactory.BOType.Sessions);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("removeBtn"));

        tblSession.setItems(cartList);

        sessionDate.setText(LocalDate.now().toString());

        try {
            lblSessionId.setText(sessionsBO.getNextSessionId());
            loadPatientIds();
            loadProgramIds();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading data").show();
            e.printStackTrace();
        }

        cmbPatientId.setOnAction(e -> setPatientDetails());
        cmbProgramId.setOnAction(e -> setProgramDetails());
    }

    private void loadPatientIds() throws SQLException, ClassNotFoundException {
        List<PatientDTO> patients = patientBO.getAll();
        for (PatientDTO p : patients) {
            cmbPatientId.getItems().add(p.getPatientId());
        }
    }

    private void loadProgramIds() throws SQLException, ClassNotFoundException {
        List<ProgramDTO> programs = programBO.getAll();
        for (ProgramDTO p : programs) {
            cmbProgramId.getItems().add(p.getProgramId());
        }
    }

    private void setPatientDetails() {
        if (cmbPatientId.getItems().isEmpty()) return;
        String selectedId = cmbPatientId.getValue();
        try {
            PatientDTO patient = patientBO.findById(selectedId);
            if (patient != null) {
                lblPatientName.setText(patient.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProgramDetails() {
        if (cmbProgramId.getItems().isEmpty()) return;

        String selectedId = cmbProgramId.getValue();
        try {
            ProgramDTO program = programBO.findById(selectedId);
            if (program != null) {
                lblProgramName.setText(program.getName());
                lblPayment.setText(program.getCost());
                lblTherapistId.setText(program.getTherapistId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddTableOnAction(ActionEvent event) {
        String programId = cmbProgramId.getValue();
        String programName = lblProgramName.getText();
        String cost = lblPayment.getText();

        Button btn = new Button("Remove");
        CartTM cartTM = new CartTM(programId, programName, cost, cost, btn);

        btn.setOnAction(e -> {
            cartList.remove(cartTM);
            tblSession.refresh();
        });

        cartList.add(cartTM);
        tblSession.refresh();
    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) {
            if (cmbPatientId.getValue() == null || cartList.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please select a patient and at least one program.").show();
                return;
            }

            try {
                String sessionId = lblSessionId.getText();
                Date date = Date.valueOf(sessionDate.getText());
                String patientId = cmbPatientId.getValue();

                System.out.println("Session ID: " + sessionId);
                System.out.println("Patient ID: " + patientId);
                System.out.println("Session Date: " + date);
                System.out.println("Selected Programs:");


                for (CartTM cart : cartList) {
                    System.out.println("- Program ID: " + cart.getProgramId() + ", Payment: " + cart.getPayment());
                }

                SessionsDTO sessionsDTO = new SessionsDTO(sessionId , patientId , date);
                boolean isSave = sessionsBO.save(sessionsDTO);

                if (isSave) {
                    new Alert(Alert.AlertType.INFORMATION, "Session placed successfully!").show();
                    btnRefreshOnAction(event);
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Session failed to save!").show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Failed to place session.").show();
            }
    }

    @FXML
    void btnRefreshOnAction(ActionEvent event) {
        cmbPatientId.getSelectionModel().clearSelection();
        cmbProgramId.getSelectionModel().clearSelection();
        lblPatientName.setText("");
        lblProgramName.setText("");
        lblPayment.setText("");
        lblTherapistId.setText("");
        cartList.clear();
        tblSession.refresh();
    }

    @FXML
    void onClickTable(MouseEvent event) {
        CartTM selectedCartItem = tblSession.getSelectionModel().getSelectedItem();
        if (selectedCartItem != null) {
            cmbProgramId.setValue(selectedCartItem.getProgramId());
            lblProgramName.setText(selectedCartItem.getProgramName());
            lblPayment.setText(selectedCartItem.getPayment());
            lblTherapistId.setText("");

            tblSession.refresh();
        }
    }
}
