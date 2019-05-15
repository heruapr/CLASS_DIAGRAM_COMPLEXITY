
package model;

import controller.calculate_LOC;
import controller.xmlReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 *///
public class ResultsMetrics {

    //calculate_LOC cal = new calculate_LOC();
    //xmlReader reader = new xmlReader();

     private static int classes, gener, assoc;
     private static double methods, set, get, cons, attr;

    public int getClasses() {
        return classes; 
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getGener() {
        return gener;
    }

    public void setGener(int gener) {
        this.gener = gener;
    }

    public int getAssoc() {
        return assoc;
    }

    public void setAssoc(int assoc) {
        this.assoc = assoc;
    }

    public double getMethods() {
        return methods;
    }

    public void setMethods(double methods) {
        this.methods = methods;
    }

    public double getSet() {
        return set;
    }

    public void setSet(double set) {
        this.set = set;
    }

    public double getGet() {
        return get;
    }

    public void setGet(double get) {
        this.get = get;
    }

    public double getCons() {
        return cons;
    }

    public void setCons(double cons) {
        this.cons = cons;
    }

    public double getAttr() {
        return attr;
    }

    public void setAttr(double attr) {
        this.attr = attr;
    }
}
