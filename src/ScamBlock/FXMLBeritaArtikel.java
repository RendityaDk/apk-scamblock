package ScamBlock;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXMLBeritaArtikel {
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
    public void switchToKonsultasi(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLKonsultasi.fxml"));
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
    public void switchToPengaturan(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLPengaturan.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBerita1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBerita1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }public void switchToBerita2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBerita2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }public void switchToBerita3(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBerita3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }public void switchToBerita4(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBerita4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }public void switchToBerita5(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLBerita5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
