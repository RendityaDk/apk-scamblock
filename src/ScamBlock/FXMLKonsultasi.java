package ScamBlock;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLKonsultasi {
    @FXML
    private TextArea chatArea;

    @FXML
    private TextField inputField;

    @FXML
    private Button sendButton;

    @FXML
    private void sendMessage() {
        String userMessage = inputField.getText();
        if (!userMessage.trim().isEmpty()) {
            // Display user's message
            chatArea.appendText("You : " + userMessage + "\n");

            // Generate and display the bot's response
            String botResponse = generateResponse(userMessage);
            chatArea.appendText( botResponse + "\n");

            // Clear the input field
            inputField.clear();
        }
    }

    // This method generates a simple automatic response
    private String generateResponse(String userMessage) {
    // Here you can implement more complex logic or use NLP libraries for better responses
    if (userMessage.toLowerCase().contains("hello")) {
        return "Admin : Hello! Apakah ada yang bisa kami bantu?";
    } else if (userMessage.toLowerCase().contains("bagaimana jika saya terkena penipuan?")) {
        return "Admin : Anda bisa melapor ke kami dengan mengklik tombol 'Lapor' di halaman utama. Kami akan membantu anda secepat mungkin.";
    } else if (userMessage.toLowerCase().contains("apa saja jenis penipuan online yang bisa saya laporkan melalui ScamBlock?")) {
        return "Admin : Segala jenis penipuan online dapat dilaporkan melalui ScamBlock. Contohnya seperti phishing, penipuan investasi, telephone fiktif, undangan palsu, dan lain-lain.";
    } else if (userMessage.toLowerCase().contains("apakah laporan saya akan dijamin kerahasiaannya?")) {
        return "Admin : Tentu saja laporan pengguna akan selalu kami jaga kerahasiaannya.";
    } else if (userMessage.toLowerCase().contains("berapa lama laporan saya akan diproses?")) {
        return "Admin : Karena laporan akan langsung diserahkan kepada pihak Kepolisian setelah pengguna meng-click tombol “kirim” maka lama proses penanganan laporan akan bergantung pada berapa lama pihak Kepolisian menangani laporan pengguna.";
    } else if (userMessage.toLowerCase().contains("apakah ada batasan jumlah laporan yang bisa diajukan per akun?")) {
        return "Admin : Tidak ada, tetapi pengguna dapat mengirim maksimal 3 laporan perharinya.";
    } else {
        return "Admin : Maaf, apa yang dimaksud anda. Mohon untuk bertanya dengan jelas.";
    }
}


    
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
    public void switchToPengaturan(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLPengaturan.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}