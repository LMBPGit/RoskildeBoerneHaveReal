package Models;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SygeBlanket {

    private TextField sickNameField, sickTimeField, sickDateField;
    private TextField replaceNameField, replaceTimeField;
    private VBox overBox;
    private HBox sickGuy, replaceGuy;

    public SygeBlanket(TextField sickNameField, TextField sickTime, TextField sickDateField, TextField replaceNameField, TextField replaceTimeField) {
        this.sickNameField = sickNameField;
        this.sickTimeField = sickTime;
        this.sickDateField = sickDateField;
        this.replaceNameField = replaceNameField;
        this.replaceTimeField = replaceTimeField;
    }

    public TextField getSickNameField() {
        return sickNameField;
    }

    public void setSickNameField(TextField sickNameField) {
        this.sickNameField = sickNameField;
    }

    public TextField getSickTimeField() {
        return sickTimeField;
    }

    public void setSickTimeField(TextField sickTimeField) {
        this.sickTimeField = sickTimeField;
    }

    public TextField getSickDateField() {
        return sickDateField;
    }

    public void setSickDateField(TextField sickDateField) {
        this.sickDateField = sickDateField;
    }

    public TextField getReplaceNameField() {
        return replaceNameField;
    }

    public void setReplaceNameField(TextField replaceNameField) {
        this.replaceNameField = replaceNameField;
    }

    public TextField getReplaceTimeField() {
        return replaceTimeField;
    }

    public void setReplaceTimeField(TextField replaceTimeField) {
        this.replaceTimeField = replaceTimeField;
    }

    public VBox getOverBox() {
        return overBox;
    }

    public void setOverBox(VBox overBox) {
        this.overBox = overBox;
    }

    public HBox getSickGuy() {
        return sickGuy;
    }

    public void setSickGuy(HBox sickGuy) {
        this.sickGuy = sickGuy;
    }

    public HBox getReplaceGuy() {
        return replaceGuy;
    }

    public void setReplaceGuy(HBox replaceGuy) {
        this.replaceGuy = replaceGuy;
    }
}
