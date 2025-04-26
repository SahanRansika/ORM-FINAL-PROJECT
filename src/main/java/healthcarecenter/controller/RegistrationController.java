package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.PatientBO;
import healthcarecenter.bo.ProgramBO;
import healthcarecenter.bo.RegistrationBO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.RegistrationDTO;
import healthcarecenter.dto.tm.ProgramTM;
import healthcarecenter.dto.tm.RegistrationTM;
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
    private Label lblPatientName;

    @FXML
    private Label lblProgramId;

    @FXML
    private Label lblProgramName;

    @FXML
    private Label lblRId;

    @FXML
    private Label lblRegistration;

    @FXML
    private TableView<RegistrationTM> tblRegistration;

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOType.Registration);
    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);
    ProgramBO programBO = (ProgramBO) BOFactory.getInstance().getBO(BOFactory.BOType.Program);

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
        loadPatientIds();
        loadProgramIds();
        loadNextRegistrationId();
        loadTableData();
        Rdate.setText(LocalDate.now().toString());
        btnRegister.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        cmbPatientId.getSelectionModel().clearSelection();
        cmbProgramId.getSelectionModel().clearSelection();
    }

    public void loadNextRegistrationId() throws SQLException, ClassNotFoundException {
        String nextRegistrationId = registrationBO.getNextRegistrationId();
        lblRId.setText(nextRegistrationId);
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> registrationDTOList = registrationBO.getAll();
        ObservableList<RegistrationTM> registrationTMList = FXCollections.observableArrayList();

        for (RegistrationDTO dto : registrationDTOList) {
            registrationTMList.add(new RegistrationTM(
                    dto.getRegistrationId(),
                    dto.getPatientId(),
                    dto.getProgramId(),
                    dto.getRegistrationDate()
            ));
        }
        tblRegistration.setItems(registrationTMList);
    }

    private void loadPatientIds() throws SQLException,ClassNotFoundException{
        List<PatientDTO> patientDTOList = patientBO.getAll();
        for (PatientDTO b : patientDTOList){
            cmbPatientId.getItems().add(b.getPatientId());
        }
    }

    private void loadProgramIds() throws SQLException,ClassNotFoundException{
        List<ProgramDTO> programDTOList = programBO.getAll();
        for (ProgramDTO b : programDTOList){
            cmbProgramId.getItems().add(b.getProgramId());
        }
    }

    @FXML
    void cmbPatientIdOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        String selectedPatientId = cmbPatientId.getSelectionModel().getSelectedItem();
        System.out.println("Selected Patient id" + selectedPatientId);
        PatientDTO patientDTO = patientBO.findById(selectedPatientId);

        if (patientDTO != null) {

            lblPatientName.setText(patientDTO.getName());
            System.out.println(patientDTO.getPatientId());
        }
    }

    @FXML
    void cmbProgramIdOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        String selectedProgramId = cmbProgramId.getSelectionModel().getSelectedItem();
        System.out.println("Selected Program id" + selectedProgramId);
        ProgramDTO programDTO = programBO.findById(selectedProgramId);
        if (programDTO != null) {

            lblProgramName.setText(programDTO.getName());
            System.out.println(programDTO.getProgramId());
        }
    }
}
