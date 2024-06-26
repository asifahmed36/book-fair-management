/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FeedbackSceneController implements Initializable {

    @FXML
    private TextField feedbackTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void feedbackEditOnClick(MouseEvent event) {
        feedbackTextField.setText(null);
    }

    @FXML
    private void feedbackButtonOnClick(ActionEvent event) {
          File f = null;
        FileOutputStream fos = null;
        
        DataOutputStream dos = null;

        try {
            f = new File("feedbackdata.bin");
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);

            dos.writeUTF(feedbackTextField.getText());
            
            
            
           
           feedbackTextField.setText("");
            


        } catch (IOException ex) {
            //Logger.getLogger(SearchingBookSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException ex) {
                //Logger.getLogger(SearchingBookSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void backButtonOnClcik(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("BuyerScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
