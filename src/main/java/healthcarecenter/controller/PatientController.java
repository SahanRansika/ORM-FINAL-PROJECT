package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.PatientBO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.tm.PatientTM;
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
    private Button btnDelete, btnSave, btnUpdate;

    @FXML
    private TableColumn<PatientTM, String> colAddress, colBirth, colGender, colName, colPatientId, colPhone, colRDate;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Label lblPatient, lblPatientId, lbldate;

    @FXML
    private RadioButton radioBtnFemale, radioBtnMale;

    @FXML
    private TableView<PatientTM> tblPatient;

    @FXML
    private TextField txtAddress, txtName, txtPhone;

    @FXML
    private DatePicker txtBirth;

    private final PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Failed to initialize patient data.");
        }
    }

    private void initializeTableColumns() {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (patientBO.delete(lblPatientId.getText())) {
            showAlert(Alert.AlertType.INFORMATION, "Patient deleted successfully.");
            refreshPage();
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to delete patient.");
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        PatientDTO patientDTO = getPatientDTOFromInputs();
        if (patientDTO == null) return;

        try {
            if (patientBO.save(patientDTO)) {
                showAlert(Alert.AlertType.INFORMATION, "Patient saved successfully.");
                refreshPage();
                lblPatientId.setText(patientBO.getNextPatientId());
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to save patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error occurred while saving patient.");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        PatientDTO patientDTO = getPatientDTOFromInputs();
        if (patientDTO == null) return;

        if (patientBO.update(patientDTO)) {
            showAlert(Alert.AlertType.INFORMATION, "Patient updated successfully.");
            refreshPage();
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to update patient.");
        }
    }

    private PatientDTO getPatientDTOFromInputs() {
        // Ensure gender is selected
        RadioButton selectedRadio = (RadioButton) gender.getSelectedToggle();
        if (selectedRadio == null) {
            showAlert(Alert.AlertType.WARNING, "Please select a gender.");
            return null;
        }

        if (txtBirth.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Please select birth date.");
            return null;
        }

        // Convert birth LocalDate to java.sql.Date
        Date birthDate = Date.valueOf(txtBirth.getValue());

        return new PatientDTO(
                lblPatientId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                selectedRadio.getText(), // Get the selected gender
                birthDate, // Store the birth as java.sql.Date
                txtPhone.getText(),
                Date.valueOf(LocalDate.now()) // Assuming current date as registration date
        );
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextPatientId();
        loadTableData();
        clearForm();
    }

    private void clearForm() {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtName.clear();
        txtAddress.clear();
        txtBirth.setValue(null);
        txtPhone.clear();
        gender.selectToggle(null);
        lbldate.setText(LocalDate.now().toString());
    }

    @FXML
    void onClickTable(MouseEvent event) {
        PatientTM selectedPatient = tblPatient.getSelectionModel().getSelectedItem();
        if (selectedPatient == null) return;

        lblPatientId.setText(selectedPatient.getPatientId());
        txtName.setText(selectedPatient.getName());
        txtAddress.setText(selectedPatient.getAddress());
        txtBirth.cancelEdit();
        txtPhone.setText(selectedPatient.getPhone());
        lbldate.setText(String.valueOf(selectedPatient.getRegistrationDate()));

        // Set selected gender
        if ("Male".equalsIgnoreCase(selectedPatient.getGender())) {
            gender.selectToggle(radioBtnMale);
        } else if ("Female".equalsIgnoreCase(selectedPatient.getGender())) {
            gender.selectToggle(radioBtnFemale);
        }

        btnSave.setDisable(true);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
    }

    private void loadNextPatientId() throws SQLException, ClassNotFoundException {
        lblPatientId.setText(patientBO.getNextPatientId());
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<PatientDTO> patientDTOList = patientBO.getAll();
        ObservableList<PatientTM> patientTMList = FXCollections.observableArrayList();

        for (PatientDTO dto : patientDTOList) {
            patientTMList.add(new PatientTM(
                    dto.getPatientId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getGender(),
                    dto.getBirth(),
                    dto.getPhone(),
                    dto.getRegistrationDate()
            ));
        }
        tblPatient.setItems(patientTMList);
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).show();
    }
}
