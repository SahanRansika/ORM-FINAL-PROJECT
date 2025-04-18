package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SessionController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private DatePicker datePDate;

    @FXML
    private DatePicker dateSDate;

    @FXML
    private Label lblDuration;

    @FXML
    private Label lblPatientId;

    @FXML
    private Label lblPayment;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblPDate;

    @FXML
    private Label lblProgramId;

    @FXML
    private Label lblSDate;

    @FXML
    private Label lblSessionId;

    @FXML
    private Label lblTherapistId;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView<?> tblSession;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colPatientId;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPDate;

    @FXML
    private TableColumn<?, ?> colProgramId;

    @FXML
    private TableColumn<?, ?> colSDate;

    @FXML
    private TableColumn<?, ?> colSessionId;

    @FXML
    private TableColumn<?, ?> colTherapistId;

    @FXML
    private TableColumn<?, ?> colTotal;


    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPatientId;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtProgramId;

    @FXML
    private TextField txtSessionId;

    @FXML
    private TextField txtTherapistId;

    @FXML
    private TextField txtTotal;

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
//        colSessionId.cellFactoryProperty(new PropertyValueFactory<>("colSessionId"));
//        colProgramId.cellFactoryProperty(new PropertyValueFactory<>("colProgramId"));
//        colTherapistId.cellFactoryProperty(new PropertyValueFactory<>("colTherapistId"));
//        colPatientId.cellFactoryProperty(new PropertyValueFactory<>("colPatientId"));
//        colDuration.cellFactoryProperty(new PropertyValueFactory<>("colDuration"));
//        colPDate.cellFactoryProperty(new PropertyValueFactory<>("colPDate"));
//        colSDate.cellFactoryProperty(new PropertyValueFactory<>("colSDate"));
//        colPhone.cellFactoryProperty(new PropertyValueFactory<>("colPhone"));
//        colPayment.cellFactoryProperty(new PropertyValueFactory<>("colPayment"));
//        colTotal.cellFactoryProperty(new PropertyValueFactory<>("colTotal"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load Session data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtSessionId.clear();
        txtProgramId.clear();
        txtTherapistId.clear();
        txtPatientId.clear();
        txtDuration.clear();
        datePDate.cancelEdit();
        dateSDate.cancelEdit();
        txtPhone.clear();
        txtPayment.clear();
        txtTotal.clear();
    }
}
