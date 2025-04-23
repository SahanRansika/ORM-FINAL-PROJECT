package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.RegistrationBO;
import healthcarecenter.dto.RegistrationDTO;
import healthcarecenter.dto.tm.RegistrationTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {

    @FXML
    private Label Rdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<RegistrationTM, String> colDate;

    @FXML
    private TableColumn<RegistrationTM, String> colPatientId;

    @FXML
    private TableColumn<RegistrationTM, String> colProgramId;

    @FXML
    private TableColumn<RegistrationTM, String> colRId;

    @FXML
    private ComboBox<String> cmbPatientId;

    @FXML
    private ComboBox<String> cmbProgramId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPatientId;

    @FXML
    private Label lblProgramId;

    @FXML
    private Label lblRId;

    @FXML
    private Label lblRegistration;

    @FXML
    private TableView<RegistrationTM> tblRegistration;

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOType.Registration);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRId.setCellValueFactory(new PropertyValueFactory<>("registrationId"));
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "FAILED TO INITIALIZE REGISTRATION DATA").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        boolean isDeleted = registrationBO.delete(lblRId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "REGISTRATION DELETED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO DELETE REGISTRATION...!").show();
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        Date registrationDate = Date.valueOf(LocalDate.now());
        RegistrationDTO registrationDTO = new RegistrationDTO(
                lblRId.getText(),
                cmbPatientId.getValue(),
                cmbProgramId.getValue(),
                registrationDate
        );

        boolean isSaved = registrationBO.save(registrationDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "REGISTRATION SAVED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO SAVE REGISTRATION").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        Date registrationDate = Date.valueOf(LocalDate.now());
        RegistrationDTO registrationDTO = new RegistrationDTO(
                lblRId.getText(),
                cmbPatientId.getValue(),
                cmbProgramId.getValue(),
                registrationDate
        );

        boolean isUpdated = registrationBO.update(registrationDTO);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "REGISTRATION UPDATED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE REGISTRATION").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        loadNextRegistrationId();
        loadTableData();
        Rdate.setText(LocalDate.now().toString());
        btnRegister.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);

        cmbPatientId.getSelectionModel().clearSelection();
        cmbProgramId.getSelectionModel().clearSelection();
    }

    public void loadNextRegistrationId() throws SQLException, ClassNotFoundException {
        String nextRegistrationId = registrationBO.getNextRegistrationId();
        lblProgramId.setText(nextRegistrationId);
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> registrationDTOS = registrationBO.getAll();
        ObservableList<RegistrationTM> registrationTMS = FXCollections.observableArrayList();

        for (RegistrationDTO registrationDTO : registrationDTOS) {
            registrationTMS.add(new RegistrationTM(
                    registrationDTO.getRegistrationId(),
                    registrationDTO.getPatientId(),
                    registrationDTO.getProgramId(),
                    registrationDTO.getRegistrationDate()
            ));
        }
        tblRegistration.setItems(registrationTMS);
    }
}
