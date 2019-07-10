package controller;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import model.ResultLOC;
import model.ResultsMetrics;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 */
//
public class calculate_LOC {

    //xmlReader reader = new xmlReader();
    ResultsMetrics result = new ResultsMetrics();
    ResultLOC res = new ResultLOC();

    public int calculate() throws ParserConfigurationException, IOException, SAXException {

        int classes = result.getClasses();
        double attr = result.getAttr();
        int assoc = result.getAssoc();
        int gener = result.getGener();
        double methods = result.getMethods();
        double set = result.getSet();
        double get = result.getGet();
        double cons = result.getCons();
        int est ;
//        double estTemp = (-4379.66) + (181.029 * classes)
//                + (142.469 * attr) - (3812.501 * methods) + (8596.627 * set)
//                + (6611.383 * cons) + (7166.288 * (double) gener) - (318.648 * (double) assoc);
          double estTemp = (-4379.66) + (181.029 * classes)
                + (142.469 * attr) - (3812.501 * methods) + (8596.627 * set)
                + (6611.383 * cons) + (7166.288 * (double) gener) - (318.648 * (double) assoc);

        est = ((int) estTemp);
        res.setEst(est);
        return est;   
    }
}
