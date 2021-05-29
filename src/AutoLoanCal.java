import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AutoLoanCal {

    AnchorPane totalPriceLayout,monthlyPaymentLayout;
    // Public to 3 calculators
    Label lb1,lb2,lb3,lb4,lb4_2,lb5,lb6,lb7,lb8;
    Label lbLoanTerm,lbIntRate,lbDownPay,lbTradeValue,lbYourState,lbSalesTax,lbOtherFees;

    //Auto Loan 1st Tab
    Label lbHeadTab01,lb01ALTab1,lb02ALTab1,lb03ALTab1,lb04ALTab1,lb05ALTab1,lb06ALTab1;
    TextField txtTab01AutoPrice,txtTab01LoanTerm,txtTab01IntRate,txtTab01DownPay,txtTab01TradeValue,txtTab01SalesTax,txtTab01OtherFees;

    //Auto Loan 2nd Tab
    Label lbHeadTab02,lb01ALTab2,lb02ALTab2,lb03ALTab2,lb04ALTab2,lb05ALTab2,lb06ALTab2;
    TextField txtTab02MonthlyPay,txtTab02LoanTerm,txtTab02IntRate,txtTab02DownPay,txtTab02TradeValue,txtTab02SalesTax,txtTab02OtherFees;


    double autoPrice,monthlyPay, loanTerms, interestRate, downPay, tradeValue, salesTax, otherFee;
    public void openAutoLoanCalculator(){
        Stage autoLoanWindow = new Stage();
        autoLoanWindow.setMaxWidth(1160);
        autoLoanWindow.setMaxHeight(500);
        KeyBoard keyBoard = new KeyBoard();
        VBox keyBord = keyBoard.cal();
        HelpButtons viewer = new HelpButtons();

        Button helpBtn = new Button("Help Viewer");         // set Help viewer
        helpBtn.setLayoutX(962);
        helpBtn.setLayoutY(370);
        helpBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        helpBtn.setOnAction(event -> viewer.helpViewerAutoLoan());

        tabTotalPrice();        // total price Tab call
        tabMonthlyPayment();        // Monthly payment Tab call

        Button btnBack = new Button("Back To Home");        // back button
        btnBack.setLayoutX(525);
        btnBack.setLayoutY(400);
        btnBack.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnBack.setOnAction(event -> {
            MainWindow mainWindow = new MainWindow();
            autoLoanWindow.close();
            mainWindow.mainWindow();
        });

        Button btnCloseWin = new Button("Close");       // Close button
        btnCloseWin.setLayoutX(675);
        btnCloseWin.setLayoutY(400);
        btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnCloseWin.setOnAction(event -> autoLoanWindow.close());

        Tab totalPriceTab = new Tab("Total Price");         // Total Price Tab
        totalPriceTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        totalPriceTab.setContent(totalPriceLayout);
        Tab monthlyPaymentTab = new Tab(" Monthly Payment");            // Monthly Payment tab
        monthlyPaymentTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        monthlyPaymentTab.setContent(monthlyPaymentLayout);

        TabPane autoLoanTabPane = new TabPane();        // Auto Loan Calculator  TabPane
        autoLoanTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        autoLoanTabPane.getTabs().addAll(totalPriceTab,monthlyPaymentTab);
        autoLoanTabPane.setPrefSize(900,600);

        AnchorPane autoLoanLayout = new AnchorPane();
        autoLoanLayout.setStyle("-fx-background-color: #e2cc37;");
        autoLoanLayout.getChildren().addAll(autoLoanTabPane,btnBack,btnCloseWin,keyBord,helpBtn);
        Scene autoLoanScene = new Scene(autoLoanLayout,1160,500);                       // Auto Loan Stage scene

        autoLoanWindow.setScene(autoLoanScene);
        autoLoanWindow.setTitle("Auto Loan Calculator");
        autoLoanWindow.show();          // Auto Loan Window Show
    }
    public void tabTotalPrice(){

        //Total Price Tab Containers Create
        Label lbAutoPrice = new Label("Auto Price");
        lbAutoPrice.setStyle("-fx-font-size: 15;");
        lbLoanTerm = new Label("Loan Term");
        lbLoanTerm.setStyle("-fx-font-size: 15;");
        lbIntRate = new Label("Interest Rate");
        lbIntRate.setStyle("-fx-font-size: 15;");
        lbDownPay = new Label("Down Payment");
        lbDownPay.setStyle("-fx-font-size: 15;");
        lbTradeValue = new Label("Trade-in Value");
        lbTradeValue.setStyle("-fx-font-size: 15;");
        lbYourState = new Label("Your State");
        lbYourState.setStyle("-fx-font-size: 15;");
        lbSalesTax = new Label("Sales Tax");
        lbSalesTax.setStyle("-fx-font-size: 15;");
        lbOtherFees = new Label("Title, Registration\nand Other Fees");
        lbOtherFees.setStyle("-fx-font-size: 15;");
        txtTab01AutoPrice = new TextField();
        txtTab01LoanTerm = new TextField();
        txtTab01IntRate = new TextField();
        txtTab01DownPay = new TextField();
        txtTab01TradeValue = new TextField();
        ComboBox<String> comTab01YourState = new ComboBox<>();
        comTab01YourState.setPrefWidth(150);
        txtTab01SalesTax = new TextField();
        txtTab01OtherFees = new TextField();
        Button btnCalculateTab01 = new Button("Calculate");

        lbAutoPrice.setLayoutX(20); // Containers Set to Layout
        lbAutoPrice.setLayoutY(30);
        lbLoanTerm.setLayoutX(20);
        lbLoanTerm.setLayoutY(60);
        lbIntRate.setLayoutX(20);
        lbIntRate.setLayoutY(90);
        lbDownPay.setLayoutX(20);
        lbDownPay.setLayoutY(120);
        lbTradeValue.setLayoutX(20);
        lbTradeValue.setLayoutY(150);
        lbYourState.setLayoutX(20);
        lbYourState.setLayoutY(180);
        lbSalesTax.setLayoutX(20);
        lbSalesTax.setLayoutY(210);
        lbOtherFees.setLayoutX(20);
        lbOtherFees.setLayoutY(240);

        txtTab01AutoPrice.setLayoutX(150);
        txtTab01AutoPrice.setLayoutY(25);
        txtTab01AutoPrice.setStyle("-fx-font-weight: bold");
        txtTab01AutoPrice.setPromptText(" $");
        txtTab01LoanTerm.setLayoutX(150);
        txtTab01LoanTerm.setLayoutY(55);
        txtTab01LoanTerm.setStyle("-fx-font-weight: bold");
        txtTab01LoanTerm.setPromptText(" Months");
        txtTab01IntRate.setLayoutX(150);
        txtTab01IntRate.setLayoutY(85);
        txtTab01IntRate.setStyle("-fx-font-weight: bold");
        txtTab01IntRate.setPromptText(" %");
        txtTab01DownPay.setLayoutX(150);
        txtTab01DownPay.setLayoutY(115);
        txtTab01DownPay.setStyle("-fx-font-weight: bold");
        txtTab01DownPay.setPromptText(" $");
        txtTab01TradeValue.setLayoutX(150);
        txtTab01TradeValue.setLayoutY(145);
        txtTab01TradeValue.setStyle("-fx-font-weight: bold");
        txtTab01TradeValue.setPromptText(" $");

        comTab01YourState.setPrefWidth(160);
        comTab01YourState.getItems().addAll("-- Select --","Central Province","Eastern Province","Northern Province","Southern Province","Western Province","North Western Province","North Central Province","Uva Province","Sabaragamuwa Province ");
        comTab01YourState.setValue("-- Select --");
        comTab01YourState.setLayoutX(150);
        comTab01YourState.setLayoutY(175);

        txtTab01SalesTax.setLayoutX(150);
        txtTab01SalesTax.setLayoutY(205);
        txtTab01SalesTax.setStyle("-fx-font-weight: bold");
        txtTab01SalesTax.setPromptText(" %");
        txtTab01OtherFees.setLayoutX(150);
        txtTab01OtherFees.setLayoutY(235);
        txtTab01OtherFees.setStyle("-fx-font-weight: bold");
        txtTab01OtherFees.setPromptText(" $");


        //Auto Loan Containers in this Pane
        Pane totalPricePane = new Pane();
        totalPricePane.setStyle("-fx-background-color: #6495ed;");
        totalPricePane.getChildren().addAll(lbAutoPrice,lbLoanTerm,lbIntRate,lbDownPay,lbTradeValue,
                lbYourState,lbSalesTax,lbOtherFees,txtTab01AutoPrice,txtTab01LoanTerm,txtTab01IntRate,
                txtTab01DownPay,txtTab01TradeValue,comTab01YourState,txtTab01SalesTax,txtTab01OtherFees,btnCalculateTab01);
        totalPricePane.setLayoutX(20);
        totalPricePane.setLayoutY(20);
        totalPricePane.setPrefSize(320,370);

        publicContainers();

        lb1.setText(" Total Loan Amount");
        lb2.setText(" Sale Tax");
        lb3.setText(" Upfront Payment");
        lb5.setText(" Total Loan Interest");
        lb6.setText(" Total Cost (price, interest, tax, fees)");

        btnCalculateTab01.setLayoutX(100);
        btnCalculateTab01.setLayoutY(300);
        btnCalculateTab01.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnCalculateTab01.setOnAction(event -> totalPriceCalculation());

        lbHeadTab01 = new Label();
        lbHeadTab01.setText(" Monthly Pay ");
        lbHeadTab01.setStyle("-fx-background-color: #138013;"+ "-fx-font-size: 20;"+"-fx-font-weight: bold;");
        lbHeadTab01.setLayoutX(425);
        lbHeadTab01.setLayoutY(20);
        lbHeadTab01.setMinWidth(385);

        lb4 = new Label(" Total of 60 Loan Payments");
        lb4.setLayoutX(425);
        lb4.setLayoutY(160);
        lb4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb4.setMinWidth(275);

        lb01ALTab1 = new Label();
        lb01ALTab1.setLayoutX(710);
        lb01ALTab1.setLayoutY(70);
        lb01ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb01ALTab1.setMinWidth(100);

        lb02ALTab1 = new Label();
        lb02ALTab1.setLayoutX(710);
        lb02ALTab1.setLayoutY(100);
        lb02ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb02ALTab1.setMinWidth(100);

        lb03ALTab1 = new Label();
        lb03ALTab1.setLayoutX(710);
        lb03ALTab1.setLayoutY(130);
        lb03ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb03ALTab1.setMinWidth(100);

        lb04ALTab1 = new Label();
        lb04ALTab1.setLayoutX(710);
        lb04ALTab1.setLayoutY(160);
        lb04ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb04ALTab1.setMinWidth(100);

        lb05ALTab1 = new Label();
        lb05ALTab1.setLayoutX(710);
        lb05ALTab1.setLayoutY(190);
        lb05ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb05ALTab1.setMinWidth(100);

        lb06ALTab1 = new Label();
        lb06ALTab1.setLayoutX(710);
        lb06ALTab1.setLayoutY(220);
        lb06ALTab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06ALTab1.setAlignment(Pos.CENTER_RIGHT);
        lb06ALTab1.setMinWidth(100);

        totalPriceLayout = new AnchorPane();
        totalPriceLayout.setStyle("-fx-background-color: #e2cc37;");
        totalPriceLayout.getChildren().addAll(totalPricePane,lbHeadTab01,lb1,lb2,lb3,lb4,lb5,lb6,lb01ALTab1,lb02ALTab1,lb03ALTab1,lb04ALTab1,lb05ALTab1,lb06ALTab1);
        totalPriceLayout.setLayoutX(350);
        totalPriceLayout.setLayoutY(200);
    }
    public void totalPriceCalculation(){

        // Total Price Calculation
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {
            autoPrice = Double.parseDouble(txtTab01AutoPrice.getText());
            loanTerms = Double.parseDouble(txtTab01LoanTerm.getText());
            interestRate = Double.parseDouble(txtTab01IntRate.getText());
            downPay = Double.parseDouble(txtTab01DownPay.getText());
            tradeValue = Double.parseDouble(txtTab01TradeValue.getText());
            salesTax = Double.parseDouble(txtTab01SalesTax.getText());
            otherFee = Double.parseDouble(txtTab01OtherFees.getText());


            //formula

            double interestMonthly = (interestRate / 100) / 12;
            double totalLoanAmount = autoPrice - downPay - tradeValue;
            double autoLoanMonthlyPay = (totalLoanAmount * interestMonthly) / (1 - Math.pow(1 + interestMonthly, -loanTerms));
            double saleTax = (autoPrice - tradeValue) * (salesTax / 100);
            double upfrontPay = saleTax + downPay + otherFee;
            double totalLoanPay = autoLoanMonthlyPay * loanTerms;
            double totalLoanInterest = totalLoanPay - totalLoanAmount;
            double totalCost = autoPrice + totalLoanInterest + saleTax + otherFee;

            //value set labels

            lbHeadTab01.setText(String.format("Monthly Pay: $" + "%.2f", autoLoanMonthlyPay));
            lb01ALTab1.setText(String.format("$" + "%.2f", totalLoanAmount));
            lb02ALTab1.setText(String.format("$" + "%.2f", saleTax));
            lb03ALTab1.setText(String.format("$" + "%.2f", upfrontPay));
            lb04ALTab1.setText(String.format("$" + "%.2f", totalLoanPay));
            lb05ALTab1.setText(String.format("$" + "%.2f", totalLoanInterest));
            lb06ALTab1.setText(String.format("$" + "%.2f", totalCost));
            lb4.setText("Total of "+(int)loanTerms+" Loan Payments");
        }catch (Exception error) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }
    public void tabMonthlyPayment(){

        //Monthly Payment tab start
        publicContainers();

        Label lbMonthlyPay = new Label("Monthly Pay");
        lbMonthlyPay.setStyle("-fx-font-size: 15;");
        lbLoanTerm = new Label("Loan Term");
        lbLoanTerm.setStyle("-fx-font-size: 15;");
        lbIntRate = new Label("Interest Rate");
        lbIntRate.setStyle("-fx-font-size: 15;");
        lbDownPay = new Label("Down Payment");
        lbDownPay.setStyle("-fx-font-size: 15;");
        lbTradeValue = new Label("Trade-in Value");
        lbTradeValue.setStyle("-fx-font-size: 15;");
        lbYourState = new Label("Your State");
        lbYourState.setStyle("-fx-font-size: 15;");
        lbSalesTax = new Label("Sales Tax");
        lbSalesTax.setStyle("-fx-font-size: 15;");
        lbOtherFees = new Label("Title, Registration\nand Other Fees");
        lbOtherFees.setStyle("-fx-font-size: 15;");

        txtTab02MonthlyPay = new TextField();
        txtTab02LoanTerm = new TextField();
        txtTab02IntRate = new TextField();
        txtTab02DownPay = new TextField();
        txtTab02TradeValue = new TextField();
        ComboBox<String> comTab02YourState = new ComboBox<>();
        txtTab02SalesTax = new TextField();
        txtTab02OtherFees = new TextField();
        Button btnCalculateTab02 = new Button("Calculate");

        lbMonthlyPay.setLayoutX(20);
        lbMonthlyPay.setLayoutY(30);
        lbLoanTerm.setLayoutX(20);
        lbLoanTerm.setLayoutY(60);
        lbIntRate.setLayoutX(20);
        lbIntRate.setLayoutY(90);
        lbDownPay.setLayoutX(20);
        lbDownPay.setLayoutY(120);
        lbTradeValue.setLayoutX(20);
        lbTradeValue.setLayoutY(150);
        lbYourState.setLayoutX(20);
        lbYourState.setLayoutY(180);
        lbSalesTax.setLayoutX(20);
        lbSalesTax.setLayoutY(210);
        lbOtherFees.setLayoutX(20);
        lbOtherFees.setLayoutY(240);

        txtTab02MonthlyPay.setLayoutX(150);
        txtTab02MonthlyPay.setLayoutY(25);
        txtTab02MonthlyPay.setStyle("-fx-font-weight: bold");
        txtTab02MonthlyPay.setPromptText(" $");
        txtTab02LoanTerm.setLayoutX(150);
        txtTab02LoanTerm.setLayoutY(55);
        txtTab02LoanTerm.setStyle("-fx-font-weight: bold");
        txtTab02LoanTerm.setPromptText(" Months");
        txtTab02IntRate.setLayoutX(150);
        txtTab02IntRate.setLayoutY(85);
        txtTab02IntRate.setStyle("-fx-font-weight: bold");
        txtTab02IntRate.setPromptText(" %");
        txtTab02DownPay.setLayoutX(150);
        txtTab02DownPay.setLayoutY(115);
        txtTab02DownPay.setStyle("-fx-font-weight: bold");
        txtTab02DownPay.setPromptText(" $");
        txtTab02TradeValue.setLayoutX(150);
        txtTab02TradeValue.setLayoutY(145);
        txtTab02TradeValue.setStyle("-fx-font-weight: bold");
        txtTab02TradeValue.setPromptText(" $");

        comTab02YourState.getItems().addAll("-- Select --","Central Province","Eastern Province","Northern Province","Southern Province","Western Province","North Western Province","North Central Province","Uva Province","Sabaragamuwa Province ");
        comTab02YourState.setValue("-- Select --");
        comTab02YourState.setPrefWidth(160);
        comTab02YourState.setLayoutX(150);
        comTab02YourState.setLayoutY(175);

        txtTab02SalesTax.setLayoutX(150);
        txtTab02SalesTax.setLayoutY(205);
        txtTab02SalesTax.setStyle("-fx-font-weight: bold");
        txtTab02SalesTax.setPromptText(" %");
        txtTab02OtherFees.setLayoutX(150);
        txtTab02OtherFees.setLayoutY(235);
        txtTab02OtherFees.setStyle("-fx-font-weight: bold");
        txtTab02OtherFees.setPromptText(" $");

        btnCalculateTab02.setLayoutX(100);
        btnCalculateTab02.setLayoutY(300);
        btnCalculateTab02.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnCalculateTab02.setOnAction(event -> monthlyPaymentCalculation());

        Pane monthlyPaymentPane = new Pane();
        monthlyPaymentPane.setStyle("-fx-background-color: #6495ed;");
        monthlyPaymentPane.getChildren().addAll(lbMonthlyPay,lbLoanTerm,lbIntRate,lbDownPay,lbTradeValue,
                lbYourState,lbSalesTax,lbOtherFees,txtTab02MonthlyPay,txtTab02LoanTerm,txtTab02IntRate,
                txtTab02DownPay,txtTab02TradeValue,comTab02YourState,txtTab02SalesTax,txtTab02OtherFees,btnCalculateTab02);
        monthlyPaymentPane.setLayoutX(20);
        monthlyPaymentPane.setLayoutY(20);
        monthlyPaymentPane.setPrefSize(320,370);


        lb1.setText(" Total Loan Amount");
        lb2.setText(" Sale Tax");
        lb3.setText(" Upfront Payment");
        lb5.setText(" Total Loan Interest");
        lb6.setText(" Total Cost (price, interest, tax, fees)");

        lbHeadTab02 = new Label();
        lbHeadTab02.setText(" Vehicle Price ");
        lbHeadTab02.setStyle("-fx-background-color: #138013;"+ "-fx-font-size: 20;"+"-fx-font-weight: bold;");
        lbHeadTab02.setLayoutX(425);
        lbHeadTab02.setLayoutY(20);
        lbHeadTab02.setMinWidth(385);

        lb4_2 = new Label(" Total of 60 Loan Payments");
        lb4_2.setLayoutX(425);
        lb4_2.setLayoutY(160);
        lb4_2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb4_2.setMinWidth(275);

        lb01ALTab2 = new Label();
        lb01ALTab2.setLayoutX(710);
        lb01ALTab2.setLayoutY(70);
        lb01ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb01ALTab2.setMinWidth(100);

        lb02ALTab2 = new Label();
        lb02ALTab2.setLayoutX(710);
        lb02ALTab2.setLayoutY(100);
        lb02ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb02ALTab2.setMinWidth(100);

        lb03ALTab2 = new Label();
        lb03ALTab2.setLayoutX(710);
        lb03ALTab2.setLayoutY(130);
        lb03ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb03ALTab2.setMinWidth(100);

        lb04ALTab2 = new Label();
        lb04ALTab2.setLayoutX(710);
        lb04ALTab2.setLayoutY(160);
        lb04ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb04ALTab2.setMinWidth(100);

        lb05ALTab2 = new Label();
        lb05ALTab2.setLayoutX(710);
        lb05ALTab2.setLayoutY(190);
        lb05ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb05ALTab2.setMinWidth(100);

        lb06ALTab2 = new Label();
        lb06ALTab2.setLayoutX(710);
        lb06ALTab2.setLayoutY(220);
        lb06ALTab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06ALTab2.setAlignment(Pos.CENTER_RIGHT);
        lb06ALTab2.setMinWidth(100);

        monthlyPaymentLayout = new AnchorPane();
        monthlyPaymentLayout.setStyle("-fx-background-color: #e2cc37;");
        monthlyPaymentLayout.getChildren().addAll(monthlyPaymentPane,lbHeadTab02,lb1,lb2,lb3,lb4_2,lb5,lb6,lb01ALTab2,lb02ALTab2,lb03ALTab2,lb04ALTab2,lb05ALTab2,lb06ALTab2);
        monthlyPaymentLayout.setLayoutX(350);
        monthlyPaymentLayout.setLayoutY(200);
    }
    public void monthlyPaymentCalculation(){
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);

        try {
            monthlyPay = Double.parseDouble(txtTab02MonthlyPay.getText());
            loanTerms = Double.parseDouble(txtTab02LoanTerm.getText());
            interestRate = Double.parseDouble(txtTab02IntRate.getText());
            downPay = Double.parseDouble(txtTab02DownPay.getText());
            tradeValue = Double.parseDouble(txtTab02TradeValue.getText());
            salesTax = Double.parseDouble(txtTab02SalesTax.getText());
            otherFee = Double.parseDouble(txtTab02OtherFees.getText());

            //formulas
            double vehiclePrice = (((monthlyPay * (1 - Math.pow((1 + (interestRate / 100) / 12), -loanTerms))) * 12) / (interestRate / 100)) + downPay + tradeValue;
            double saleTax = (vehiclePrice - tradeValue) * (salesTax / 100);
            double totalLoanAmount = vehiclePrice - downPay - tradeValue;
            double upfrontPay = saleTax + downPay + otherFee;
            double totalLoanPay = monthlyPay * loanTerms;
            double totalLoanInterest = totalLoanPay - totalLoanAmount;
            double totalCost = vehiclePrice + totalLoanInterest + saleTax + otherFee;


            lbHeadTab02.setText(String.format("Monthly Pay: $" + "%.2f", vehiclePrice));
            lb01ALTab2.setText(String.format("$" + "%.2f", totalLoanAmount));
            lb02ALTab2.setText(String.format("$" + "%.2f", saleTax));
            lb03ALTab2.setText(String.format("$" + "%.2f", upfrontPay));
            lb04ALTab2.setText(String.format("$" + "%.2f", totalLoanPay));
            lb05ALTab2.setText(String.format("$" + "%.2f", totalLoanInterest));
            lb06ALTab2.setText(String.format("$" + "%.2f", totalCost));
            lb4_2.setText(" Total of " + (int) loanTerms + " Loan Payments");

        }catch (Exception error) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }

    }
    public void publicContainers(){

        //  Two Tabs have this Containers
        lb1 = new Label();
        lb1.setLayoutX(425);
        lb1.setLayoutY(70);
        lb1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb1.setMinWidth(275);

        lb2 = new Label();
        lb2.setLayoutX(425);
        lb2.setLayoutY(100);
        lb2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb2.setMinWidth(275);

        lb3 = new Label();
        lb3.setLayoutX(425);
        lb3.setLayoutY(130);
        lb3.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb3.setMinWidth(275);

        lb5 = new Label();
        lb5.setLayoutX(425);
        lb5.setLayoutY(190);
        lb5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb5.setMinWidth(275);

        lb6 = new Label();
        lb6.setLayoutX(425);
        lb6.setLayoutY(220);
        lb6.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb6.setMinWidth(275);

        lb7 = new Label();
        lb7.setLayoutX(425);
        lb7.setLayoutY(250);
        lb7.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb7.setMinWidth(275);

        lb8 = new Label();
        lb8.setLayoutX(425);
        lb8.setLayoutY(280);
        lb8.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb8.setMinWidth(275);

    }




}
