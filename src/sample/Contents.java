package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class Contents {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton firstTest;

    @FXML
    private Button startTest;

    @FXML
    void initialize() {

        startTest();

    }

    public void startTest() {
        startTest.setOnAction(event -> {
            if(firstTest.isSelected()) {
                openNewScene("/Test1/Question1.fxml");
            }
        });
    }

    public RadioButton getFirstTest() {
        return firstTest;
    }

    public void openNewScene(String window) {
        startTest.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
