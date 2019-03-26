/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc_predictor;

import java.io.File;
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
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class FXMLDocumentController implements Initializable {

    xmlReader reader = new xmlReader();
    calculate_LOC cal = new calculate_LOC();
    
    @FXML
    private Label label;
    @FXML
    private Button btn_upload;
    @FXML
    private ProgressIndicator progressBar;
    @FXML
    private Button btn_calc;
    @FXML
    private Label file;
    @FXML
    private Label L_est;
    @FXML
    private Label L_class;
    @FXML
    private Label L_methods;
    @FXML
    private Label L_set;
    @FXML
    private Label L_attr;
    @FXML
    private Label L_cons;
    @FXML
    private Label L_get;
    @FXML
    private Label L_gen;
    @FXML
    private Label L_assoc;

    String dir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        reader.setDir(dir);

    }

    @FXML
    private void btn_upload(ActionEvent event) throws ParserConfigurationException, IOException, SAXException {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();
        dir = file.getAbsolutePath();
        reader.setDir(dir);

        reader.JMethods();
        reader.Nconstructor();

        int classes = reader.sumClasses();
        int attr = reader.avgAttributes();
        int assoc = reader.Nasso();
        int gener = reader.Ngener();
        int methods = reader.Nmethods();
        int set =  reader.set;
        int get = reader.get;
        int cons = reader.cons;

        String sClass = Integer.toString(classes);
        String Sattr = Integer.toString(attr);
        String asso = Integer.toString(assoc);
        String gen = Integer.toString(gener);
        String method = Integer.toString(methods);
        String Sset = Integer.toString(reader.set);
        String Sget = Integer.toString(reader.get);
        String Scons = Integer.toString(reader.cons);

        L_class.setText(sClass);
        L_attr.setText(Sattr);
        L_assoc.setText(asso);
        L_gen.setText(gen);
        L_methods.setText(method);
        L_set.setText(Sset);
        L_get.setText(Sget);
        L_cons.setText(Scons);
        
        L_est.setText(Integer.toString(cal.calculate()));

    }

}
