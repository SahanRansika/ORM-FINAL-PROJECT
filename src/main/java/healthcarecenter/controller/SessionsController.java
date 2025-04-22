package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SessionsController {

    @FXML
    private Button btnAddTable;

    @FXML
    private Button btnPlace;

    @FXML
    private Button btnRefresh;

    @FXML
    private ComboBox<?> cmbPatientId;

    @FXML
    private ComboBox<?> cmbProgramId;

    @FXML
    private ComboBox<?> cmbTherapistId;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colPatientId;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colPlaceDate;

    @FXML
    private TableColumn<?, ?> colProgramId;

    @FXML
    private TableColumn<?, ?> colSessionDate;

    @FXML
    private TableColumn<?, ?> colSessionId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTherapistId;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private DatePicker datePlace;

    @FXML
    private DatePicker dateSession;

    @FXML
    private HBox lblDuration;

    @FXML
    private Label lblPatientName;

    @FXML
    private Label lblProgramName;

    @FXML
    private Label lblSession;

    @FXML
    private Label lblSessionId;

    @FXML
    private Label lblTherapistName;

    @FXML
    private TableView<?> tblSession;

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

}
