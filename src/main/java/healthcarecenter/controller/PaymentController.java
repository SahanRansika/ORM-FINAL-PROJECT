package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private DatePicker datePayDate;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colPayDate;

    @FXML
    private TableColumn<?, ?> colPaymentId;

    @FXML
    private TableColumn<?, ?> colRId;

    @FXML
    private TableColumn<?, ?> colSessionId;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblPayDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblRId;

    @FXML
    private Label lblSessionId;

    @FXML
    private TableView<?> tblPayment;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtPaymentId;

    @FXML
    private TextField txtRId;

    @FXML
    private TextField txtSessionId;

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
//        colPaymentId.cellFactoryProperty(new PropertyValueFactory<>("colPaymentId"));
//        colRId.cellFactoryProperty(new PropertyValueFactory<>("colRId"));
//        colSessionId.cellFactoryProperty(new PropertyValueFactory<>("colSessionId"));
//        colPayDate.cellFactoryProperty(new PropertyValueFactory<>("colPayDate"));
//        colAmount.cellFactoryProperty(new PropertyValueFactory<>("colAmount"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load payment data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtPaymentId.clear();
        txtRId.clear();
        txtSessionId.clear();
        datePayDate.cancelEdit();
        txtAmount.clear();
    }
}
