package healthcarecenter.controller;

import healthcarecenter.dto.tm.SessionTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionController implements Initializable {

    @FXML
    private Button btnAddTable;

    @FXML
    private Button btnPlace;

    @FXML
    private Button btnRefresh;

    @FXML
    private ComboBox<String> cmbPatientId;

    @FXML
    private ComboBox<String> cmbProgramId;

    @FXML
    private ComboBox<String> cmbTherapistId;

    @FXML
    private TableColumn<SessionTM, String> colDuration;

    @FXML
    private TableColumn<SessionTM, String> colPatientId;

    @FXML
    private TableColumn<SessionTM, String> colPayment;

    @FXML
    private TableColumn<SessionTM, String> colPaymentId;

    @FXML
    private TableColumn<SessionTM, String> colPlaceDate;

    @FXML
    private TableColumn<SessionTM, String> colProgramId;

    @FXML
    private TableColumn<SessionTM, String> colSessionDate;

    @FXML
    private TableColumn<SessionTM, String> colSessionId;

    @FXML
    private TableColumn<SessionTM, String> colStatus;

    @FXML
    private TableColumn<SessionTM, String> colTherapistId;

    @FXML
    private TableColumn<SessionTM, String> colTotal;

    @FXML
    private DatePicker datePlace;

    @FXML
    private DatePicker dateSession;

    @FXML
    private HBox lblDuration;

    @FXML
    private Label lblPatientName;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblProgramName;

    @FXML
    private Label lblSession;

    @FXML
    private Label lblSessionId;

    @FXML
    private Label lblTherapistName;

    @FXML
    private TableView<SessionTM> tblSession;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTotal;

    @FXML
    void btnAddTableOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) {

    }

    @FXML
    void btnRefreshOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
