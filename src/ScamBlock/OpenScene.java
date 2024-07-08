package ScamBlock;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpenScene {
    private double x, y;

    public void openScene(String sceneName, Node node){
        try{
            // Menutup stage/window sebelumnya
            node.getScene().getWindow().hide();

            // Membuka scene baru
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName + ".fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.initStyle(StageStyle.TRANSPARENT);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            
            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

                       
            stage.setScene(scene);
            stage.show();


            

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



