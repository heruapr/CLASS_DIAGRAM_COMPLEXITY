package model;

import controller.calculate_LOC;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 *///
public class ResultLOC {

    private static int est;

    public int getEst() {
        return est;
    }
    public void setEst(int est) {
        ResultLOC.est = est;
        System.out.println(est);
    }

}
