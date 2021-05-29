import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinanceCal {


    AnchorPane fvLayout,pmtLayout,periodsNLayout,startPrincipalLayout;

    // public to 4 tabs
    Label lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
    Label lbN, lbStartPrincipal, lbInterest, lbPMT, lbFV;

    //Finance 1st Tab (FV)
    Label lb01Tab1,lb02Tab1,lb03Tab1,lb04Tab1,lb05Tab1,lb06Tab1,lb07Tab1,lb08Tab1;
    TextField txtTab01N,txtTab01StartPrincipal,txtTab01Interest,txtTab01PMT;

    //FinanceCal 2nd Tab (PMT)
    Label lb01Tab2,lb02Tab2,lb03Tab2,lb04Tab2,lb05Tab2,lb06Tab2,lb07Tab2,lb08Tab2;
    TextField txtTab02FV,txtTab02N,txtTab02StartPrincipal,txtTab02Interest;

    //FinanceCal 3th Tab
    Label lb01Tab4,lb02Tab4,lb03Tab4,lb04Tab4,lb05Tab4,lb06Tab4,lb07Tab4,lb08Tab4;
    TextField txtTab04FV,txtTab04StartPrincipal,txtTab04Interest,txtTab04PMT;

    //FinanceCal 4th Tab
    Label lb01Tab5,lb02Tab5,lb03Tab5,lb04Tab5,lb05Tab5,lb06Tab5,lb07Tab5,lb08Tab5;
    TextField txtTab05FV,txtTab05N,txtTab05Interest,txtTab05PMT;

    double periodsN,startPrincipal,interest,PMT,futureValue;
    public void openFinanceCalculator(){
        Stage financeWindow = new Stage();
        financeWindow.setMaxWidth(1150);
        financeWindow.setMaxHeight(450);
        HelpButtons viewer = new HelpButtons();
        KeyBoard keyBoard = new KeyBoard();
        VBox keyPad = keyBoard.cal();

        Button helpBtn = new Button("Help Viewer");
        helpBtn.setLayoutX(962);
        helpBtn.setLayoutY(370);
        helpBtn.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        helpBtn.setOnAction(event -> viewer.helpViewerFinance());

        tabFV();
        tabPMT();
        tabPeriodsN();
        tabStartPrincipal();

        Button btnBack = new Button("Back To Home");        // back button
        btnBack.setLayoutX(525);
        btnBack.setLayoutY(350);
        btnBack.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnBack.setOnAction(event -> {
            MainWindow mainWindow = new MainWindow();
            financeWindow.close();
            mainWindow.mainWindow();
        });

        Button btnCloseWin = new Button("Close");
        btnCloseWin.setLayoutX(675);
        btnCloseWin.setLayoutY(350);
        btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnCloseWin.setOnAction(event -> financeWindow.close());

        Tab fvTab = new Tab("FV");
        fvTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        fvTab.setContent(fvLayout);
        Tab paymentTab = new Tab("PMT");
        paymentTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        paymentTab.setContent(pmtLayout);
        Tab periodsNTab = new Tab("N");
        periodsNTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        periodsNTab.setContent(periodsNLayout);
        Tab startPrincipalTab = new Tab("Start Principal");
        startPrincipalTab.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        startPrincipalTab.setContent(startPrincipalLayout);

        TabPane financeTabPane = new TabPane();
        financeTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        financeTabPane.getTabs().addAll(fvTab, paymentTab, periodsNTab, startPrincipalTab);
        financeTabPane.setPrefSize(900,600);


        AnchorPane financeLayout = new AnchorPane();
        financeLayout.setStyle("-fx-background-color: #e2cc37;");
        financeLayout.getChildren().addAll(financeTabPane,btnBack,btnCloseWin,keyPad,helpBtn);
        Scene financeScene = new Scene(financeLayout,1150,600);

        financeWindow.setScene(financeScene);
        financeWindow.setTitle("Finance Calculator");
        financeWindow.show();
    }
    public void tabFV(){
        // future Value tab start
        publicContainers();
        lbN = new Label(" N (# of periods)");
        lbStartPrincipal = new Label("Start Principal");
        lbInterest = new Label(" I/Y (Interest)");
        lbPMT = new Label(" PMT (Annuity Payment)");
        lbFV = new Label(" FV (Future Value)");
        txtTab01N = new TextField();
        txtTab01StartPrincipal = new TextField();
        txtTab01Interest = new TextField();
        txtTab01PMT = new TextField();
        Button btnTab01Calculate = new Button("Calculate");

        lbN.setLayoutX(20);
        lbN.setLayoutY(30);
        lbStartPrincipal.setLayoutX(20);
        lbStartPrincipal.setLayoutY(60);
        lbInterest.setLayoutX(20);
        lbInterest.setLayoutY(90);
        lbPMT.setLayoutX(20);
        lbPMT.setLayoutY(120);

        txtTab01N.setLayoutX(185);
        txtTab01N.setLayoutY(25);
        txtTab01N.setStyle("-fx-font-weight: bold");
        txtTab01N.setPromptText(" Periods");
        txtTab01StartPrincipal.setLayoutX(185);
        txtTab01StartPrincipal.setLayoutY(55);
        txtTab01StartPrincipal.setStyle("-fx-font-weight: bold");
        txtTab01StartPrincipal.setPromptText(" $");
        txtTab01Interest.setLayoutX(185);
        txtTab01Interest.setLayoutY(85);
        txtTab01Interest.setStyle("-fx-font-weight: bold");
        txtTab01Interest.setPromptText(" %");
        txtTab01PMT.setLayoutX(185);
        txtTab01PMT.setLayoutY(115);
        txtTab01PMT.setStyle("-fx-font-weight: bold");
        txtTab01PMT.setPromptText(" $");

        btnTab01Calculate.setLayoutX(100);      // FV Tab Calculation button and action
        btnTab01Calculate.setLayoutY(180);
        btnTab01Calculate.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnTab01Calculate.setOnAction(event -> fvCalculation());
        financeLabelsCss();

        Pane futureValuePane = new Pane();
        futureValuePane.setStyle("-fx-background-color: #6495ed;");
        futureValuePane.getChildren().addAll(lbN,lbStartPrincipal,lbInterest,lbPMT,txtTab01N,txtTab01StartPrincipal,txtTab01Interest,txtTab01PMT,btnTab01Calculate);
        futureValuePane.setLayoutX(20);
        futureValuePane.setLayoutY(20);
        futureValuePane.setPrefSize(350,300);

        lb01Tab1 = new Label();
        lb01Tab1.setLayoutX(710);
        lb01Tab1.setLayoutY(70);
        lb01Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb01Tab1.setMinWidth(100);

        lb02Tab1 = new Label();
        lb02Tab1.setLayoutX(710);
        lb02Tab1.setLayoutY(100);
        lb02Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb02Tab1.setMinWidth(100);

        lb03Tab1 = new Label();
        lb03Tab1.setLayoutX(710);
        lb03Tab1.setLayoutY(130);
        lb03Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb03Tab1.setMinWidth(100);

        lb04Tab1 = new Label();
        lb04Tab1.setLayoutX(710);
        lb04Tab1.setLayoutY(160);
        lb04Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb04Tab1.setMinWidth(100);

        lb05Tab1 = new Label();
        lb05Tab1.setLayoutX(710);
        lb05Tab1.setLayoutY(190);
        lb05Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb05Tab1.setMinWidth(100);

        lb06Tab1 = new Label();
        lb06Tab1.setLayoutX(710);
        lb06Tab1.setLayoutY(220);
        lb06Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb06Tab1.setMinWidth(100);

        lb07Tab1 = new Label();
        lb07Tab1.setLayoutX(710);
        lb07Tab1.setLayoutY(250);
        lb07Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb07Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb07Tab1.setMinWidth(100);

        lb08Tab1 = new Label();
        lb08Tab1.setLayoutX(710);
        lb08Tab1.setLayoutY(280);
        lb08Tab1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb08Tab1.setAlignment(Pos.CENTER_RIGHT);
        lb08Tab1.setMinWidth(100);

        fvLayout = new AnchorPane();
        fvLayout.setStyle("-fx-background-color: #e2cc37;");
        fvLayout.getChildren().addAll(futureValuePane,lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb01Tab1,lb02Tab1,lb03Tab1,lb04Tab1,lb05Tab1,lb06Tab1,lb07Tab1,lb08Tab1);
    }
    public void fvCalculation (){

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {
            periodsN = Double.parseDouble(txtTab01N.getText());
            startPrincipal = Double.parseDouble(txtTab01StartPrincipal.getText());
            interest = Double.parseDouble(txtTab01Interest.getText());
            PMT = Double.parseDouble(txtTab01PMT.getText());

            //formulas
            double FV = ((PMT) * (Math.pow(1 + (interest / 100), periodsN) - 1)) / (interest / 100) + startPrincipal * Math.pow(1 + interest / 100, periodsN);
            double PV = FV * Math.pow((1 + (interest / 100)), -periodsN);
            double totalPrincipal = startPrincipal + (PMT * periodsN);
            double totalInterest = FV - totalPrincipal;

            //set labels
            lb01Tab1.setText(String.format("$" + "%.2f", FV));
            lb02Tab1.setText(String.format("$" + "%.2f", PV));
            lb03Tab1.setText(String.format("$" + "%.2f", periodsN));
            lb04Tab1.setText(String.format("$" + "%.2f", interest));
            lb05Tab1.setText(String.format("$" + "%.2f", PMT));
            lb06Tab1.setText(String.format("$" + "%.2f", startPrincipal));
            lb07Tab1.setText(String.format("$" + "%.2f", totalPrincipal));
            lb08Tab1.setText(String.format("$" + "%.2f", totalInterest));
        }catch (Exception exception) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }

    public void tabPMT(){       // PMT Tab( annuity payment )

        //Create PMT containers
        lbN = new Label(" N (# of periods)");
        lbStartPrincipal = new Label(" Start Principal");
        lbInterest = new Label(" I/Y (Interest)");
        lbFV = new Label(" FV (Future Value)");
        txtTab02N = new TextField();
        txtTab02StartPrincipal = new TextField();
        txtTab02Interest = new TextField();
        txtTab02FV = new TextField();
        Button btnTab02Calculate = new Button("Calculate");

        lbFV.setLayoutX(20);
        lbFV.setLayoutY(30);
        lbN.setLayoutX(20);
        lbN.setLayoutY(60);
        lbStartPrincipal.setLayoutX(20);
        lbStartPrincipal.setLayoutY(90);
        lbInterest.setLayoutX(20);
        lbInterest.setLayoutY(120);

        txtTab02FV.setLayoutX(185);
        txtTab02FV.setLayoutY(25);
        txtTab02FV.setStyle("-fx-font-weight: bold");
        txtTab02FV.setPromptText(" $");
        txtTab02N.setLayoutX(185);
        txtTab02N.setLayoutY(55);
        txtTab02N.setStyle("-fx-font-weight: bold");
        txtTab02N.setPromptText(" Periods");
        txtTab02StartPrincipal.setLayoutX(185);
        txtTab02StartPrincipal.setLayoutY(85);
        txtTab02StartPrincipal.setStyle("-fx-font-weight: bold");
        txtTab02StartPrincipal.setPromptText(" $");
        txtTab02Interest.setLayoutX(185);
        txtTab02Interest.setLayoutY(115);
        txtTab02Interest.setStyle("-fx-font-weight: bold");
        txtTab02Interest.setPromptText(" %");

        btnTab02Calculate.setLayoutX(100);              //
        btnTab02Calculate.setLayoutY(180);
        btnTab02Calculate.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnTab02Calculate.setOnAction(event -> pmtCalculation());
        financeLabelsCss();

        Pane pmtPane = new Pane();          // PMT Pane in the tab
        pmtPane.setStyle("-fx-background-color: #6495ed;");
        pmtPane.getChildren().addAll(lbFV,lbN,lbStartPrincipal,lbInterest,txtTab02FV,txtTab02N,txtTab02StartPrincipal,txtTab02Interest,btnTab02Calculate);
        pmtPane.setLayoutX(20);
        pmtPane.setLayoutY(20);
        pmtPane.setPrefSize(350,300);

        publicContainers();
        lb01Tab2 = new Label();
        lb01Tab2.setLayoutX(710);
        lb01Tab2.setLayoutY(70);
        lb01Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb01Tab2.setMinWidth(100);

        lb02Tab2 = new Label();
        lb02Tab2.setLayoutX(710);
        lb02Tab2.setLayoutY(100);
        lb02Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb02Tab2.setMinWidth(100);

        lb03Tab2 = new Label();
        lb03Tab2.setLayoutX(710);
        lb03Tab2.setLayoutY(130);
        lb03Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb03Tab2.setMinWidth(100);

        lb04Tab2 = new Label();
        lb04Tab2.setLayoutX(710);
        lb04Tab2.setLayoutY(160);
        lb04Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb04Tab2.setMinWidth(100);

        lb05Tab2 = new Label();
        lb05Tab2.setLayoutX(710);
        lb05Tab2.setLayoutY(190);
        lb05Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb05Tab2.setMinWidth(100);

        lb06Tab2 = new Label();
        lb06Tab2.setLayoutX(710);
        lb06Tab2.setLayoutY(220);
        lb06Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb06Tab2.setMinWidth(100);

        lb07Tab2 = new Label();
        lb07Tab2.setLayoutX(710);
        lb07Tab2.setLayoutY(250);
        lb07Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb07Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb07Tab2.setMinWidth(100);

        lb08Tab2 = new Label();
        lb08Tab2.setLayoutX(710);
        lb08Tab2.setLayoutY(280);
        lb08Tab2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb08Tab2.setAlignment(Pos.CENTER_RIGHT);
        lb08Tab2.setMinWidth(100);

        pmtLayout = new AnchorPane();
        pmtLayout.setStyle("-fx-background-color: #e2cc37;");
        pmtLayout.getChildren().addAll(pmtPane,lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb01Tab2,lb02Tab2,lb03Tab2,lb04Tab2,lb05Tab2,lb06Tab2,lb07Tab2,lb08Tab2);
    }
    public void pmtCalculation (){
                                                                    //PMT Tab Calculations
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {

            periodsN = Double.parseDouble(txtTab02N.getText());
            startPrincipal = Double.parseDouble(txtTab02StartPrincipal.getText());
            interest = Double.parseDouble(txtTab02Interest.getText());
            futureValue = Double.parseDouble(txtTab02FV.getText());

            //formula
            double PMT = (futureValue - (startPrincipal * (Math.pow(1 + interest / 100, periodsN)))) / ((Math.pow(1 + interest / 100, periodsN) - 1) / (interest / 100));
            double PV = futureValue * Math.pow((1 + (interest / 100)), -periodsN);
            double totalPrincipal = startPrincipal + (PMT * periodsN);
            double totalInterest = futureValue - totalPrincipal;

            //set Labels
            lb01Tab2.setText(String.format("$" + "%.2f", futureValue));
            lb02Tab2.setText(String.format("$" + "%.2f", PV));
            lb03Tab2.setText(String.format("$" + "%.3f", periodsN));
            lb04Tab2.setText(String.format("$" + "%.3f", interest));
            lb05Tab2.setText(String.format("$" + "%.2f", PMT));
            lb06Tab2.setText(String.format("$" + "%.2f", startPrincipal));
            lb07Tab2.setText(String.format("$" + "%.2f", totalPrincipal));
            lb08Tab2.setText(String.format("$" + "%.2f", totalInterest));
        }catch (Exception exception) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }


    public void tabPeriodsN (){

        // number of compounding periods (N) tab start now

        lbFV = new Label(" FV (Future Value)");
        lbStartPrincipal = new Label(" Start Principal");
        lbInterest = new Label(" I/Y (Interest)");
        lbPMT = new Label(" PMT (Annuity Payment)");
        txtTab04FV = new TextField();
        txtTab04StartPrincipal = new TextField();
        txtTab04Interest = new TextField();
        txtTab04PMT = new TextField();
        Button btnTab04Calculate = new Button("Calculate");

        lbFV.setLayoutX(20);
        lbFV.setLayoutY(30);
        lbStartPrincipal.setLayoutX(20);
        lbStartPrincipal.setLayoutY(60);
        lbInterest.setLayoutX(20);
        lbInterest.setLayoutY(90);
        lbPMT.setLayoutX(20);
        lbPMT.setLayoutY(120);

        txtTab04FV.setLayoutX(185);
        txtTab04FV.setLayoutY(25);
        txtTab04FV.setStyle("-fx-font-weight: bold");
        txtTab04FV.setPromptText(" $");
        txtTab04StartPrincipal.setLayoutX(185);
        txtTab04StartPrincipal.setLayoutY(55);
        txtTab04StartPrincipal.setStyle("-fx-font-weight: bold");
        txtTab04StartPrincipal.setPromptText(" $");
        txtTab04Interest.setLayoutX(185);
        txtTab04Interest.setLayoutY(85);
        txtTab04Interest.setStyle("-fx-font-weight: bold");
        txtTab04Interest.setPromptText(" %");
        txtTab04PMT.setLayoutX(185);
        txtTab04PMT.setLayoutY(115);
        txtTab04PMT.setStyle("-fx-font-weight: bold");
        txtTab04PMT.setPromptText(" $");

        btnTab04Calculate.setLayoutX(100);           //number of compounding periods (N) tab calculation button
        btnTab04Calculate.setLayoutY(180);
        btnTab04Calculate.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnTab04Calculate.setOnAction(event -> periodsNCalculation());
        financeLabelsCss();

        Pane periodsNPane = new Pane();
        periodsNPane.setStyle("-fx-background-color: #6495ed;");
        periodsNPane.getChildren().addAll(lbFV,lbStartPrincipal,lbInterest,lbPMT,txtTab04FV,txtTab04StartPrincipal,txtTab04Interest,txtTab04PMT,btnTab04Calculate);
        periodsNPane.setLayoutX(20);
        periodsNPane.setLayoutY(20);
        periodsNPane.setPrefSize(350,300);

        publicContainers();
        lb01Tab4 = new Label();
        lb01Tab4.setLayoutX(710);
        lb01Tab4.setLayoutY(70);
        lb01Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb01Tab4.setMinWidth(100);

        lb02Tab4 = new Label();
        lb02Tab4.setLayoutX(710);
        lb02Tab4.setLayoutY(100);
        lb02Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb02Tab4.setMinWidth(100);

        lb03Tab4 = new Label();
        lb03Tab4.setLayoutX(710);
        lb03Tab4.setLayoutY(130);
        lb03Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb03Tab4.setMinWidth(100);

        lb04Tab4 = new Label();
        lb04Tab4.setLayoutX(710);
        lb04Tab4.setLayoutY(160);
        lb04Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb04Tab4.setMinWidth(100);

        lb05Tab4 = new Label();
        lb05Tab4.setLayoutX(710);
        lb05Tab4.setLayoutY(190);
        lb05Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb05Tab4.setMinWidth(100);

        lb06Tab4 = new Label();
        lb06Tab4.setLayoutX(710);
        lb06Tab4.setLayoutY(220);
        lb06Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb06Tab4.setMinWidth(100);

        lb07Tab4 = new Label();
        lb07Tab4.setLayoutX(710);
        lb07Tab4.setLayoutY(250);
        lb07Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb07Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb07Tab4.setMinWidth(100);

        lb08Tab4 = new Label();
        lb08Tab4.setLayoutX(710);
        lb08Tab4.setLayoutY(280);
        lb08Tab4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb08Tab4.setAlignment(Pos.CENTER_RIGHT);
        lb08Tab4.setMinWidth(100);

        periodsNLayout = new AnchorPane();
        periodsNLayout.setStyle("-fx-background-color: #e2cc37;");
        periodsNLayout.getChildren().addAll(periodsNPane,lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb01Tab4,lb02Tab4,lb03Tab4,lb04Tab4,lb05Tab4,lb06Tab4,lb07Tab4,lb08Tab4);

    }
    public void periodsNCalculation() {      //number of compounding periods (N) tab calculations



        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {
            PMT = Double.parseDouble(txtTab04PMT.getText());
            startPrincipal = Double.parseDouble(txtTab04StartPrincipal.getText());
            interest = Double.parseDouble(txtTab04Interest.getText());
            futureValue = Double.parseDouble(txtTab04FV.getText());

            //formula
            double periods = Math.log((futureValue + PMT * 100 / interest) / (startPrincipal + PMT * 100 / interest)) / (Math.log(1 + interest / 100));
            double PV = futureValue * Math.pow((1 + (interest / 100)), -periods);
            double totalPrincipal = startPrincipal + (PMT * periods);
            double totalInterest = futureValue - totalPrincipal;

            //set Values
            lb01Tab4.setText(String.format("$" + "%.2f", futureValue));
            lb02Tab4.setText(String.format("$" + "%.2f", PV));
            lb03Tab4.setText(String.format("$" + "%.2f", periods));
            lb04Tab4.setText(String.format("$" + "%.2f", interest));
            lb05Tab4.setText(String.format("$" + "%.2f", PMT));
            lb06Tab4.setText(String.format("$" + "%.2f", startPrincipal));
            lb07Tab4.setText(String.format("$" + "%.2f", totalPrincipal));
            lb08Tab4.setText(String.format("$" + "%.2f", totalInterest));
        }catch (Exception error) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }
    public void tabStartPrincipal(){

        lbFV = new Label(" FV (Future Value)");
        lbN = new Label(" N (# of periods)");
        lbInterest = new Label(" I/Y (Interest)");
        lbPMT = new Label(" PMT (Annuity Payment)");
        txtTab05FV = new TextField();
        txtTab05N = new TextField();
        txtTab05Interest = new TextField();
        txtTab05PMT = new TextField();
        Button btnTab05Calculate = new Button("Calculate");

        lbFV.setLayoutX(20);
        lbFV.setLayoutY(30);
        lbN.setLayoutX(20);
        lbN.setLayoutY(60);
        lbInterest.setLayoutX(20);
        lbInterest.setLayoutY(90);
        lbPMT.setLayoutX(20);
        lbPMT.setLayoutY(120);

        txtTab05FV.setLayoutX(185);
        txtTab05FV.setLayoutY(25);
        txtTab05FV.setStyle("-fx-font-weight: bold");
        txtTab05FV.setPromptText(" $");
        txtTab05N.setLayoutX(185);
        txtTab05N.setLayoutY(55);
        txtTab05N.setStyle("-fx-font-weight: bold");
        txtTab05N.setPromptText(" Periods");
        txtTab05Interest.setLayoutX(185);
        txtTab05Interest.setLayoutY(85);
        txtTab05Interest.setStyle("-fx-font-weight: bold");
        txtTab05Interest.setPromptText(" %");
        txtTab05PMT.setLayoutX(185);
        txtTab05PMT.setLayoutY(115);
        txtTab05PMT.setStyle("-fx-font-weight: bold");
        txtTab05PMT.setPromptText(" $");

        btnTab05Calculate.setLayoutX(100);
        btnTab05Calculate.setLayoutY(180);
        btnTab05Calculate.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 10px;");
        btnTab05Calculate.setOnAction(event -> startPrincipalCalculation());
        financeLabelsCss();

        Pane startPrincipalPane = new Pane();
        startPrincipalPane.setStyle("-fx-background-color: #6495ed;");
        startPrincipalPane.getChildren().addAll(lbFV,lbN,lbInterest,lbPMT,txtTab05FV,txtTab05N,txtTab05Interest,txtTab05PMT,btnTab05Calculate);
        startPrincipalPane.setLayoutX(20);
        startPrincipalPane.setLayoutY(20);
        startPrincipalPane.setPrefSize(350,300);

        publicContainers();
        lb01Tab5 = new Label();
        lb01Tab5.setLayoutX(710);
        lb01Tab5.setLayoutY(70);
        lb01Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb01Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb01Tab5.setMinWidth(100);

        lb02Tab5 = new Label();
        lb02Tab5.setLayoutX(710);
        lb02Tab5.setLayoutY(100);
        lb02Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb02Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb02Tab5.setMinWidth(100);

        lb03Tab5 = new Label();
        lb03Tab5.setLayoutX(710);
        lb03Tab5.setLayoutY(130);
        lb03Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb03Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb03Tab5.setMinWidth(100);

        lb04Tab5 = new Label();
        lb04Tab5.setLayoutX(710);
        lb04Tab5.setLayoutY(160);
        lb04Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb04Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb04Tab5.setMinWidth(100);

        lb05Tab5 = new Label();
        lb05Tab5.setLayoutX(710);
        lb05Tab5.setLayoutY(190);
        lb05Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb05Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb05Tab5.setMinWidth(100);

        lb06Tab5 = new Label();
        lb06Tab5.setLayoutX(710);
        lb06Tab5.setLayoutY(220);
        lb06Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb06Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb06Tab5.setMinWidth(100);

        lb07Tab5 = new Label();
        lb07Tab5.setLayoutX(710);
        lb07Tab5.setLayoutY(250);
        lb07Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb07Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb07Tab5.setMinWidth(100);

        lb08Tab5 = new Label();
        lb08Tab5.setLayoutX(710);
        lb08Tab5.setLayoutY(280);
        lb08Tab5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb08Tab5.setAlignment(Pos.CENTER_RIGHT);
        lb08Tab5.setMinWidth(100);

        startPrincipalLayout = new AnchorPane();
        startPrincipalLayout.setStyle("-fx-background-color: #e2cc37;");
        startPrincipalLayout.getChildren().addAll(startPrincipalPane,lbHead,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb01Tab5,lb02Tab5,lb03Tab5,lb04Tab5,lb05Tab5,lb06Tab5,lb07Tab5,lb08Tab5);

    }


    public void startPrincipalCalculation(){        //Start Principal Tab Calculation
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        try {
            PMT = Double.parseDouble(txtTab05PMT.getText());
            periodsN = Double.parseDouble(txtTab05N.getText());
            interest = Double.parseDouble(txtTab05Interest.getText());
            futureValue = Double.parseDouble(txtTab05FV.getText());

            double startPrincipal = (futureValue - ((PMT * (Math.pow(1 + interest / 100, periodsN) - 1)) / (interest / 100))) / (Math.pow(1 + interest / 100, periodsN));
            double PV = futureValue * Math.pow((1 + (interest / 100)), -periodsN);
            double totalPrincipal = startPrincipal + (PMT * periodsN);
            double totalInterest = futureValue - totalPrincipal;

            //set Values
            lb01Tab5.setText(String.format("$" + "%.2f", futureValue));
            lb02Tab5.setText(String.format("$" + "%.2f", PV));
            lb03Tab5.setText(String.format("$" + "%.2f", periodsN));
            lb04Tab5.setText(String.format("$" + "%.2f", interest));
            lb05Tab5.setText(String.format("$" + "%.2f", PMT));
            lb06Tab5.setText(String.format("$" + "%.2f", startPrincipal));
            lb07Tab5.setText(String.format("$" + "%.2f", totalPrincipal));
            lb08Tab5.setText(String.format("$" + "%.2f", totalInterest));
        }catch (Exception error) {
            confirmAlert.setAlertType(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Please Check the Input Value !");
            confirmAlert.show();
        }
    }
    public void financeLabelsCss(){         // Finance calculation CSS
        lbFV.setPrefSize(160,0);
        lbFV.setAlignment(Pos.CENTER_RIGHT);
        lbFV .setStyle("-fx-font-size: 15;");
        lbN.setPrefSize(160,0);
        lbN.setAlignment(Pos.CENTER_RIGHT);
        lbN .setStyle("-fx-font-size: 15;");
        lbStartPrincipal.setPrefSize(160,0);
        lbStartPrincipal.setAlignment(Pos.CENTER_RIGHT);
        lbStartPrincipal .setStyle("-fx-font-size: 15;");
        lbInterest.setPrefSize(160,0);
        lbInterest.setAlignment(Pos.CENTER_RIGHT);
        lbInterest .setStyle("-fx-font-size: 15;");
        lbPMT.setPrefSize(160,0);
        lbPMT.setAlignment(Pos.CENTER_RIGHT);
        lbPMT .setStyle("-fx-font-size: 15;");
    }
    public void publicContainers(){             // These containers are common in All tabs
        lbHead = new Label(" Results");
        lbHead.setStyle("-fx-background-color: #138013;"+ "-fx-font-size: 20;"+"-fx-font-weight: bold;");
        lbHead.setLayoutX(425);
        lbHead.setLayoutY(20);
        lbHead.setMinWidth(385);

        lb1 = new Label(" FV (Future Value)");
        lb1.setLayoutX(425);
        lb1.setLayoutY(70);
        lb1.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb1.setMinWidth(275);

        lb2 = new Label(" PV (Present Value)");
        lb2.setLayoutX(425);
        lb2.setLayoutY(100);
        lb2.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb2.setMinWidth(275);

        lb3 = new Label(" N (Number of Periods)");
        lb3.setLayoutX(425);
        lb3.setLayoutY(130);
        lb3.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb3.setMinWidth(275);

        lb4 = new Label(" I/Y (Interest Rate)");
        lb4.setLayoutX(425);
        lb4.setLayoutY(160);
        lb4.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb4.setMinWidth(275);

        lb5 = new Label(" PMT (Periodic Payment)");
        lb5.setLayoutX(425);
        lb5.setLayoutY(190);
        lb5.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb5.setMinWidth(275);

        lb6 = new Label(" Starting Investment");
        lb6.setLayoutX(425);
        lb6.setLayoutY(220);
        lb6.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb6.setMinWidth(275);

        lb7 = new Label(" Total Principal");
        lb7.setLayoutX(425);
        lb7.setLayoutY(250);
        lb7.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb7.setMinWidth(275);

        lb8 = new Label(" Total Interest");
        lb8.setLayoutX(425);
        lb8.setLayoutY(280);
        lb8.setStyle("-fx-background-color: #bababa;"+"-fx-font-size: 15;");
        lb8.setMinWidth(275);
    }
}
