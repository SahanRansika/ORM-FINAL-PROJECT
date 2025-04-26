package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.PatientBO;
import healthcarecenter.bo.ProgramBO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.tm.CartTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        new Alert(Alert.AlertType.INFORMATION, "Session placed successfully!").show();
        // Actual saving logic will go here in the next step.
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
}
