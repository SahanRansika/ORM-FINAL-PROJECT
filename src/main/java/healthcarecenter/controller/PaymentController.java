package healthcarecenter.controller;

import healthcarecenter.dto.tm.PaymentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbPaymentId;

    @FXML
    private TableColumn<PaymentTM, Double> colAmount;

    @FXML
    private TableColumn<PaymentTM, String> colPaymentId;

    @FXML
    private TableColumn<PaymentTM, String> colProgramId;

    @FXML
    private TableColumn<PaymentTM, String> colSessionId;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblRId;

    @FXML
    private Label lblSessionId;

    @FXML
    private TableView<PaymentTM> tblPayment;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtProgramId;

    @FXML
    private TextField txtSessionId;

    private ObservableList<PaymentTM> paymentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colSessionId.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("payment"));
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException,ClassNotFoundException {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{

    }

    @FXML
    void onClickTable(MouseEvent event) {

    }

    @FXML
    void btnRefreshOnAction(ActionEvent event) {

    }
}
