package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.ProgramBO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.tm.ProgramTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class ProgramController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<ProgramTM, String> colCost;

    @FXML
    private TableColumn<ProgramTM, String> colDesc;

    @FXML
    private TableColumn<ProgramTM, String> colDuration;

    @FXML
    private TableColumn<ProgramTM, String> colName;

    @FXML
    private TableColumn<ProgramTM, String> colProgramId;

    @FXML
    private TableColumn<ProgramTM, String> colTherapistId;

    @FXML
    private Label lblProgram;

    @FXML
    private Label lblProgramId;

    @FXML
    private TableView<ProgramTM> tblProgram;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> cmbTherapistId;

    ProgramBO programsBO = (ProgramBO) BOFactory.getInstance().getBO(BOFactory.BOType.Program);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colTherapistId.setCellValueFactory(new PropertyValueFactory<>("therapistId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "FAILED TO INITIALIZE PROGRAM DATA").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        boolean isDeleted = programsBO.delete(lblProgramId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "PROGRAM DELETED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO DELETE PROGRAM...!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        ProgramDTO programsDTO = new ProgramDTO(
                lblProgramId.getText(),
                cmbTherapistId.getValue(),
                txtName.getText(),
                txtDuration.getText(),
                txtCost.getText(),
                txtDesc.getText()
        );

        boolean isSaved = programsBO.save(programsDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "PROGRAM SAVED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO SAVE PROGRAM").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        ProgramDTO programsDTO = new ProgramDTO(
                lblProgramId.getText(),
                cmbTherapistId.getValue(),
                txtName.getText(),
                txtDuration.getText(),
                txtCost.getText(),
                txtDesc.getText()
        );

        boolean isUpdated = programsBO.update(programsDTO);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "PROGRAM UPDATED SUCCESS...!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE PROGRAM").show();
        }
    }

    private void refreshPage() throws SQLException,ClassNotFoundException {
//        loadTableData();
        loadNextProgramId();
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(true);

        cmbTherapistId.getSelectionModel().clearSelection();
        txtName.clear();
        txtDuration.clear();
        txtCost.clear();
        txtDesc.clear();
    }

    public void loadNextProgramId() throws SQLException, ClassNotFoundException {
        String nextProgramId = programsBO.getNextProgramId();
        lblProgramId.setText(nextProgramId);
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<ProgramDTO> programDTOS = programsBO.getAll();
        ObservableList<ProgramTM> programTMS = FXCollections.observableArrayList();

        for (ProgramDTO programDTO : programDTOS) {
            programTMS.add(new ProgramTM(
                    programDTO.getProgramId(),
                    programDTO.getTherapistId(),
                    programDTO.getName(),
                    programDTO.getDuration(),
                    programDTO.getCost(),
                    programDTO.getDescription()
            ));
        }
        tblProgram.setItems(programTMS);
    }
}
