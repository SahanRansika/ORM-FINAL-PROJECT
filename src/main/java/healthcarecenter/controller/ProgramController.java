package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProgramController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblDuration;

    @FXML
    private Label lblName;

    @FXML
    private Label lblProgramId;

    @FXML
    private Label lblTherapistId;

    @FXML
    private TableView<?> tblProgram;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colProgramId;

    @FXML
    private TableColumn<?, ?> colTherapistId;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtProgramId;

    @FXML
    private TextField txtTherapistId;

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
//        colProgramedId.cellFactoryProperty(new PropertyValueFactory<>("colProgramedId"));
//        colTherapistId.cellFactoryProperty(new PropertyValueFactory<>("colTherapistId"));
//        colName.cellFactoryProperty(new PropertyValueFactory<>("colName"));
//        colDuration.cellFactoryProperty(new PropertyValueFactory<>("colDuration"));
//        colCost.cellFactoryProperty(new PropertyValueFactory<>("colCost"));
//        colDesc.cellFactoryProperty(new PropertyValueFactory<>("colDesc"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load Program data").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        txtProgramId.clear();
        txtTherapistId.clear();
        txtName.clear();
        txtDuration.clear();
        txtCost.clear();
        txtDesc.clear();
    }
}
