
package model;

import controller.calculate_LOC;
import controller.xmlReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 */
public class getResultsMetrics {

//    calculate_LOC cal = new calculate_LOC();
    xmlReader reader = new xmlReader();

    static int classes, gener, assoc;
    double methods, set, get, cons, attr;

    public int getClasses() throws ParserConfigurationException, IOException, SAXException {
        classes = reader.sumClasses();
        return classes;
    }

    public double getAttr() throws ParserConfigurationException, IOException, SAXException {
        attr = reader.avgAttributes();
        return attr;
    }

    public int getAssoc() throws ParserConfigurationException, IOException, SAXException {
        assoc = reader.Nasso();
        return assoc;
    }

    public int getGener() throws ParserConfigurationException, IOException, SAXException {
        gener = reader.Ngener();
        return gener;
    }

    public double getMethods() throws ParserConfigurationException, IOException, SAXException {
        methods = reader.Nmethods();
        return methods;
    }

    public double getSet() throws ParserConfigurationException, IOException, SAXException {
        reader.JMethods();
        set = reader.avgSet;
        return set;
    }

    public double getGet() throws ParserConfigurationException, IOException, SAXException {
        reader.JMethods();
        get = reader.avgGet;
        return get;
    }

    public double getCons() throws ParserConfigurationException, IOException, SAXException {

        reader.Nconstructor();
        cons = reader.avgCons;
        return cons;
    }

}
