package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TherapistController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblAssigned;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblSpec;

    @FXML
    private Label lblTherapistId;

    @FXML
    private Label lblYears;

    @FXML
    private TableView<?> tblTherapist;
    @FXML
    private TableColumn<?, ?> colAssigned;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colSpec;

    @FXML
    private TableColumn<?, ?> colTherapistId;

    @FXML
    private TableColumn<?, ?> colYears;


    @FXML
    private TextField txtAssigned;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtSpec;

    @FXML
    private TextField txtTherapistId;

    @FXML
    private TextField txtYears;

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
//        colTherapistId.cellFactoryProperty(new PropertyValueFactory<>("colTherapistId"));
//        colName.cellFactoryProperty(new PropertyValueFactory<>("colName"));
//        colSpec.cellFactoryProperty(new PropertyValueFactory<>("colSpec"));
//        colYears.cellFactoryProperty(new PropertyValueFactory<>("colYears"));
//        colPhone.cellFactoryProperty(new PropertyValueFactory<>("colPhone"));
//        colAssigned.cellFactoryProperty(new PropertyValueFactory<>("colAssigned"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load Therapist data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtTherapistId.clear();
        txtName.clear();
        txtSpec.clear();
        txtYears.clear();
        txtPhone.clear();
        txtAssigned.clear();
    }
}

