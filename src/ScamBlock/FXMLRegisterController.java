package ScamBlock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FXMLRegisterController implements Initializable{

    private static final String FXMLLogin = "/ScamBlock/FXMLLogin.fxml";

    @FXML
    private TextField inputNama;

    @FXML
    private TextField inputEmaill;

    @FXML
    private PasswordField inputPasswordd;

    @FXML
    private Button buttonCreateAccount;
 
    // Import Bagian Openscene 
    private OpenScene openScene = new OpenScene();

    // Bagian Register
    @FXML
    private void createAccount(ActionEvent event) {
        // Membuat variabel
        String name = inputNama.getText();
        String email = inputEmaill.getText();
        String password = inputPasswordd.getText();

        try {
            // Validasi agar semua data terisi 
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("All fields must be filled in");
                alert.showAndWait();
            } else {
                UserData newUser = new UserData(name, email, password);

                XStream xstream = new XStream(new StaxDriver());
                xstream.allowTypes(new Class[] {UserData.class});

                String xml = xstream.toXML(newUser);

                try {
                    // Menyimpan data ke file XML
                    String filePath = "users.xml";
                    FileOutputStream output = new FileOutputStream(filePath);
                    output.write(xml.getBytes());   
                    output.close();

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success Created Account");
                    alert.setHeaderText(null);
                    alert.setContentText("Account has been created successfully");
                    alert.showAndWait();
                    
                    openScene.openScene("FXMLLogin", buttonCreateAccount);

                }catch (IOException e){
                    System.out.println("Failed to save the file");
                    System.exit(0);
                }
            } 
                
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}








