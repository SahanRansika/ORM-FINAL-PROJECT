package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.impl.PatientBOImpl;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.tm.PatientTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBirth;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPatient;

    @FXML
    private Label lblPatientId;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblRDate;

    @FXML
    private TableView<PatientTM> tblPatient;

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
    private TextField txtAddress;

    @FXML
    private TextField txtBirth;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private DatePicker dateRDate;

    PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("colPatientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("colName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("colAddress"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("colGender"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("colBirth"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("colPhone"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("colRDate"));

        try {
            refreshPage();
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load patient data").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException{
        String id = lblPatientId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"ARE YOU SURE?",ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES){
            boolean isDeleted = patientBO.delete(id);
            if (isDeleted){
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION,"PATIENT DELETED...!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"FAILED TO DELETE PATIENT...!").show();
            }
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String patientId = lblPatientId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String gender = txtGender.getText();
        String birth = txtBirth.getText();
        String phone = txtPhone.getText();
        String rDate = dateRDate.toString();

        PatientDTO patientDTO = new PatientDTO(
                patientId,
                name,
                address,
                gender,
                birth,
                phone,
                rDate
        );
        try {
            boolean isSaved = patientBO.save(patientDTO);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"PATIENT SAVED SUCCESS").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.ERROR,"PATIENT IS NOT SAVED...!").show();
            }
        } catch (IOException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"ERROR SAVING PATIENT DATA.").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String patientId = lblPatientId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String gender = txtGender.getText();
        String birth = txtBirth.getText();
        String phone = txtPhone.getText();
        String rDate = dateRDate.toString();

        PatientDTO patientDTO = new PatientDTO(
                patientId,
                name,
                address,
                gender,
                birth,
                phone,
                rDate
        );
       try {
           boolean isUpdate = patientBO.update(patientDTO);
           if (isUpdate){
               new Alert(Alert.AlertType.CONFIRMATION,"PATIENT UPDATE SUCCESS").show();
               refreshPage();
           } else {
               new Alert(Alert.AlertType.ERROR,"BOOK IS NOT UPDATE...!").show();
           }
       } catch (IOException e){
           e.printStackTrace();
           new Alert(Alert.AlertType.ERROR,"ERROR UPDATE IS PATIENT DATA...!").show();
       }
    }

    private void refreshPage() throws IOException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);
        txtName.clear();
        txtAddress.clear();
        txtGender.clear();
        txtBirth.clear();
        txtPhone.clear();
        dateRDate.cancelEdit();
    }
}
