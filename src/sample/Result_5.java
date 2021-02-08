package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Test1.Counter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Result_5 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button toContentsButton;

    @FXML
    void initialize() {
        toContentBtn();
    }

    public void toContentBtn() {
        toContentsButton.setOnAction(event -> {
            openNewScene("/sample/contents.fxml");
            Counter.countToZero();
        });
    }

         void openNewScene(String window){
            toContentsButton.getScene().getWindow().hide();

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

