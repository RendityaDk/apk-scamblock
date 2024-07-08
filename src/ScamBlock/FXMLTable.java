package ScamBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

public class FXMLTable {
    
    @FXML
    private TreeTableView<LaporData> tableView;

    @FXML
    private TreeTableColumn<LaporData, String> timeColumn;

    @FXML
    private TreeTableColumn<LaporData, String> kejadianColumn;

    @FXML
    private TreeTableColumn<LaporData, String> kronologiColumn;

    @FXML
    private TreeTableColumn<LaporData, String> nameColumn;

    @FXML
    private TreeTableColumn<LaporData, String> addressColumn;

    @FXML
    private TreeTableColumn<LaporData, String> genderColumn;

    @FXML
    private TreeTableColumn<LaporData, String> numberColumn;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize() {
        timeColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("time"));
        kejadianColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("kejadian"));
        kronologiColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("kronologi"));
        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("address"));
        genderColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("gender"));
        numberColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("number"));

        loadDataFromXML();
    }

    private void loadDataFromXML() {
        try {
            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("lapor", LaporData.class);
            xstream.allowTypes(new Class[] { LaporData.class });

            String filePath = "lapor.xml";
            FileInputStream input = new FileInputStream(filePath);

            List<LaporData> list = (List<LaporData>) xstream.fromXML(input);

            ObservableList<LaporData> data = FXCollections.observableArrayList(list);

            TreeItem<LaporData> rootItem = new TreeItem<>(new LaporData("Root", "", "", "", "", "", ""));
            for (LaporData lapor : data) {
                rootItem.getChildren().add(new TreeItem<>(lapor));
            }
            tableView.setRoot(rootItem);
            tableView.setShowRoot(false);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        TreeItem<LaporData> selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.getParent() != null) {
            selectedItem.getParent().getChildren().remove(selectedItem);
            saveDataToXML();
        }
    }

    private void saveDataToXML() {
        try {
            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("lapor", LaporData.class);
            xstream.allowTypes(new Class[] { LaporData.class });

            String filePath = "lapor.xml";
            FileOutputStream output = new FileOutputStream(filePath);

            List<LaporData> list = new ArrayList<>();
            for (TreeItem<LaporData> item : tableView.getRoot().getChildren()) {
                list.add(item.getValue());
            }

            xstream.toXML(list, output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void switchToLapor(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLLapor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}




