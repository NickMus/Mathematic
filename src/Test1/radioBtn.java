package Test1;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class radioBtn {
    @FXML
    private RadioButton var1;

    @FXML
    private RadioButton var2;

    @FXML
    private RadioButton var3;

    @FXML
    private RadioButton var4;


    public void radioBtnChoose() {
        ToggleGroup group = new ToggleGroup();
        var1.setToggleGroup(group);
        var2.setToggleGroup(group);
        var3.setToggleGroup(group);
        var4.setToggleGroup(group);
    }
}
