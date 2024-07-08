package ScamBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;

public class FXMLLapor {

    @FXML
    private Button kirim;

    @FXML
    private Button table;

    @FXML
    private DatePicker time;

    @FXML
    private TextField kejadian;

    @FXML
    private TextArea kronologi;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField gender;

    @FXML
    private TextField number;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    private void kirim(ActionEvent event) {
        String timeValue = time.getEditor().getText();
        String kejadianValue = kejadian.getText();
        String kronologiValue = kronologi.getText();
        String nameValue = name.getText();
        String addressValue = address.getText();
        String genderValue = gender.getText();
        String numberValue = number.getText();

        try {
            // Validasi agar semua data terisi 
            if (timeValue.isEmpty() || kejadianValue.isEmpty() || kronologiValue.isEmpty() || nameValue.isEmpty() || addressValue.isEmpty() || genderValue.isEmpty() || numberValue.isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("All fields must be filled in");
                alert.showAndWait();
            } else {
                List<LaporData> list = loadDataFromXML();
                if(list == null) {
                    list = new java.util.ArrayList<>();
                }
                LaporData newLapor = new LaporData(timeValue, kejadianValue, kronologiValue, nameValue, addressValue, genderValue, numberValue);

                list.add(newLapor);
                XStream xstream = new XStream(new StaxDriver());
                xstream.allowTypes(new Class[] {LaporData.class});

                String xml = xstream.toXML(list);

                try {
                    // Menyimpan data ke file XML
                    String filePath = "lapor.xml";
                    FileOutputStream output = new FileOutputStream(filePath);
                    output.write(xml.getBytes());
                    output.close();

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Your report has been sent successfully!");
                    alert.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Failed to save the report");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while processing the report");
            alert.showAndWait();
        }
    }

    private List<LaporData> loadDataFromXML() {
        try {
            List<LaporData> list = null;
            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("lapor", LaporData.class);
            xstream.allowTypes(new Class[] { LaporData.class });

            String filePath = "lapor.xml";
            FileInputStream input = new FileInputStream(filePath);

            list = (List<LaporData>) xstream.fromXML(input);

            return list;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public void switchToTable(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLTable.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToKonsultasi(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLKonsultasi.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBerita(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLBeritaArtikel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPengaturan(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLPengaturan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToProfil(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLProfil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}