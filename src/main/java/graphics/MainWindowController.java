package graphics;

import core.FileBindings;
import enums.SamplingType;
import enums.TransformType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import jpeg.Process;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    Process Process = new Process();

    @FXML
    private Button btdecodeYR;

    @FXML
    private Button btdecodeitransform;

    @FXML
    private Button btdecodeoversample;

    @FXML
    private Button btdecodequantize;

    @FXML
    private Button btencodeRY;

    @FXML
    private Button btencodedownsample;

    @FXML
    private Button btencodequantize;

    @FXML
    private Button btencodetransform;

    @FXML
    private Button btmodifiedCb;

    @FXML
    private Button btmodifiedblue;

    @FXML
    private Button btmodifiedcr;

    @FXML
    private Button btmodifiedgreen;

    @FXML
    private Button btmodifiedred;

    @FXML
    private Button btmodifiedrgb;

    @FXML
    private Button btmodifiedy;

    @FXML
    private Button btoqcount;

    @FXML
    private Button btorigY;

    @FXML
    private Button btorigblue;

    @FXML
    private Button btoriggreen;

    @FXML
    private Button btoriginalshowimage;

    @FXML
    private Button btorigred;

    @FXML
    private Button btoringCb;

    @FXML
    private Button btoringCr;

    @FXML
    private ComboBox<SamplingType> dropencodesampling;

    @FXML
    private ComboBox<TransformType> dropencodetransform;

    @FXML
    private Spinner<?> encodecounter;

    @FXML
    private TextField encodeslidershow;

    @FXML
    private CheckBox encodesteps;

    @FXML
    private CheckBox origshades;

    @FXML
    private CheckBox origshades1;

    @FXML
    private Slider sliderencode;

    @FXML
    void count(ActionEvent event) {

    }

    @FXML
    void decodequantize(ActionEvent event) {

    }

    @FXML
    void downsample(ActionEvent event) {

    }

    @FXML
    void encodequantize(ActionEvent event) {

    }

    @FXML
    void itransform(ActionEvent event) {

    }

    @FXML
    void modblue(ActionEvent event) {

    }

    @FXML
    void modcb(ActionEvent event) {

    }

    @FXML
    void modcr(ActionEvent event) {

    }

    @FXML
    void modgreen(ActionEvent event) {

    }

    @FXML
    void modreg(ActionEvent event) {

    }

    @FXML
    void mody(ActionEvent event) {

    }

    @FXML
    void origblue(ActionEvent event) {

    }

    @FXML
    void origcb(ActionEvent event) {

    }

    @FXML
    void origcr(ActionEvent event) {

    }

    @FXML
    void origgreen(ActionEvent event) {

    }

    @FXML
    void originaly(ActionEvent event) {

    }

    @FXML
    void origred(ActionEvent event) throws IOException {
    }

    @FXML
    void oversample(ActionEvent event) {

    }

    @FXML
    void rgb(ActionEvent event) throws IOException {



        File file = new File(FileBindings.defaultImage);
        Dialogs.showImageInWindow(Process.getImageFromRGB(), "Red only", true);

    }

    @FXML
    void rgbtoycbcr(ActionEvent event) {

    }

    @FXML
    void showimage(ActionEvent event) throws IOException {

        File file = new File(FileBindings.defaultImage);
        Dialogs.showImageInWindow(ImageIO.read(file), "Original", true);
    }

    @FXML
    void transform(ActionEvent event) {

    }

    @FXML
    void ycbcrtorgb(ActionEvent event) {

    }

    @FXML
    void origshades(ActionEvent event) {

    }

    @FXML
    void modifiedshades(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dropencodesampling.getItems().addAll(SamplingType.values());
        dropencodetransform.getItems().addAll(TransformType.values());

        dropencodesampling.getSelectionModel().select(SamplingType.S_4_4_4);
        dropencodetransform.getSelectionModel().select(TransformType.DCT);
    }
}
