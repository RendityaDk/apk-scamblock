package ScamBlock;

import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;  
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLHomePage{

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchFiturLapor(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLLapor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchFiturBerita(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBeritaArtikel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchFiturKonsultasi(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLKonsultasi.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchFiturProfil(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLProfil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchFiturPengaturan(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLPengaturan.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


