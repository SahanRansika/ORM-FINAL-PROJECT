package healthcarecenter.controller;

import healthcarecenter.dto.tm.RegistrationTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnUpdate;

    @FXML
    private DatePicker dateDate;

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

    @FXML
    private TableColumn<RegistrationTM, String> colDate;

    @FXML
    private TableColumn<RegistrationTM, String> colPatientId;

    @FXML
    private TableColumn<RegistrationTM, String> colProgramId;

    @FXML
    private TableColumn<RegistrationTM, String> colRId;

    @FXML
    private TextField txtPatientId;

    @FXML
    private TextField txtProgramId;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        colRId.cellFactoryProperty(new PropertyValueFactory<>("colRId"));
//        colPatientId.cellFactoryProperty(new PropertyValueFactory<>("colPatientId"));
//        colProgramId.cellFactoryProperty(new PropertyValueFactory<>("colProgramId"));
//        colDate.cellFactoryProperty(new PropertyValueFactory<>("colDate"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load Registration data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnRegister.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtPatientId.clear();
        txtProgramId.clear();
        dateDate.cancelEdit();
    }
}
