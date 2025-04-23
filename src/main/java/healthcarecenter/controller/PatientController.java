package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.PatientBO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.tm.PatientTM;
import healthcarecenter.entity.Patient;
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


public class PatientController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<PatientTM, String> colAddress;

    @FXML
    private TableColumn<PatientTM, String> colBirth;

    @FXML
    private TableColumn<PatientTM, String> colGender;

    @FXML
    private TableColumn<PatientTM, String> colName;

    @FXML
    private TableColumn<PatientTM, String> colPatientId;

    @FXML
    private TableColumn<PatientTM, String> colPhone;

    @FXML
    private TableColumn<PatientTM, String> colRDate;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Label lblPatient;

    @FXML
    private Label lblPatientId;

    @FXML
    private Label lbldate;

    @FXML
    private RadioButton radioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private TableView<PatientTM> tblPatient;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBirth;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "FAILED TO INITIALIZE PATIENT DATA").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isDeleted = patientBO.delete(lblPatientId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "PATIENT DELETED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO DELETE PATIENT...!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        RadioButton selectedRadio = (RadioButton) gender.getSelectedToggle();

        if (selectedRadio == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a gender.").show();
            return;
        }

        String genderText = selectedRadio.getText();
        Date registrationDate = Date.valueOf(LocalDate.now());

        PatientDTO patientDTO = new PatientDTO(
                lblPatientId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                genderText,
                txtBirth.getText(),
                txtPhone.getText(),
                registrationDate
        );

        try {
            boolean isSaved = patientBO.save(patientDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Patient saved successfully!").show();
                refreshPage();
                lblPatientId.setText(patientBO.getNextPatientId());
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save patient").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error occurred while saving patient").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        RadioButton selectedRadio = (RadioButton) gender.getSelectedToggle();

        if (selectedRadio == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a gender.").show();
            return;
        }

        String genderText = selectedRadio.getText();
        Date registrationDate = Date.valueOf(LocalDate.now());

        PatientDTO patientDTO = new PatientDTO(
                lblPatientId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                genderText,
                txtBirth.getText(),
                txtPhone.getText(),
                registrationDate
        );

        boolean isUpdated = patientBO.update(patientDTO);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "PATIENT UPDATED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE PATIENT").show();
        }
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextPatientId();
        loadTableData();

        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtName.clear();
        txtAddress.clear();
        txtBirth.clear();
        txtPhone.clear();
        gender.selectToggle(null);
        lbldate.setText(String.valueOf(LocalDate.now()));
    }

    @FXML
    void onClickTable(MouseEvent event) {
        PatientTM selectedPatient = tblPatient.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            lblPatientId.setText(selectedPatient.getPatientId());
            txtName.setText(selectedPatient.getName());
            txtAddress.setText(selectedPatient.getAddress());
            txtBirth.setText(selectedPatient.getBirth());
            txtPhone.setText(selectedPatient.getPhone());
            lbldate.setText(String.valueOf(selectedPatient.getRegistrationDate()));

            if ("Male".equalsIgnoreCase(selectedPatient.getGender())) {
                gender.selectToggle(radioBtnMale);
            } else {
                gender.selectToggle(radioBtnFemale);
            }

            btnSave.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }
    }

    public void loadNextPatientId() throws SQLException, ClassNotFoundException {
        String nextPatientId = patientBO.getNextPatientId();
        lblPatientId.setText(nextPatientId);
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<PatientDTO> patientsDTOS = patientBO.getAll();
        ObservableList<PatientTM> patientsTMS = FXCollections.observableArrayList();

        for (PatientDTO patientsDTO : patientsDTOS) {
            patientsTMS.add(new PatientTM(
                    patientsDTO.getPatientId(),
                    patientsDTO.getName(),
                    patientsDTO.getAddress(),
                    patientsDTO.getGender(),
                    patientsDTO.getBirth(),
                    patientsDTO.getPhone(),
                    patientsDTO.getRegistrationDate()
            ));
        }
        tblPatient.setItems(patientsTMS);
    }
}
