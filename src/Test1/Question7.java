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
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;

import javax.swing.*;


public class Question7 extends radioBtn {

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
        radioBtnChoose();
        nextButton.setOnAction(event -> {
            if (var2.isSelected()) {
                Counter.increaseCount();
                count.setCount(Counter.count);
                System.out.println(count.getCount());
                if(count.getCount() == 7) {
                    openNewScene("/sample/Result_5.fxml");
                }
            }else if (var3.isSelected() || var1.isSelected() || var4.isSelected()) {
               if(count.getCount() == 5 || count.getCount() == 6) {
                   openNewScene("/sample/Result_4.fxml");
               }
               else if(count.getCount() == 4) {
                   openNewScene("/sample/Result_3.fxml");
               } else if(count.getCount() < 4) {
                   openNewScene("/sample/Result_2.fxml");
               }
            }
            JOptionPane.showMessageDialog(null, "Правильных ответов: " + count.getCount());

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
