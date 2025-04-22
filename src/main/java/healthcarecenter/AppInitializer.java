package healthcarecenter;

import healthcarecenter.config.FactoryConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;


public class AppInitializer extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("HEALTH CARE CENTER");
        stage.show();
    }

        public static void main(String[] args)  {
            Session session = FactoryConfiguration.getInstance().getSession();
            launch();
        }

}