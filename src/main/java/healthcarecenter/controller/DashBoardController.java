package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DashBoardController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigateTo("/view/home.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("LOG OUT");
            alert.setHeaderText("ARE YOUR SURE LOGOUT?");

            ButtonType yesButton = new ButtonType("EXIT", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("NO", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(yesButton,noButton);

            var result = alert.showAndWait();

            if (result.isPresent() && result.get() == yesButton){
                System.exit(0);
            } else {
                alert.close();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"AN ERROR : " + e.getMessage()).show();
        }
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/home.fxml");
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
        navigateTo("/view/sessions.fxml");
    }

    @FXML
    void btnTherapistOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/therapist.fxml");
    }

    public void navigateTo(String fxmlPath)  {
        try {
            ancLoad.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.prefWidthProperty().bind(ancLoad.widthProperty());
            load.prefHeightProperty().bind(ancLoad.heightProperty());
            ancLoad.getChildren().add(load);
        } catch (IOException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"FAILED TO LOAD PAGE...!").show();
        }

    }

}
