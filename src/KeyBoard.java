import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KeyBoard {

    public VBox cal() {

        Alert confirmAlert = new Alert(Alert.AlertType.ERROR);
        VBox keyBord = new VBox();
        keyBord.setPrefSize(225, 300);
        keyBord.setLayoutX(900);
        keyBord.setLayoutY(50);

        HBox h01 = new HBox();
        h01.setPrefSize(300, 100);


        HBox h02 = new HBox();
        h02.setPrefSize(300, 100);


        HBox h03 = new HBox();
        h03.setPrefSize(300, 100);


        HBox h04 = new HBox();
        h04.setPrefSize(300, 100);

        String command = "Please Select relevant Textfield !";

        Button num1 = new Button("1");          // Number 01 Button
        num1.setPrefSize(75, 75);
        num1.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num1.setFocusTraversable(false);
        num1.setOnAction(event -> {
            try{
                TextField text = (TextField) num1.getScene().getFocusOwner();
                text.setText(text.getText() + "1");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });


        Button num2 = new Button("2");            // Number 02 Button
        num2.setPrefSize(75, 75);
        num2.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num2.setFocusTraversable(false);
        num2.setOnAction(event -> {
            try{
                TextField text = (TextField) num2.getScene().getFocusOwner();
                text.setText(text.getText() + "2");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num3 = new Button("3");            // Number 03 Button
        num3.setPrefSize(75, 75);
        num3.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num3.setFocusTraversable(false);
        num3.setOnAction(event -> {
            try{
                TextField text = (TextField) num3.getScene().getFocusOwner();
                text.setText(text.getText() + "3");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num4 = new Button("4");            // Number 04 Button
        num4.setPrefSize(75, 75);
        num4.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num4.setFocusTraversable(false);
        num4.setOnAction(event -> {
            try{
                TextField text = (TextField) num4.getScene().getFocusOwner();
                text.setText(text.getText() + "4");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num5 = new Button("5");            // Number 05 Button
        num5.setPrefSize(75, 75);
        num5.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num5.setFocusTraversable(false);
        num5.setOnAction(event -> {
            try{
                TextField text = (TextField) num5.getScene().getFocusOwner();
                text.setText(text.getText() + "5");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText("Please Check the Input Value !");
                confirmAlert.show();
            }

        });

        Button num6 = new Button("6");            // Number 06 Button
        num6.setPrefSize(75, 75);
        num6.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num6.setFocusTraversable(false);
        num6.setOnAction(event -> {
            try{
                TextField text = (TextField) num6.getScene().getFocusOwner();
                text.setText(text.getText() + "6");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }
            TextField text = (TextField) num6.getScene().getFocusOwner();
            text.setText(text.getText() + "6");
        });

        Button num7 = new Button("7");            // Number 07 Button
        num7.setPrefSize(75, 75);
        num7.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num7.setFocusTraversable(false);
        num7.setOnAction(event -> {
            try{
                TextField text = (TextField) num7.getScene().getFocusOwner();
                text.setText(text.getText() + "7");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num8 = new Button("8");                // Number 08 Button
        num8.setPrefSize(75, 75);
        num8.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num8.setFocusTraversable(false);
        num8.setOnAction(event -> {
            try{
                TextField text = (TextField) num8.getScene().getFocusOwner();
                text.setText(text.getText() + "8");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num9 = new Button("9");                // Number 09 Button
        num9.setPrefSize(75, 75);
        num9.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num9.setFocusTraversable(false);
        num9.setOnAction(event -> {
            try{
                TextField text = (TextField) num9.getScene().getFocusOwner();
                text.setText(text.getText() + "9");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button num0 = new Button("0");                // Number 0 Button
        num0.setPrefSize(75, 75);
        num0.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        num0.setFocusTraversable(false);
        num0.setOnAction(event -> {
            try{
                TextField text = (TextField) num0.getScene().getFocusOwner();
                text.setText(text.getText() + "0");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button doublePoint = new Button(".");                 // Decimal point Button
        doublePoint.setPrefSize(75, 75);
        doublePoint.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        doublePoint.setFocusTraversable(false);
        doublePoint.setOnAction(event -> {
            try{
                TextField text = (TextField) doublePoint.getScene().getFocusOwner();
                text.setText(text.getText() + ".");

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        Button clearBtn = new Button("del");                  //Clear Button
        clearBtn.setPrefSize(75, 75);
        clearBtn.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;");
        clearBtn.setFocusTraversable(false);
        clearBtn.setOnAction(event -> {
            try{
                TextField text = (TextField) clearBtn.getScene().getFocusOwner();
                String clearOneStr = text.getText().substring(0, text.getText().length() - 1);
                text.setText(clearOneStr);

            }catch (Exception error) {
                confirmAlert.setAlertType(Alert.AlertType.ERROR);
                confirmAlert.setHeaderText(command);
                confirmAlert.show();
            }

        });

        keyBord.getChildren().addAll(h01, h02, h03, h04);
        h01.getChildren().addAll(num1, num2, num3);
        h02.getChildren().addAll(num4, num5, num6);
        h03.getChildren().addAll(num7, num8, num9);
        h04.getChildren().addAll(clearBtn, num0, doublePoint);

        return keyBord;

    }

}
