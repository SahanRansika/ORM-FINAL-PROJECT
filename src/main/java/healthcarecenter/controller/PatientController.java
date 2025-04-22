package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.impl.PatientBOImpl;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.tm.PatientTM;
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
import java.util.Date;
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
    private TableColumn<PatientTM, Date> colRDate;

    @FXML
    private DatePicker date;

    @FXML
    private Label lblPatient;

    @FXML
    private Label lblPatientId;

    @FXML
    private TableView<PatientTM> tblPatient;

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
    PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.Patient);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("date"));

       refreshPage();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException {
        boolean b = patientBO.deletePatient(lblPatientId.getText());

        if (b){
                new Alert(Alert.AlertType.INFORMATION,"PATIENT DELETED SUCCESS...!").show();
                refreshPage();
            }else {
                new Alert(Alert.AlertType.ERROR,"FAILED TO DELETE PATIENT...!").show();
            }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
    }

    void refreshPage(){
        try {
            List<PatientDTO> allPatient = patientBO.getAllPatient();
            ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();
            for (PatientDTO patientDto : allPatient){
                PatientTM patientTM = new PatientTM(
                        patientDto.getPatientId(),
                        patientDto.getName(),
                        patientDto.getAddress(),
                        patientDto.getGender(),
                        patientDto.getBirth(),
                        patientDto.getPhone(),
                        patientDto.getRDate()
                );
                patientTMS.add(patientTM);
            }
            tblPatient.setItems(patientTMS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
