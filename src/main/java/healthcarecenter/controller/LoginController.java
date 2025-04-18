package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane ancMain;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSign;

    @FXML
    private Text textAccount;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    private static final double DEFAULT_WIDTH = 1380;
    private static final double DEFAULT_HEIGHT = 810;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException{
        navigateToHome("/view/homepage.fxml");
    }

    @FXML
    void btnSignOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/sign.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void navigateToHome(String path) throws IOException {
        ancMain.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        ancMain.getChildren().add(load);
        Stage currentStage =(Stage)ancMain.getScene().getWindow();
        currentStage.setWidth(DEFAULT_WIDTH);
        currentStage.setHeight(DEFAULT_HEIGHT);
        currentStage.setResizable(false);
        currentStage.show();
    }

    public void navigateTo(String path) throws IOException {
        ancMain.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        ancMain.getChildren().add(load);
    }
}
