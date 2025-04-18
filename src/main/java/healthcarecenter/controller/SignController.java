package healthcarecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignController implements Initializable {

    @FXML
    private AnchorPane ancMain;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignup;

    @FXML
    private ImageView imgMain;

    @FXML
    private TextField txtContact;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException{
        navigateTo("/view/login.fxml");
    }

    @FXML
    void btnSignupOnAction(ActionEvent event) {

    }

    @FXML
    void contactOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void passwordOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void roleOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void usernameOnKeyReleased(MouseDragEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void navigateTo(String path) throws IOException {
        ancMain.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        ancMain.getChildren().add(load);
    }
}
