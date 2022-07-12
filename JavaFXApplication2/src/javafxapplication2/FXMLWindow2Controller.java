/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class FXMLWindow2Controller implements Initializable {

    @FXML
    private Button fxbutton2;

    private int ID;
    @FXML
    private TableColumn<?, ?> jamie;
    @FXML
    private TableColumn<?, ?> jamie2;
    @FXML
    private TableColumn<?, ?> coloumx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PrintData(ActionEvent event) {
        System.out.println("ID is " + ID);
    }

    void getID(int ID_) {
        ID = ID_;

    }

}
