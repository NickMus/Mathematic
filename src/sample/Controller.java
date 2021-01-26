package sample;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private Button singInButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Button singUpButton;

    @FXML
    void initialize() {
        singUpButton.setOnAction(event -> {
            openNewScene("/sample/registration.fxml");
        });



        singInButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String passText = passField.getText().trim();

            if (!loginText.equals("") && !passText.equals("")) {
                loginUser(loginText, passText);

            }

        });
    }

    private void loginUser(String loginText, String passText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1) {
            openNewScene("/sample/contents.fxml");
        } else {
            Shake loginAnim = new Shake(loginField);
            Shake passAnim = new Shake(passField);
            loginAnim.playAnim();
            passAnim.playAnim();
        }

    }

    public void openNewScene(String window) {
        singUpButton.getScene().getWindow().hide();

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


