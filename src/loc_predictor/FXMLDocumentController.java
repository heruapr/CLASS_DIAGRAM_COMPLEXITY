/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc_predictor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button uploadBtn;
    @FXML
    private ProgressIndicator progressBar;
    @FXML
    private Button CalculateBtn;
    @FXML
    private Label file;
    @FXML
    private Label method;
    @FXML
    private Label methodSet;

    @FXML
    private void uploadBtn(ActionEvent event) throws ParserConfigurationException, IOException, SAXException {

        xmlReader reader = new xmlReader();

        method.setText("EHEHE : ");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
