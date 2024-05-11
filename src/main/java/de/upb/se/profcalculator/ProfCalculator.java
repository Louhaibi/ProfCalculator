package de.upb.se.profcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfCalculator extends Application implements EventHandler<ActionEvent> {

    private final static Value defaultValue = new Value(0);
    private Add addition = new Add(defaultValue, defaultValue);
    private Label errorLabel = new Label("");
    private TextField inputField = new TextField("");
    private Button addButton = new Button("+");
    private Label resultLabel = new Label(addition.computeEquationRepresentation());

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Professional Calculator");
        errorLabel.setTextFill(Color.web("#AA0000"));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(errorLabel, inputField, addButton, resultLabel);
        layout.setPadding(new Insets(20, 80, 20, 80));
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
        addButton.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            int newValue = Integer.parseInt(inputField.getText());
            int oldResult = addition.evaluateExpression();
            addition = new Add(new Value(oldResult), new Value(newValue));
            resultLabel.setText(addition.computeEquationRepresentation());
            inputField.setText("");
            errorLabel.setText("");
            inputField.requestFocus();
        } catch (NumberFormatException e) {
            errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
