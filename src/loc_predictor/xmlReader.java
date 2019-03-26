/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc_predictor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlReader {

    static String dir;

    public static void setDir(String dir) {
        xmlReader.dir = dir;
    }

//    public static void setDir(String dir) {
//        dir = dir;
//    }
//    public static void main(String[] args) throws ParserConfigurationException,
//            IOException, SAXException {
//        int classes = sumClasses();
//        int attr = avgAttributes();
//        int methods = Nmethods();
//        int asso = Nasso();
//        int gener = Ngener();
//
//        System.out.println("Jumlah class = " + classes);
//        System.out.println("Jumlah attribute = " + attr);
//        System.out.println("Jumlah methods = " + methods);
//        System.out.println("Jumlah association " + asso);
//        System.out.println("Jumlah generalization " + gener);
//        JMethods();
//        Nconstructor();
    //}
    // NUMBER OF CLASSES
    public static int sumClasses() throws ParserConfigurationException,
            IOException, SAXException {
        //File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        File file = new File(dir);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);
        Element parent = (Element) document.getElementsByTagName("Shapes").item(0);
        NodeList list = parent.getElementsByTagName("Class");
        int i;
        for (i = 0; i < list.getLength(); i++) {
            Element classes = (Element) list.item(i);
            //System.out.println((i + 1) + classes.getAttribute("Name"));

        }
        return i;
    }

    // NUMBER OF Attributes
    public static int avgAttributes() throws ParserConfigurationException,
            IOException, SAXException {
        int i;
        // File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        File file = new File(dir);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element parent = (Element) document.getElementsByTagName("Model").item(0);
        NodeList list = parent.getElementsByTagName("Attribute");

        for (i = 0; i < list.getLength(); i++) {
            Element attr = (Element) list.item(i);
            //System.out.println((i + 1) + attr.getAttribute("Name"));
        }
        return i;
    }

    // NUMBER OF METHODS
    public static int Nmethods() throws ParserConfigurationException,
            IOException, SAXException {
        int i;
//        File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        File file = new File(dir);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element parent = (Element) document.getElementsByTagName("Model").item(0);
        NodeList list = parent.getElementsByTagName("Operation");

        for (i = 0; i < list.getLength(); i++) {
            Element methods = (Element) list.item(i);
            // System.out.println((i + 1) + methods.getAttribute("Name"));
        }
        return i;
    }

    //jenis method setter,getter
    public static void JMethods() throws ParserConfigurationException,
            IOException, SAXException {
//        File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        File file = new File(dir);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element parent = (Element) document.getElementsByTagName("Model").item(0);
        NodeList list = parent.getElementsByTagName("Operation");
        int set = 0;
        int get = 0;
        String setter = null, getter = null;
        int i = list.getLength();
        String[] arr = new String[i];
        for (i = 0; i < list.getLength(); i++) {
            Element methods = (Element) list.item(i);

            arr[i] = methods.getAttribute("Name");
            //SETTER
            if (arr[i].substring(0, 3).equalsIgnoreCase("set")) {
                setter = arr[i];
                set++;

            } else if (arr[i].substring(0, 3).equalsIgnoreCase("get")) {
                getter = arr[i];
                get++;
                System.out.println("Mengandung get : " + getter);

            }
        }
        System.out.println("Mengandung set : " + setter);
        System.out.println("getter : " + get);
        System.out.println("setter : " + set);

    }

    //JUMLAH CONSTRUCTOR
    public static void Nconstructor() throws ParserConfigurationException,
            IOException, SAXException {
        File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);
        int cons = 0;

        //class
        Element parent = (Element) document.getElementsByTagName("Shapes").item(0);
        NodeList list = parent.getElementsByTagName("Class");

        int i = list.getLength();
        String[] arr = new String[i];
        for (i = 0; i < list.getLength(); i++) {
            Element classes = (Element) list.item(i);
            arr[i] = classes.getAttribute("Name");
        }
        //methods
        Element parent2 = (Element) document.getElementsByTagName("Model").item(0);
        NodeList list2 = parent2.getElementsByTagName("Operation");
        int j = list2.getLength();
        String[] arr1 = new String[j];

        for (j = 0; j < list2.getLength(); j++) {
            Element methods = (Element) list2.item(j);
            arr1[j] = methods.getAttribute("Name");
        }

        //looking for constructor
        for (int a = 0; a < list.getLength(); a++) {
            for (int b = 0; b < list2.getLength(); b++) {
                if (arr1[b].equals(arr[a])) {
                    cons++;
                }
            }
        }
        System.out.println("KETEMU CONSTRUCTOR SEBANYAK : " + cons);
    }

    // Association
    public static int Nasso() throws ParserConfigurationException,
            IOException, SAXException {
        int i;
        File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element parent = (Element) document.getElementsByTagName("ModelChildren").item(0);
        NodeList list = parent.getElementsByTagName("Association");

        for (i = 0; i < list.getLength(); i++) {
            Element rel = (Element) list.item(i);
            //System.out.println((i + 1) + rel.getAttribute("id"));
        }
        return i / 2;
    }

    // Generalization
    public static int Ngener() throws ParserConfigurationException,
            IOException, SAXException {
        int i;
        File file = new File("/C:/SECOND DRIVE/KULIAH/SEM.8/project.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element parent = (Element) document.getElementsByTagName("ModelChildren").item(0);
        NodeList list = parent.getElementsByTagName("Generalization");

        for (i = 0; i < list.getLength(); i++) {
            Element rel = (Element) list.item(i);
            // System.out.println((i + 1) + rel.getAttribute("id"));
        }
        return i / 2;
    }
}

//}
