package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class HomeController {

    @FXML
    private AnchorPane ancLoad;

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
    private ImageView imgHome;

    @FXML
    private Label lblHome;

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
    void btnTherapistOnAction(ActionEvent event) throws IOException {
        navigateTo("/view/therapist.fxml");
    }

    public void navigateTo(String path) throws IOException {
        ancLoad.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        ancLoad.getChildren().add(load);
    }

}
