package ScamBlock;
import java.io.IOException;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
public class FXMLProfile implements Initializable{

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label labelName;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb){
         try {
            FileInputStream input = new FileInputStream("users.xml");
            XStream xstream = new XStream(new StaxDriver());
            xstream.allowTypes(new Class[]{UserData.class});
            UserData user = (UserData) xstream.fromXML(input);

            // Set the profile labels with the user data
            labelName.setText(user.getNama());
            labelEmail.setText(user.getEmail());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public void switchToHome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        stage = (Stage)((Node)event. getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToPengaturan(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLPengaturan.fxml"));
        stage = (Stage)((Node)event. getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}



