package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.SessionsBO;
import healthcarecenter.dto.tm.SessionsTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.sql.SQLException;;

public class SessionsController {

    @FXML
    private Label Sdate;

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
    private TableColumn<SessionsTM, String> colDuration;

    @FXML
    private TableColumn<SessionsTM, String> colPatientId;

    @FXML
    private TableColumn<SessionsTM, String> colPayment;

    @FXML
    private TableColumn<SessionsTM, String> colPlaceDate;

    @FXML
    private TableColumn<SessionsTM, String> colProgramId;

    @FXML
    private TableColumn<SessionsTM, String> colSessionDate;

    @FXML
    private TableColumn<SessionsTM, String> colSessionId;

    @FXML
    private TableColumn<SessionsTM, String> colStatus;

    @FXML
    private TableColumn<SessionsTM, String> colTherapistId;

    @FXML
    private TableColumn<SessionsTM, String> colTotal;

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
    private TableView<SessionsTM> tblSession;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTotal;

    SessionsBO sessionsBO = (SessionsBO) BOFactory.getInstance().getBO(BOFactory.BOType.Sessions);

    @FXML
    void btnAddTableOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) {

    }

    @FXML
    void btnRefreshOnAction(ActionEvent event) {

    }

    public void loadNextSessionId() throws SQLException, ClassNotFoundException {
        String nextPatientId = sessionsBO.getNextSessionId();
        lblSessionId.setText(nextPatientId);
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextSessionId();
    }

}
