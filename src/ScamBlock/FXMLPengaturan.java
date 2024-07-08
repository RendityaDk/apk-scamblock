package ScamBlock;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class FXMLPengaturan {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToHome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLapor(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLLapor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBerita(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBeritaArtikel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
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
    public void switchToKonsultasi(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLKonsultasi.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBack(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    


}
