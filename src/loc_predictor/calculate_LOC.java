/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc_predictor;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 */
public class calculate_LOC {

    xmlReader reader = new xmlReader();

    public int calculate() throws ParserConfigurationException, IOException, SAXException {
        reader.JMethods();
        reader.Nconstructor();

        int classes = reader.sumClasses();
        int attr = reader.avgAttributes();
        int assoc = reader.Nasso();
        int gener = reader.Ngener();
        int methods = reader.Nmethods();
        int set = reader.set;
        int get = reader.get;
        int cons = reader.cons;

        int est = classes + attr;

        return est;
    }
}
