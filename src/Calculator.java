import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.mainWindow();                //Call to Main window Class
    }
}
