
package model;

import controller.calculate_LOC;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 */
public class getResultLOC {

    calculate_LOC cal = new calculate_LOC();
    int est = 0;

    public int getEst() throws ParserConfigurationException, IOException, SAXException {
        est = cal.calculate();
        return est;
    }

}
