/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    int a;

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button fxbutton1;
    @FXML
    private Button fxbutton2;
    @FXML
    private TextField fxtxtfield;
    @FXML
    private Button Button_jasper;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        openWindow2();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Jamie initialize ");
        a++;
    }

    private void onClickButton(ActionEvent event) {

        openWindow2();

    }

    private void testMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" JAmie JAmie");

        }
    }

    void openWindow2() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLWindow2.fxml"));
            Parent root = loader.load();

            FXMLWindow2Controller window2Controller = loader.getController();

            window2Controller.getID(100);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void PrintData(ActionEvent event) {
        try {
            JasperReport JR;
            JasperPrint JP;

            // String Q="%"+this.txtSearch.getText() +"%";
            // String Source="C:\\Users\\JAMIEXXX3\\Documents\\NetBeansProjects\\Phonelist\\src\\Forms\\report1.jrxml";
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\reports\\\\report1.jrxml");
            System.out.println(System.getProperty("user.dir") + "\\\\reports\\\\report1.jrxml");
            String SQL = "SELECT * FROM dcaa_databse.student_info;";
            String Location = System.getProperty("user.dir") + "\\\\reports\\\\";

            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            JP = JasperFillManager.fillReport(JR, null, DBConnection.getConnection());
            JasperViewer.viewReport(JP, false);

        } catch (JRException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
