package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class HomepageController {

    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane ancMain;

    @FXML
    private AnchorPane ancLoad;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnProgram;

    @FXML
    private Button btnRegistration;

    @FXML
    private Button btnSession;

    @FXML
    private Button btnTherapist;


    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("LOG OUT");
            alert.setHeaderText("Are you sure you want to log out?");

            ButtonType yesButton = new ButtonType("Exit", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(yesButton,noButton);

            var result = alert.showAndWait();

            if (result.isPresent() && result.get() == yesButton){
                System.exit(0);
            } else {
                alert.close();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"An error : " + e.getMessage()).show();
        }
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException{
//        navigateTo("view/homepage.fxml");
    }

    @FXML
    void btnPatientOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/patient.fxml");
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/payment.fxml");
    }

    @FXML
    void btnProgramOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/program.fxml");
    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/registration.fxml");
    }

    @FXML
    void btnSessionOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/session.fxml");
    }

    @FXML
    void btnTherapistOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/therapist.fxml");
    }

    public void navigateTo(String path) throws IOException {
        ancLoad.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        ancLoad.getChildren().add(load);
    }

}
