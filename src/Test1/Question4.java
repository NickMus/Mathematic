package Test1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Question4 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton var1;

    @FXML
    private RadioButton var2;

    @FXML
    private RadioButton var3;

    @FXML
    private RadioButton var4;

    @FXML
    private Button nextButton;

    @FXML
    private Button toContentsButton;

    @FXML
    void initialize() {

        nextBtnPress();
        toContentBtn();
    }


    public void nextBtnPress() {

        //int a = count.count;
        nextButton.setOnAction(event -> {
            if (var4.isSelected()) {
                Counter.increaseCount();
                count.setCount(Counter.count);
                System.out.println(count.getCount());
                openNewScene("/Test1/Question5.fxml");
            } else if (var1.isSelected() || var2.isSelected() || var3.isSelected()) {
                openNewScene("/Test1/Question5.fxml");
            }
        });
    }

    public void toContentBtn() {
        toContentsButton.setOnAction(event -> {
            openNewScene("/sample/contents.fxml");
            Counter.countToZero();
        });
    }

    public void openNewScene(String window) {
        nextButton.getScene().getWindow().hide();

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

    Counter count = new Counter();
}
