import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MortgageCal {

    // Public to 3 calculators
    Label lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14;
    Label lbHomePrice,lbDownPayment,lbMLoanTerm,lbInterestRate,lbStartDate,lbPropertyTaxes,     //Text labels
            lbHomeInsurance,lbPMIInsurance,lbHOAFee,lbOtherCosts,lbYear,lbTaxAndCost;
    Label lb1RV,lb2RV,lb3RV,lb4RV,lb5RV,lb6RV,lb7RV,lb8RV,lb9RV,lb10RV,lb11RV,lb12RV,lb13RV,    //Integer Values in labels
            lb14RV,lb15RV,lb16RV,lb17RV,lb18RV;
    TextField txtHomePrice,txtDownPayment,txtMLoanTerm,txtInterestRate,txtStartDate,            //Input Text Box
            txtPropertyTaxes,txtHomeInsurance,txtPMIInsurance,txtHOAFee,txtOtherCosts;

    ComboBox<String> comDownPay,comProTax,comHomeIns,comPMIIns,comHOAFee,comOthCost,comStartDate;  //ComboBox in Mortgage Cal

    String month;
    public void openMortgageWindow(){
        Stage mortgageWindow = new Stage();     //Mortgage Calculator Stage
        mortgageWindow.setMaxWidth(1150);
        mortgageWindow.setMaxHeight(620);
        KeyBoard keyBoard = new KeyBoard();
        HelpButtons viewer = new HelpButtons();
        VBox keyPad = keyBoard.cal();

        Button helpBtn = new Button("Help Viewer");     // Mortgage Calculator help button
        helpBtn.setLayoutX(140);
        helpBtn.setLayoutY(500);
        helpBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        helpBtn.setOnAction(event -> viewer.helpViewerMortgage());

        mortgageInputContainers();
        Button btnCalculate = new Button("Calculate");      //Mortgage Calculate button
        Pane mortgagePaneLayout = new Pane();
        mortgagePaneLayout.setStyle("-fx-background-color: #6495ed;");
        mortgagePaneLayout.getChildren().addAll(lbHomePrice,lbDownPayment,lbMLoanTerm,lbInterestRate,lbStartDate,lbPropertyTaxes,lbHomeInsurance,
                lbPMIInsurance,lbHOAFee,lbOtherCosts,txtHomePrice,txtDownPayment,txtMLoanTerm,lbYear,txtInterestRate,txtStartDate,lbTaxAndCost,
                txtPropertyTaxes,txtHomeInsurance,txtPMIInsurance,txtHOAFee,txtOtherCosts,comDownPay,comHOAFee,comHomeIns,
                comOthCost,comPMIIns,comProTax,comStartDate,btnCalculate);
        mortgagePaneLayout.setLayoutX(20);
        mortgagePaneLayout.setLayoutY(20);
        mortgagePaneLayout.setPrefSize(380,550);

        Button btnBack = new Button("Back To Home");        // back button
        btnBack.setLayoutX(525);
        btnBack.setLayoutY(500);
        btnBack.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnBack.setOnAction(event -> {
            MainWindow mainWindow = new MainWindow();
            mortgageWindow.close();
            mainWindow.mainWindow();
        });

        Button btnCloseWin = new Button("Close");       // close button
        btnCloseWin.setLayoutX(675);
        btnCloseWin.setLayoutY(500);
        btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnCloseWin.setOnAction(event -> mortgageWindow.close());



        btnCalculate.setLayoutX(100);
        btnCalculate.setLayoutY(400);
        btnCalculate.setPrefWidth(150);
        btnCalculate.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 10px;");
        btnCalculate.setOnAction(event -> mortgageCalculation());

        mortgageOutputContainers();

        AnchorPane mortgageLayout = new AnchorPane();               // Mortgage cal Main Layout
        mortgageLayout.setStyle("-fx-background-color: #e2cc37;");
        mortgageLayout.getChildren().addAll(keyPad,mortgagePaneLayout, btnBack, btnCloseWin,lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,
                lb1RV,lb2RV,lb3RV,lb4RV,lb5RV,lb6RV,lb7RV,lb8RV,lb9RV,lb10RV,lb11RV,lb12RV,lb13RV,lb14RV,lb15RV,lb16RV,lb17RV,lb18RV,helpBtn);
        Scene mortgageScene = new Scene(mortgageLayout,1150, 600);      //Create Scene

        mortgageWindow.setScene(mortgageScene);
        mortgageWindow.setTitle("Mortgage Calculator");
        mortgageWindow.show();
    }
    public void mortgageInputContainers (){

        //Mortgage cal Containers

        lbHomePrice = new Label("Home Price");
        lbDownPayment = new Label("Down Payment");
        lbMLoanTerm= new Label("Loan Term");
        lbInterestRate = new Label("Interest Rate");
        lbStartDate	 = new Label("Start Date");
        lbPropertyTaxes	 = new Label("Property Taxes");
        lbHomeInsurance	 = new Label("Home Insurance");
        lbPMIInsurance = new Label("PMI Insurance");
        lbHOAFee = new Label("HOA Fee");
        lbOtherCosts = new Label("Other Costs");
        lbYear = new Label("Years");
        lbTaxAndCost = new Label("Annual Tax & Cost");

        txtHomePrice = new TextField();
        txtDownPayment = new TextField();
        txtMLoanTerm = new TextField();
        txtInterestRate = new TextField();
        txtStartDate = new TextField();
        txtPropertyTaxes = new TextField();
        txtHomeInsurance = new TextField();
        txtPMIInsurance = new TextField();
        txtHOAFee = new TextField();
        txtOtherCosts = new TextField();
                                                // Down Payment Combox create
        comDownPay = new ComboBox<>();
        comDownPay.getItems().addAll("%","$");
        comDownPay.setValue("%");
        comDownPay.setLayoutX(310);
        comDownPay.setLayoutY(55);
        comDownPay.setOnAction(event -> {
            double HP = Double.parseDouble(txtHomePrice.getText());
            double downPay =  Double.parseDouble(txtDownPayment.getText());
            if(comDownPay.getValue().equals("$")){

                double value = (downPay/100) * HP;
                txtDownPayment.setText(String.valueOf(value));
            }else {
                double value = (downPay/HP) * 100;
                txtDownPayment.setText(String.valueOf(value));
            }

        });

        comStartDate = new ComboBox<>();        // Start Date Combox create
        comStartDate.getItems().addAll("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        comStartDate.setValue("Jul");
        this.month = "Jul";
        comStartDate.setLayoutX(150);
        comStartDate.setLayoutY(145);
        comStartDate.setOnAction(event -> month = comStartDate.getValue());

        comProTax = new ComboBox<>();
        comProTax.getItems().addAll("%","$");
        comProTax.setValue("%");
        comProTax.setLayoutX(310);
        comProTax.setLayoutY(235);
        comProTax.setOnAction(event -> {

            double HP = Double.parseDouble(txtHomePrice.getText());
            double downPay =  Double.parseDouble(txtPropertyTaxes.getText());
            if(comProTax.getValue().equals("$")){

                double value = (downPay/100) * HP;
                txtPropertyTaxes.setText(String.valueOf(value));
            }else {
                double value = (downPay/HP) * 100;
                txtPropertyTaxes.setText(String.valueOf(value));

            }

        });
        comHomeIns = new ComboBox<>();
        comHomeIns.getItems().addAll("%","$");
        comHomeIns.setValue("$");
        comHomeIns.setLayoutX(310);
        comHomeIns.setLayoutY(265);
        comHomeIns.setOnAction(event -> {

            double HP = Double.parseDouble(txtHomePrice.getText());
            double HI =  Double.parseDouble(txtHomeInsurance.getText());
            if(comHomeIns.getValue().equals("$")){

                double value = (HI/100) * HP;
                txtHomeInsurance.setText(String.valueOf(value));
            }else {
                double value = (HI/HP) * 100;
                txtHomeInsurance.setText(String.valueOf(value));
            }

        });
        comPMIIns = new ComboBox<>();
        comPMIIns.getItems().addAll("%","$");
        comPMIIns.setValue("$");
        comPMIIns.setLayoutX(310);
        comPMIIns.setLayoutY(295);
        comPMIIns.setOnAction(event -> {

            double HP = Double.parseDouble(txtHomePrice.getText());
            double HI =  Double.parseDouble(txtPMIInsurance.getText());
            if(comPMIIns.getValue().equals("$")){

                double value = (HI/100) * HP;
                txtPMIInsurance.setText(String.valueOf(value));
            }else {
                double value = (HI/HP) * 100;
                txtPMIInsurance.setText(String.valueOf(value));
            }
        });
        comHOAFee = new ComboBox<>();
        comHOAFee.getItems().addAll("%","$");
        comHOAFee.setValue("$");
        comHOAFee.setLayoutX(310);
        comHOAFee.setLayoutY(325);
        comHOAFee.setOnAction(event -> {

            double HP = Double.parseDouble(txtHomePrice.getText());
            double HI =  Double.parseDouble(txtHOAFee.getText());
            if(comHOAFee.getValue().equals("$")){

                double value = (HI/100) * HP;
                txtHOAFee.setText(String.valueOf(value));
            }else {
                double value = (HI/HP) * 100;
                txtHOAFee.setText(String.valueOf(value));
            }
        });
        comOthCost = new ComboBox<>();
        comOthCost.getItems().addAll("%","$");
        comOthCost.setValue("$");
        comOthCost.setLayoutX(310);
        comOthCost.setLayoutY(355);
        comOthCost.setOnAction(event -> {

            double HP = Double.parseDouble(txtHomePrice.getText());
            double HI =  Double.parseDouble(txtOtherCosts.getText());
            if(comOthCost.getValue().equals("$")){

                double value = (HI/100) * HP;
                txtOtherCosts.setText(String.valueOf(value));
            }else {
                double value = (HI/HP) * 100;
                txtOtherCosts.setText(String.valueOf(value));
            }
        });

        lbHomePrice.setLayoutX(20);
        lbHomePrice.setLayoutY(30);
        lbHomePrice.setStyle("-fx-font-size: 15;");
        lbDownPayment.setLayoutX(20);
        lbDownPayment.setLayoutY(60);
        lbDownPayment.setStyle("-fx-font-size: 15;");
        lbMLoanTerm.setLayoutX(20);
        lbMLoanTerm.setLayoutY(90);
        lbMLoanTerm.setStyle("-fx-font-size: 15;");
        lbInterestRate.setLayoutX(20);
        lbInterestRate.setLayoutY(120);
        lbInterestRate.setStyle("-fx-font-size: 15;");
        lbStartDate.setLayoutX(20);
        lbStartDate.setLayoutY(150);
        lbStartDate.setStyle("-fx-font-size: 15;");
        lbPropertyTaxes.setLayoutX(20);
        lbPropertyTaxes.setLayoutY(240);
        lbPropertyTaxes.setStyle("-fx-font-size: 15;");
        lbHomeInsurance.setLayoutX(20);
        lbHomeInsurance.setLayoutY(270);
        lbHomeInsurance.setStyle("-fx-font-size: 15;");
        lbPMIInsurance.setLayoutX(20);
        lbPMIInsurance.setLayoutY(300);
        lbPMIInsurance.setStyle("-fx-font-size: 15;");
        lbHOAFee.setLayoutX(20);
        lbHOAFee.setLayoutY(330);
        lbHOAFee.setStyle("-fx-font-size: 15;");
        lbOtherCosts.setLayoutX(20);
        lbOtherCosts.setLayoutY(360);
        lbOtherCosts.setStyle("-fx-font-size: 15;");

        txtHomePrice.setLayoutX(150);
        txtHomePrice.setLayoutY(25);
        txtHomePrice.setStyle("-fx-font-weight: bold");
        txtHomePrice.setPromptText("$");
        txtDownPayment.setLayoutX(150);
        txtDownPayment.setLayoutY(55);
        txtDownPayment.setStyle("-fx-font-weight: bold");
        txtMLoanTerm.setLayoutX(150);
        txtMLoanTerm.setLayoutY(85);
        txtMLoanTerm.setStyle("-fx-font-weight: bold");
        lbYear.setLayoutX(310);
        lbYear.setLayoutY(90);
        lbYear.setStyle("-fx-font-size: 15;");
        txtInterestRate.setLayoutX(150);
        txtInterestRate.setLayoutY(115);
        txtInterestRate.setStyle("-fx-font-weight: bold");
        txtInterestRate.setPromptText("%");
        txtStartDate.setLayoutX(220);
        txtStartDate.setLayoutY(145);
        txtStartDate.setStyle("-fx-font-weight: bold");
        txtStartDate.setPromptText("Year");
        txtStartDate.setPrefSize(80,0);
        lbTaxAndCost.setLayoutX(170);
        lbTaxAndCost.setLayoutY(210);
        lbTaxAndCost.setStyle("-fx-font-size: 15;");
        txtPropertyTaxes.setLayoutX(150);
        txtPropertyTaxes.setLayoutY(235);
        txtPropertyTaxes.setStyle("-fx-font-weight: bold");
        txtHomeInsurance.setLayoutX(150);
        txtHomeInsurance.setLayoutY(265);
        txtHomeInsurance.setStyle("-fx-font-weight: bold");
        txtPMIInsurance.setLayoutX(150);
        txtPMIInsurance.setLayoutY(295);
        txtPMIInsurance.setStyle("-fx-font-weight: bold");
        txtHOAFee.setLayoutX(150);
        txtHOAFee.setLayoutY(325);
        txtHOAFee.setStyle("-fx-font-weight: bold");
        txtOtherCosts.setLayoutX(150);
        txtOtherCosts.setLayoutY(355);
        txtOtherCosts.setStyle("-fx-font-weight: bold");
    }
    public void mortgageOutputContainers(){

        /*--------------------------------------------mortgage output Text in labels part 01 -----------------------------------------------*/

        lbHead = new Label(" Monthly Pay");      // Monthly Pay Label -----------------------------
        lbHead.setStyle("-fx-background-color: #138013;"+ "-fx-font-size: 20;"+"-fx-font-weight: bold;");
        lbHead.setLayoutX(425);
        lbHead.setLayoutY(50);
        lbHead.setMinWidth(385);

        lb7 = new Label(" Monthly");
        lb7.setLayoutX(640);
        lb7.setLayoutY(90);
        lb7.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb8 = new Label(" Total");
        lb8.setLayoutX(775);
        lb8.setLayoutY(90);
        lb8.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");

        lb9 = new Label(" Mortgage Payment");                //Mortgage Payment label
        lb9.setLayoutX(425);
        lb9.setLayoutY(125);
        lb9.setMinWidth(165);
        lb9.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");

        lb10 = new Label(" Property Tax");                //Property Tax label
        lb10.setLayoutX(425);
        lb10.setLayoutY(150);
        lb10.setMinWidth(165);
        lb10.setStyle("-fx-font-size: 15;");

        lb11 = new Label(" Home Insurance");                //Home Insurance label
        lb11.setLayoutX(425);
        lb11.setLayoutY(175);
        lb11.setMinWidth(165);
        lb11.setStyle("-fx-font-size: 15;");

        lb12 = new Label(" HOA Fee");                //HOA Fee label
        lb12.setLayoutX(425);
        lb12.setLayoutY(200);
        lb12.setMinWidth(165);
        lb12.setStyle("-fx-font-size: 15;");

        lb13 = new Label(" Other Costs");                //Other Costs label
        lb13.setLayoutX(425);
        lb13.setLayoutY(225);
        lb13.setMinWidth(165);
        lb13.setStyle("-fx-font-size: 15;");

        lb14 = new Label(" Total Out-of-Pocket");                //Total Out-of-Pocket label
        lb14.setLayoutX(425);
        lb14.setLayoutY(250);
        lb14.setMinWidth(165);
        lb14.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");

        /*--------------------------------------------mortgage output values in labels part 01 -----------------------------------------------*/

        lb7RV = new Label();                                       //Mortgage Payment	Monthly
        lb7RV.setLayoutX(600);
        lb7RV.setLayoutY(125);
        lb7RV.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb7RV.setAlignment(Pos.CENTER_RIGHT);
        lb7RV.setMinWidth(100);

        lb8RV = new Label("");                                       //Property Tax Total label
        lb8RV.setLayoutX(710);
        lb8RV.setLayoutY(125);
        lb8RV.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb8RV.setAlignment(Pos.CENTER_RIGHT);
        lb8RV.setMinWidth(100);

        lb9RV = new Label();                                       //Property Tax Monthly label
        lb9RV.setLayoutX(600);
        lb9RV.setLayoutY(150);
        lb9RV.setStyle("-fx-font-size: 15;");
        lb9RV.setAlignment(Pos.CENTER_RIGHT);
        lb9RV.setMinWidth(100);

        lb10RV = new Label();                                      // Property Tax Total label
        lb10RV.setLayoutX(710);
        lb10RV.setLayoutY(150);
        lb10RV.setStyle("-fx-font-size: 15;");
        lb10RV.setAlignment(Pos.CENTER_RIGHT);
        lb10RV.setMinWidth(100);

        lb11RV = new Label();                                       //Home Insurance Monthly label
        lb11RV.setLayoutX(600);
        lb11RV.setLayoutY(175);
        lb11RV.setStyle("-fx-font-size: 15;");
        lb11RV.setAlignment(Pos.CENTER_RIGHT);
        lb11RV.setMinWidth(100);

        lb12RV = new Label();                                      // Home Insurance Total label
        lb12RV.setLayoutX(710);
        lb12RV.setLayoutY(175);
        lb12RV.setStyle("-fx-font-size: 15;");
        lb12RV.setAlignment(Pos.CENTER_RIGHT);
        lb12RV.setMinWidth(100);

        lb13RV = new Label();                                       //HOA Fee Monthly label
        lb13RV.setLayoutX(600);
        lb13RV.setLayoutY(200);
        lb13RV.setStyle("-fx-font-size: 15;");
        lb13RV.setAlignment(Pos.CENTER_RIGHT);
        lb13RV.setMinWidth(100);

        lb14RV = new Label();                                      // HOA Fee Total label
        lb14RV.setLayoutX(710);
        lb14RV.setLayoutY(200);
        lb14RV.setStyle("-fx-font-size: 15;");
        lb14RV.setAlignment(Pos.CENTER_RIGHT);
        lb14RV.setMinWidth(100);

        lb15RV = new Label();                                       //Other Costs Monthly label
        lb15RV.setLayoutX(600);
        lb15RV.setLayoutY(225);
        lb15RV.setStyle("-fx-font-size: 15;");
        lb15RV.setAlignment(Pos.CENTER_RIGHT);
        lb15RV.setMinWidth(100);

        lb16RV = new Label();                                      // Other Costs Total label
        lb16RV.setLayoutX(710);
        lb16RV.setLayoutY(225);
        lb16RV.setStyle("-fx-font-size: 15;");
        lb16RV.setAlignment(Pos.CENTER_RIGHT);
        lb16RV.setMinWidth(100);

        lb17RV = new Label();                                       //Total Out-of-Pocket Monthly label
        lb17RV.setLayoutX(600);
        lb17RV.setLayoutY(250);
        lb17RV.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb17RV.setAlignment(Pos.CENTER_RIGHT);
        lb17RV.setMinWidth(100);

        lb18RV = new Label();                                      // Total Out-of-Pocket Total label
        lb18RV.setLayoutX(710);
        lb18RV.setLayoutY(250);
        lb18RV.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb18RV.setAlignment(Pos.CENTER_RIGHT);
        lb18RV.setMinWidth(100);

        /*--------------------------------------------mortgage output Text in labels part 02 -----------------------------------------------*/

        lb1 = new Label(" House Price");                                         // Home Price Label
        lb1.setLayoutX(425);
        lb1.setLayoutY(300);
        lb1.setMinWidth(275);
        lb1.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");

        lb2 = new Label(" Loan Amount");                                        // Loan Amount Label
        lb2.setLayoutX(425);
        lb2.setLayoutY(325);
        lb2.setMinWidth(275);
        lb2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");

        lb3 = new Label(" Down Payment");                                        // Down Payment Label
        lb3.setLayoutX(425);
        lb3.setLayoutY(350);
        lb3.setMinWidth(275);
        lb3.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");

        lb4 = new Label(" Total of Mortgage Payments");                      // Total of 360 Mortgage Payments Label
        lb4.setLayoutX(425);
        lb4.setLayoutY(375);
        lb4.setMinWidth(275);
        lb4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");

        lb5 = new Label(" Total Interest");                                      // Total Interest Label
        lb5.setLayoutX(425);
        lb5.setLayoutY(400);
        lb5.setMinWidth(275);
        lb5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");

        lb6 = new Label(" Mortgage Payoff Date");                                // Mortgage Payoff Date Label
        lb6.setLayoutX(425);
        lb6.setLayoutY(425);
        lb6.setMinWidth(275);
        lb6.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");

        /*--------------------------------------------mortgage output values in labels part 01 -----------------------------------------------*/

        lb1RV = new Label();
        lb1RV.setLayoutX(710);
        lb1RV.setLayoutY(300);
        lb1RV.setStyle("-fx-background-color: #727272;"+"-fx-font-size: 15;"+"-fx-font-weight: bold;");
        lb1RV.setAlignment(Pos.CENTER_RIGHT);
        lb1RV.setMinWidth(100);

        lb2RV = new Label();
        lb2RV.setLayoutX(710);
        lb2RV.setLayoutY(325);
        lb2RV.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb2RV.setAlignment(Pos.CENTER_RIGHT);
        lb2RV.setMinWidth(100);

        lb3RV = new Label();
        lb3RV.setLayoutX(710);
        lb3RV.setLayoutY(350);
        lb3RV.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb3RV.setAlignment(Pos.CENTER_RIGHT);
        lb3RV.setMinWidth(100);

        lb4RV = new Label();
        lb4RV.setLayoutX(710);
        lb4RV.setLayoutY(375);
        lb4RV.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb4RV.setAlignment(Pos.CENTER_RIGHT);
        lb4RV.setMinWidth(100);

        lb5RV = new Label();
        lb5RV.setLayoutX(710);
        lb5RV.setLayoutY(400);
        lb5RV.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb5RV.setAlignment(Pos.CENTER_RIGHT);
        lb5RV.setMinWidth(100);

        lb6RV = new Label();
        lb6RV.setLayoutX(710);
        lb6RV.setLayoutY(425);
        lb6RV.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb6RV.setAlignment(Pos.CENTER_RIGHT);
        lb6RV.setMinWidth(100);
    }

    public void mortgageCalculation(){          // Mortgage Calculations

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {

            double homePrice = Double.parseDouble(txtHomePrice.getText());
            double loanTerm = Double.parseDouble(txtMLoanTerm.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            double startDate = Integer.parseInt(txtStartDate.getText());

            double downPayment = Double.parseDouble(txtDownPayment.getText());
            if (comDownPay.getValue().equals("%")) {
                downPayment = (downPayment / 100) * homePrice;
            }

            double proTax = Double.parseDouble(txtPropertyTaxes.getText());
            if (comProTax.getValue().equals("%")) {
                proTax = (proTax / 100) * homePrice;
            }

            double homeIns = Double.parseDouble(txtHomeInsurance.getText());
            if (comHomeIns.getValue().equals("%")) {
                homeIns = (homeIns / 100) * homePrice;
            }

            double hoaFee = Double.parseDouble(txtHOAFee.getText());
            if (comHOAFee.getValue().equals("%")) {
                hoaFee = (hoaFee / 100) * homePrice;
            }

            double otherCost = Double.parseDouble(txtOtherCosts.getText());
            if (comOthCost.getValue().equals("%")) {
                otherCost = (otherCost / 100) * homePrice;
            }

            //formulas
            int totalMonths = (int) loanTerm * 12;
            double interestMonthly = (interestRate / 100) / 12;
            double loanAmount = homePrice - downPayment;
            double mortgagePayMonthly = (loanAmount * interestMonthly) / (1 - Math.pow(1 + interestMonthly, -totalMonths));
            double mortgagePayTotal = mortgagePayMonthly * totalMonths;
            double proTaxMonthly = proTax / 12;
            double proTaxTotal = proTaxMonthly * totalMonths;
            double homeInsMonthly = homeIns / 12;
            double homeInsTotal = homeInsMonthly * totalMonths;
            double hoaFeeMonthly = hoaFee / 12;
            double hoaFeeTotal = hoaFeeMonthly * totalMonths;
            double otherCostMonthly = otherCost / 12;
            double otherCostTotal = otherCostMonthly * totalMonths;
            double totPocketMonthly = mortgagePayMonthly + proTaxMonthly + homeInsMonthly + hoaFeeMonthly + otherCostMonthly;
            double totPocketTotal = mortgagePayTotal + proTaxTotal + homeInsTotal + hoaFeeTotal + otherCostTotal;
            double totalInterest = mortgagePayTotal - loanAmount;
            int payOffDate = (int) (startDate + loanTerm);

            //set labels
            lb1RV.setText(String.format("$" + "%.2f", homePrice));
            lb2RV.setText(String.format("$" + "%.2f", loanAmount));
            lb3RV.setText(String.format("$" + "%.2f", downPayment));
            lb4RV.setText(String.format("$" + "%.2f", mortgagePayTotal));
            lb5RV.setText(String.format("$" + "%.2f", totalInterest));
            lb6RV.setText(month + ". " + payOffDate);

            lbHead.setText(String.format("Monthly Pay:  $" + "%.2f", mortgagePayMonthly));
            lb7RV.setText(String.format("$" + "%.2f", mortgagePayMonthly));
            lb8RV.setText(String.format("$" + "%.2f", mortgagePayTotal));
            lb9RV.setText(String.format("$" + "%.2f", proTaxMonthly));
            lb10RV.setText(String.format("$" + "%.2f", proTaxTotal));
            lb11RV.setText(String.format("$" + "%.2f", homeInsMonthly));
            lb12RV.setText(String.format("$" + "%.2f", homeInsTotal));
            lb13RV.setText(String.format("$" + "%.2f", hoaFeeMonthly));
            lb14RV.setText(String.format("$" + "%.2f", hoaFeeTotal));
            lb15RV.setText(String.format("$" + "%.2f", otherCostMonthly));
            lb16RV.setText(String.format("$" + "%.2f", otherCostTotal));
            lb17RV.setText(String.format("$" + "%.2f", totPocketMonthly));
            lb18RV.setText(String.format("$" + "%.2f", totPocketTotal));
            lb4.setText(" Total of " + totalMonths + " Mortgage Payments");
        } catch (Exception error) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }




}
