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
        int est = 0;
        double estTemp = (-4379.66) + (181.029 * classes)
                + (142.469 * attr) - (3812.501 * methods) + (8596.627 * set)
                + (6611.383 * cons) + (7166.288 * gener) - (318.648 * assoc);
        est = (int) (estTemp);

        return est;
    }
}
