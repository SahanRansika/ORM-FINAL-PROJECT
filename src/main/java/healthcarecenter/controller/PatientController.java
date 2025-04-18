package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
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
    private Label lblPatientId;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblRDate;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBirth;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPatientId;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colRDate;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBirth;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPatientId;

    @FXML
    private TextField txtPhone;

    @FXML
    private DatePicker dateRDate;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        colPatientId.cellFactoryProperty(new PropertyValueFactory<>("colPatientId"));
//        colName.cellFactoryProperty(new PropertyValueFactory<>("colName"));
//        colAddress.cellFactoryProperty(new PropertyValueFactory<>("colAddress"));
//        colGender.cellFactoryProperty(new PropertyValueFactory<>("colGender"));
//        colBirth.cellFactoryProperty(new PropertyValueFactory<>("colBirth"));
//        colPhone.cellFactoryProperty(new PropertyValueFactory<>("colPhone"));
//        colRDate.cellFactoryProperty(new PropertyValueFactory<>("colRDate"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load patient data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtPatientId.clear();
        txtName.clear();
        txtAddress.clear();
        txtGender.clear();
        txtBirth.clear();
        txtPhone.clear();
        dateRDate.cancelEdit();
    }

}
