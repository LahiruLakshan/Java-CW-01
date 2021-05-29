import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindow {

    public void mainWindow(){
        Stage primaryStage = new Stage();
        MortgageCal mortgageCal = new MortgageCal();
        FinanceCal financeCal = new FinanceCal();
        AutoLoanCal autoLoanCal = new AutoLoanCal();

        // Main window elements( Button
        Button btnMortgage = new javafx.scene.control.Button("Mortgage Calculator");        // Open button on mortgage Calculator.
        btnMortgage.setLayoutX(125);
        btnMortgage.setLayoutY(120);
        btnMortgage.setPrefWidth(250);
        btnMortgage.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnFinance = new javafx.scene.control.Button("Finance Calculator");      // Open button on Finance Calculator.
        btnFinance.setLayoutX(125);
        btnFinance.setLayoutY(200);
        btnFinance.setPrefWidth(250);
        btnFinance.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnAutoLoan = new javafx.scene.control.Button("Auto Loan Calculator");       // Open button on Auto Loan Calculator.
        btnAutoLoan.setLayoutX(125);
        btnAutoLoan.setLayoutY(280);
        btnAutoLoan.setPrefWidth(250);
        btnAutoLoan.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnCloseWin = new Button("Exit");
        btnCloseWin.setLayoutX(300);
        btnCloseWin.setLayoutY(400);
        btnCloseWin.setPrefWidth(100);
        btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
        btnCloseWin.setOnAction(event -> primaryStage.close());

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.setStyle("-fx-background-color: #e2cc37;");
        mainLayout.getChildren().addAll(btnMortgage, btnFinance, btnAutoLoan,btnCloseWin);      // 3 buttons add to main window layout
        Scene mainScene = new Scene(mainLayout,500,500);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Calculators");
        primaryStage.show();

        btnMortgage.setOnAction(event -> {      // Open action on mortgage Calculator.
            primaryStage.close();
            mortgageCal.openMortgageWindow();

        });
        btnFinance.setOnAction(event -> {       // Open action on Finance Calculator.
            primaryStage.close();
            financeCal.openFinanceCalculator();

        });
        btnAutoLoan.setOnAction(event -> {      //Open action on Auto loan Calculator
            primaryStage.close();
            autoLoanCal.openAutoLoanCalculator();

        });
    }
}
