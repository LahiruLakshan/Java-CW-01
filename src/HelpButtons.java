import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpButtons {

   public void helpViewerMortgage(){
       Stage helpViewer = new Stage();

       helpViewer.initModality(Modality.APPLICATION_MODAL);
       helpViewer.setTitle("Mortgage Calculator Instructions");
       helpViewer.setMaxWidth(1010);
       helpViewer.setHeight(400);

       String note = " > The Mortgage Calculator helps estimate the monthly payment due along with other financial costs associated with mortgages. \n" +
               " > There are advanced options to include extra payments or annual percentage increases of common mortgage expenses.\n\n" +
               " 01. Loan amount — the amount borrowed from a lender or bank.\n 02. Down payment — the upfront payment of the purchase, usually a percentage of the total price.\n" +
               " 03. Loan term — the amount of time over which the loan must be repaid in full. The most popular lengths are 30 years and 15 years.\n" +
               " 04. Interest rate — the rate of interest charged by a mortgage lender.\n" +
               " 05. Property taxes — a tax that property owners pay to governing authorities. \n" +
               " 06. Home insurance — an insurance policy that protects the owner from accidents that may happen to their private residence or other real \n" +
               "      estate properties. \n" +
               " 07. Private mortgage insurance (PMI)—protects the mortgage lender if the borrower is unable to repay.\n" +
               " 08. HOA fee — a fee that is imposed on the property owner by an organization that maintains and improves the property and environment\n" +
               "      of the neighborhoods that the specific organization covers. \n" +
               " 09. Other costs — includes utilities, home maintenance costs, and anything pertaining to the general upkeep of the property.";
       Label textFile1 = new Label(note);
       textFile1.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");

       Button OKBtn = new Button("OK");
       OKBtn.setLayoutX(500);
       OKBtn.setLayoutY(320);
       OKBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
       OKBtn.setOnAction(event -> helpViewer.close());

       AnchorPane helpLayout = new AnchorPane();
       helpLayout.setStyle("-fx-background-color: ivory");
       helpLayout.getChildren().addAll(textFile1,OKBtn);

       Scene mortgage = new Scene(helpLayout);
       helpViewer.setScene(mortgage);
       helpViewer.showAndWait();

   }
    public void helpViewerFinance(){
        Stage helpViewer = new Stage();

        helpViewer.initModality(Modality.APPLICATION_MODAL);
        helpViewer.setTitle("Financial Calculator Instructions");
        helpViewer.setMaxWidth(1010);
        helpViewer.setHeight(400);

        String note = " > This finance calculator can be used to calculate any number of the following parameters:\n\n" +
                " 01. future value - (FV)\n" +
                " 02. number of compounding periods - (N)\n" +
                " 03. interest rate - (I/Y)\n" +
                " 04. annuity payment - (PMT)\n" +
                " 05. start principal\n" +
                "\t\tif the other parameters are known. Each of the following tabs represents the parameters to be calculated.";
        Label textFile1 = new Label(note);
        textFile1.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");

        Button OKBtn = new Button("OK");
        OKBtn.setLayoutX(500);
        OKBtn.setLayoutY(320);
        OKBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        OKBtn.setOnAction(event -> helpViewer.close());

        AnchorPane helpLayout = new AnchorPane();
        helpLayout.setStyle("-fx-background-color: ivory");
        helpLayout.getChildren().addAll(textFile1,OKBtn);

        Scene mortgage = new Scene(helpLayout);
        helpViewer.setScene(mortgage);
        helpViewer.showAndWait();

    }
    public void helpViewerAutoLoan(){
        Stage helpViewer = new Stage();

        helpViewer.initModality(Modality.APPLICATION_MODAL);
        helpViewer.setTitle("Auto Loan Calculator Instructions");
        helpViewer.setMaxWidth(1010);
        helpViewer.setHeight(400);

        String note = "Auto Loans\n\n" +
                "\tMost people turn to auto loans during vehicle purchase. They work as any generic, secured loan from a financial institution does with\n" +
                " a typical term of 36 or 60 months. Each month, repayment of principal and interest must be made from borrowers to auto loan lenders.\n" +
                " Money borrowed from a lender that isn't paid back can result in the car being legally repossessed. ";
        Label textFile1 = new Label(note);
        textFile1.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");

        Button OKBtn = new Button("OK");
        OKBtn.setLayoutX(500);
        OKBtn.setLayoutY(320);
        OKBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        OKBtn.setOnAction(event -> helpViewer.close());

        AnchorPane helpLayout = new AnchorPane();
        helpLayout.setStyle("-fx-background-color: ivory");
        helpLayout.getChildren().addAll(textFile1,OKBtn);

        Scene mortgage = new Scene(helpLayout);
        helpViewer.setScene(mortgage);
        helpViewer.showAndWait();

    }
}
