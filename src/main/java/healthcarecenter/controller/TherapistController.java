package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.TherapistBO;
import healthcarecenter.dto.TherapistDTO;
import healthcarecenter.dto.tm.TherapistTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private Label lblTherapist;

    @FXML
    private Label lblTherapistId;

    @FXML
    private Label lblYears;

    @FXML
    private TableView<TherapistTM> tblTherapist;

    @FXML
    private TableColumn<TherapistTM, String> colAssigned;

    @FXML
    private TableColumn<TherapistTM, String> colName;

    @FXML
    private TableColumn<TherapistTM, String> colPhone;

    @FXML
    private TableColumn<TherapistTM, String> colSpec;

    @FXML
    private TableColumn<TherapistTM, String> colTherapistId;

    @FXML
    private TableColumn<TherapistTM, String> colYears;


    @FXML
    private TextField txtAssigned;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtSpec;

    @FXML
    private TextField txtYears;

    TherapistBO therapistBO = (TherapistBO) BOFactory.getInstance().getBO(BOFactory.BOType.Therapist);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTherapistId.setCellValueFactory(new PropertyValueFactory<>("therapistId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSpec.setCellValueFactory(new PropertyValueFactory<>("spec"));
        colYears.setCellValueFactory(new PropertyValueFactory<>("years"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAssigned.setCellValueFactory(new PropertyValueFactory<>("assigned"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "FAILED TO INITIALIZE THERAPIST DATA").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        boolean isDeleted = therapistBO.delete(lblTherapistId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "THERAPIST DELETED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO DELETE THERAPIST...!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        TherapistDTO therapistDTO = new TherapistDTO(
                lblTherapistId.getText(),
                txtName.getText(),
                txtSpec.getText(),
                txtYears.getText(),
                txtPhone.getText(),
                txtAssigned.getText()
        );

        boolean isSaved = therapistBO.save(therapistDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "THERAPIST SAVED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO SAVE THERAPIST").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        TherapistDTO therapistDTO = new TherapistDTO(
                lblTherapistId.getText(),
                txtName.getText(),
                txtSpec.getText(),
                txtYears.getText(),
                txtPhone.getText(),
                txtAssigned.getText()
        );

        boolean isUpdated = therapistBO.update(therapistDTO);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "THERAPIST UPDATED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE THERAPIST").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
        loadNextTherapistId();
        loadTableData();
        btnDelete.setDisable(true);
        btnUpdate.setDisable(false);
        btnSave.setDisable(false);

        txtName.clear();
        txtSpec.clear();
        txtYears.clear();
        txtPhone.clear();
        txtAssigned.clear();
    }

    public void loadNextTherapistId() throws SQLException, ClassNotFoundException {
        String nextTherapistId = therapistBO.getNextTherapistId();
        lblTherapistId.setText(nextTherapistId);
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<TherapistDTO> therapistDTOS = therapistBO.getAll();
        ObservableList<TherapistTM> therapistTMS = FXCollections.observableArrayList();

        for (TherapistDTO therapistDTO : therapistDTOS) {
            therapistTMS.add(new TherapistTM(
                    therapistDTO.getTherapistId(),
                    therapistDTO.getName(),
                    therapistDTO.getSpec(),
                    therapistDTO.getYears(),
                    therapistDTO.getPhone(),
                    therapistDTO.getAssigned()
            ));
        }
        tblTherapist.setItems(therapistTMS);
    }
}

