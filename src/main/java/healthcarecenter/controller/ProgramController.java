package healthcarecenter.controller;

import healthcarecenter.bo.BOFactory;
import healthcarecenter.bo.ProgramBO;
import healthcarecenter.bo.TherapistBO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.TherapistDTO;
import healthcarecenter.dto.tm.ProgramTM;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProgramController implements Initializable {

    @FXML
    private Button btnDelete, btnSave, btnUpdate;

    @FXML
    private TableColumn<ProgramTM, String> colProgramId, colTherapistId, colName, colDuration, colCost, colDesc;

    @FXML
    private Label lblProgramId;

    @FXML
    private TableView<ProgramTM> tblProgram;

    @FXML
    private TextField txtName, txtDuration, txtCost, txtDesc;

    @FXML
    private ComboBox<String> cmbTherapistId;

    ProgramBO programBO = (ProgramBO) BOFactory.getInstance().getBO(BOFactory.BOType.Program);

    TherapistBO therapistBO = (TherapistBO) BOFactory.getInstance().getBO(BOFactory.BOType.Therapist);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Failed to initialize program data.");
        }
    }

    private void initializeTableColumns() {
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colTherapistId.setCellValueFactory(new PropertyValueFactory<>("therapistId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = lblProgramId.getText();
        if (id == null || id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a program to delete.");
            return;
        }

        boolean isDeleted = programBO.delete(id);
        if (isDeleted) {
            showAlert(Alert.AlertType.INFORMATION, "Program deleted successfully.");
            refreshPage();
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to delete program.");
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = getProgramDTOFromInputs();
        if (programDTO == null) return;

        boolean isSaved = programBO.save(programDTO);
        if (isSaved) {
            showAlert(Alert.AlertType.INFORMATION, "Program saved successfully.");
            refreshPage();
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to save program.");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        ProgramDTO programDTO = getProgramDTOFromInputs();
        if (programDTO == null) return;

        boolean isUpdated = programBO.update(programDTO);
        if (isUpdated) {
            showAlert(Alert.AlertType.INFORMATION, "Program updated successfully.");
            refreshPage();
        } else {
            showAlert(Alert.AlertType.ERROR, "Failed to update program.");
        }
    }

    private void loadTherapistIds() throws SQLException,ClassNotFoundException{
        List<TherapistDTO> therapistDTOList = programBO.loadTherapistIds();
        for (TherapistDTO b : therapistDTOList){
            cmbTherapistId.getItems().add(b.getTherapistId());
        }
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        clearForm();
        loadTherapistIds();
        loadTableData();
        loadNextProgramId();
    }

    private void clearForm() {
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

        cmbTherapistId.getSelectionModel().clearSelection();
        txtName.clear();
        txtDuration.clear();
        txtCost.clear();
        txtDesc.clear();
    }

    private ProgramDTO getProgramDTOFromInputs() {
        if (cmbTherapistId.getValue() == null || txtName.getText().isEmpty() ||
                txtDuration.getText().isEmpty() || txtCost.getText().isEmpty() || txtDesc.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please fill in all fields.");
            return null;
        }

        return new ProgramDTO(
                lblProgramId.getText(),
                cmbTherapistId.getValue(),
                txtName.getText(),
                txtDuration.getText(),
                txtCost.getText(),
                txtDesc.getText()
        );
    }

    private void loadNextProgramId() throws SQLException, ClassNotFoundException {
        lblProgramId.setText(programBO.getNextProgramId());
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        List<ProgramDTO> programDTOList = programBO.getAll();
        ObservableList<ProgramTM> programTMs = FXCollections.observableArrayList();

        for (ProgramDTO dto : programDTOList) {
            programTMs.add(new ProgramTM(
                    dto.getProgramId(),
                    dto.getTherapistId(),
                    dto.getName(),
                    dto.getDuration(),
                    dto.getCost(),
                    dto.getDescription()
            ));
        }

        tblProgram.setItems(programTMs);
    }

    @FXML
    void onTableClick(MouseEvent event) {
        ProgramTM selectedProgram = tblProgram.getSelectionModel().getSelectedItem();
        if (selectedProgram == null) return;

        lblProgramId.setText(selectedProgram.getProgramId());
        cmbTherapistId.setValue(selectedProgram.getTherapistId());
        txtName.setText(selectedProgram.getName());
        txtDuration.setText(selectedProgram.getDuration());
        txtCost.setText(selectedProgram.getCost());
        txtDesc.setText(selectedProgram.getDescription());

        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
    }

    @FXML
    void cmbTherapistIdOnAction(ActionEvent event) throws SQLException,ClassNotFoundException{
        String selectedTherapistId = cmbTherapistId.getSelectionModel().getSelectedItem();
        System.out.println("Selected Therapist id" + selectedTherapistId);
        TherapistDTO therapistDTO = therapistBO.findById(selectedTherapistId);

    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).show();
    }
}
