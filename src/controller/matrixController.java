/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.xmlReader.dir;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.ResultsMetrics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author HP PC
 */
public class matrixController {

    Element classes;
    Element association;

    xmlReader reader = new xmlReader();

    public void makeMatrix() throws ParserConfigurationException, SAXException, IOException {
        ResultsMetrics result = new ResultsMetrics();
        int ordo = result.getClasses();
        int i = 1;
        String[] arr_idClass = new String[i];
        String[] arr_className = new String[ordo];
        String[] arr_className2 = new String[ordo];

        //inserting class id to array
        File file = new File(dir);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);
        Element parent = (Element) document.getElementsByTagName("Shapes").item(0);
        NodeList list = parent.getElementsByTagName("Class");

        //getting the id of each class
        NodeList list_id = parent.getElementsByTagName("Class");
        for (i = 0; i < ordo; i++) {
            classes = (Element) list.item(i);
            Element class_id = (Element) list_id.item(i);
            arr_className[i] = classes.getAttribute("Id");
            arr_className2[i] = classes.getAttribute("Name");
            System.out.println("classes =" + (i + 1)
                    + classes.getAttribute("Name") + " id = " + class_id.getAttribute("Id")
            );
            System.out.println(arr_className[i]);
        }

        //inserting rel "from and to" to array
        File file2 = new File(dir);
        DocumentBuilderFactory builderFactory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = builderFactory.newDocumentBuilder();
        Document document2 = builder2.parse(file2);
        Element parent2 = (Element) document2.getElementsByTagName("Connectors").item(0);
        //getting the id of each class
        NodeList list_relationship = parent2.getElementsByTagName("Association");
        NodeList list_relationship2 = parent2.getElementsByTagName("Generalization");
        NodeList list_relationship3 = parent2.getElementsByTagName("Aggregation");
        NodeList list_relationship4 = parent2.getElementsByTagName("Dependency");
        NodeList list_relationship5 = parent2.getElementsByTagName("Realization");
        NodeList list_relationship6 = parent2.getElementsByTagName("Composition");

        int totalLength = list_relationship.getLength() + list_relationship2.getLength()
                + list_relationship3.getLength() + list_relationship4.getLength() + list_relationship5.getLength()
                + list_relationship6.getLength();

        String[] arrAssoc_idConnectTo = new String[list_relationship.getLength()];
        String[] arrAssoc_idConnectFrom = new String[list_relationship.getLength()];

        String[] arrGener_idConnectTo = new String[list_relationship2.getLength()];
        String[] arrGener_idConnectFrom = new String[list_relationship2.getLength()];

        String[] arrAgg_idConnectTo = new String[list_relationship3.getLength()];
        String[] arrAgg_idConnectFrom = new String[list_relationship3.getLength()];

        String[] arrDep_idConnectTo = new String[list_relationship4.getLength()];
        String[] arrDep_idConnectFrom = new String[list_relationship4.getLength()];

        String[] arrReal_idConnectTo = new String[list_relationship5.getLength()];
        String[] arrReal_idConnectFrom = new String[list_relationship5.getLength()];

        String[] arrComp_idConnectTo = new String[list_relationship6.getLength()];
        String[] arrComp_idConnectFrom = new String[list_relationship6.getLength()];
        Element assoc = null;
        Element gener = null;
        Element aggre = null;
        Element depend = null;
        Element real = null;
        Element comp = null;
        for (i = 0; i < totalLength; i++) {
            assoc = (Element) list_relationship.item(i);
            gener = (Element) list_relationship2.item(i);
            aggre = (Element) list_relationship3.item(i);
            depend = (Element) list_relationship4.item(i);
            real = (Element) list_relationship5.item(i);
            comp = (Element) list_relationship6.item(i);

            if (assoc != null) {
                arrAssoc_idConnectTo[i] = assoc.getAttribute("To");
                arrAssoc_idConnectFrom[i] = assoc.getAttribute("From");
            }

            if (gener != null) {
                arrGener_idConnectTo[i] = gener.getAttribute("To");
                arrGener_idConnectFrom[i] = gener.getAttribute("From");
            }

            if (aggre != null) {
                arrAgg_idConnectTo[i] = aggre.getAttribute("To");
                arrAgg_idConnectFrom[i] = aggre.getAttribute("From");
            }

            if (depend != null) {
                arrDep_idConnectTo[i] = depend.getAttribute("To");
                arrDep_idConnectFrom[i] = depend.getAttribute("From");
            }

            if (real != null) {
                arrReal_idConnectTo[i] = real.getAttribute("To");
                arrReal_idConnectFrom[i] = real.getAttribute("From");
            }

            if (comp != null) {
                arrComp_idConnectTo[i] = comp.getAttribute("To");
                arrComp_idConnectFrom[i] = comp.getAttribute("From");
            }
        }

        System.out.println("=====RELATIONSHIP ASSOCIATION====== " + list_relationship.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixRel = new String[list_relationship.getLength()][list_relationship.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship.getLength(); b++) {
                matrixRel[a][b] = arrAssoc_idConnectTo[b];
                System.out.print(matrixRel[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship.getLength(); b++) {
                matrixRel[a][b] = arrAssoc_idConnectFrom[b];
                System.out.print(matrixRel[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=====RELATIONSHIP GENERALIZATION====== " + list_relationship2.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixGen = new String[list_relationship2.getLength()][list_relationship2.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship2.getLength(); b++) {
                matrixGen[a][b] = arrGener_idConnectTo[b];
                System.out.print(matrixGen[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship2.getLength(); b++) {
                matrixGen[a][b] = arrGener_idConnectFrom[b];
                System.out.print(matrixGen[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=====RELATIONSHIP AGGREGATION====== " + list_relationship3.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixAggre = new String[list_relationship3.getLength()][list_relationship3.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship3.getLength(); b++) {
                matrixAggre[a][b] = arrAgg_idConnectTo[b];
                System.out.print(matrixAggre[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship3.getLength(); b++) {
                matrixAggre[a][b] = arrAgg_idConnectFrom[b];
                System.out.print(matrixAggre[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=====RELATIONSHIP DEPENDENCY====== " + list_relationship4.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixDep = new String[list_relationship4.getLength()][list_relationship4.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship4.getLength(); b++) {
                matrixDep[a][b] = arrDep_idConnectTo[b];
                System.out.print(matrixDep[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship4.getLength(); b++) {
                matrixDep[a][b] = arrDep_idConnectFrom[b];
                System.out.print(matrixDep[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=====RELATIONSHIP REALIZATION====== " + list_relationship5.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixReal = new String[list_relationship5.getLength()][list_relationship5.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship5.getLength(); b++) {
                matrixReal[a][b] = arrReal_idConnectTo[b];
                System.out.print(matrixReal[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship5.getLength(); b++) {
                matrixReal[a][b] = arrReal_idConnectFrom[b];
                System.out.print(matrixReal[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=====RELATIONSHIP COMPOSITION====== " + list_relationship6.getLength());

        //test matrix from and to relationship
        //inserting to id
        String[][] matrixComp = new String[list_relationship6.getLength()][list_relationship6.getLength()];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < list_relationship6.getLength(); b++) {
                matrixComp[a][b] = arrComp_idConnectTo[b];
                System.out.print(matrixComp[a][b] + " " + b);
            }
            System.out.println("");
        }
        //inserting array row 1, inserting from id
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < list_relationship6.getLength(); b++) {
                matrixComp[a][b] = arrComp_idConnectFrom[b];
                System.out.print(matrixComp[a][b] + " " + b);
            }
            System.out.println("");
        }

        System.out.println("=======INDEX CLASS=======");
        //test matrix index class id
        String[][] matrix2 = new String[ordo][ordo];
        for (int a = 0; a < 1; a++) {
            for (int b = 0; b < ordo; b++) {
                matrix2[a][b] = Integer.toString(b);
//                if (matrix2[a][b] == 1) {
//                    matrix2[a][b] = 99;
//                }
                System.out.print(matrix2[a][b] + " ");
            }
            System.out.println("");
        }
        //inserting array row 1
        for (int a = 1; a < 2; a++) {
            for (int b = 0; b < ordo; b++) {
                matrix2[a][b] = arr_className[b];
                System.out.print(matrix2[a][b] + " ");
            }
            System.out.println("");
        }
        for (int a = 2; a < 3; a++) {
            for (int b = 0; b < ordo; b++) {
                matrix2[a][b] = arr_className2[b];
                System.out.print(matrix2[a][b] + " ");
            }
            System.out.println("");
        }

        System.out.println("======MATRIX BASE=======");
        //making of logical matrix adjency 
        int j = 0;
        String[][] matrixBase = new String[ordo][ordo];
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                matrixBase[i][j] = arr_className[i];

                System.out.print(matrixBase[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("======MATRIX LONGEST DISTANCE=======");
        //making of logical matrix adjency 

        int[][] matrixLongestD = new int[ordo][ordo];
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                matrixLongestD[i][j] = 0;

                 System.out.print(matrixLongestD[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("======MATRIX BINARY=======");
        //making of logical matrix adjency 

        int[][] matrixBinary = new int[ordo][ordo];
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                matrixBinary[i][j] = 0;

                System.out.print(matrixBinary[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("======MATRIX ADJENCY=======");
        //making of logical matrix adjency 

        int[][] matrixAdjency = new int[ordo][ordo];
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                matrixAdjency[i][j] = 0;

                System.out.print(matrixAdjency[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("======MATRIX ADJENCY to ASSOC=======");
        //making of logical matrix adjency 
        int hBase = 0; //helper index for relation
        int hRel = 0; //helper index for matrix base
        int n = 0;
        String[][] matrixAdjency_assoc = new String[ordo][ordo];
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < list_relationship.getLength(); j++) {
                //matrixAdjency[i][j] = arr_className[i];
                if (matrixBase[i][0].equalsIgnoreCase(matrixRel[0][j])) {
                    System.out.println("FOUND !");
                    for (int m = 0; m < ordo; m++) {
                        if (matrixRel[1][j].equalsIgnoreCase(matrix2[1][m])) {
                            System.out.println("FOUND AGAIN !");
                            matrixAdjency[i][m] = 2;
                        }
                    }
                }
            }
            //System.out.println("");
        }

        System.out.println("======MATRIX ADJENCY to GENERALIZATION=======");
        //making of logical matrix adjency 
        if (list_relationship2.getLength() != 0) {
            String[][] matrixAdjency_gener = new String[ordo][ordo];
            for (i = 0; i < ordo; i++) {
                for (j = 0; j < list_relationship2.getLength(); j++) {
                    //matrixAdjency[i][j] = arr_className[i];
                    if (matrixBase[i][0].equalsIgnoreCase(matrixGen[0][j])) {
                        System.out.println("FOUND !");
                        for (int m = 0; m < ordo; m++) {
                            if (matrixGen[1][j].equalsIgnoreCase(matrix2[1][m])) {
                                System.out.println("FOUND AGAIN !");
                                matrixAdjency[i][m] = 5;
                            }
                        }
                    }
                }
                //System.out.println("");
            }
        }

        System.out.println("======MATRIX ADJENCY to AGGREGATION=======");
        //making of logical matrix adjency 
        if (list_relationship3.getLength() != 0) {
            String[][] matrixAdjency_aggre = new String[ordo][ordo];
            for (i = 0; i < ordo; i++) {
                for (j = 0; j < list_relationship3.getLength(); j++) {
                    //matrixAdjency[i][j] = arr_className[i];
                    if (matrixBase[i][0].equalsIgnoreCase(matrixAggre[0][j])) {
                        System.out.println("FOUND !");
                        for (int m = 0; m < ordo; m++) {
                            if (matrixAggre[1][j].equalsIgnoreCase(matrix2[1][m])) {
                                System.out.println("FOUND AGAIN !");
                                matrixAdjency[i][m] = 3;
                            }
                        }
                    }
                }
                //System.out.println("");
            }
        }

        System.out.println("======MATRIX ADJENCY to DEPENDENCY=======");
        //making of logical matrix adjency 
        if (list_relationship4.getLength() != 0) {
            String[][] matrixAdjency_depen = new String[ordo][ordo];
            for (i = 0; i < ordo; i++) {
                for (j = 0; j < list_relationship4.getLength(); j++) {
                    //matrixAdjency[i][j] = arr_className[i];
                    if (matrixBase[i][0].equalsIgnoreCase(matrixDep[0][j])) {
                        System.out.println("FOUND !");
                        for (int m = 0; m < ordo; m++) {
                            if (matrixDep[1][j].equalsIgnoreCase(matrix2[1][m])) {
                                System.out.println("FOUND AGAIN !");
                                matrixAdjency[i][m] = 1;
                            }
                        }
                    }
                }
                //System.out.println("");
            }
        }

        System.out.println("======MATRIX ADJENCY to REALIZATION=======");
        //making of logical matrix adjency 
        if (list_relationship5.getLength() != 0) {
            String[][] matrixAdjency_real = new String[ordo][ordo];
            for (i = 0; i < ordo; i++) {
                for (j = 0; j < list_relationship5.getLength(); j++) {
                    //matrixAdjency[i][j] = arr_className[i];
                    if (matrixBase[i][0].equalsIgnoreCase(matrixReal[0][j])) {
                        System.out.println("FOUND !");
                        for (int m = 0; m < ordo; m++) {
                            if (matrixReal[1][j].equalsIgnoreCase(matrix2[1][m])) {
                                System.out.println("FOUND AGAIN !");
                                matrixAdjency[i][m] = 6;
                            }
                        }
                    }
                }
                //System.out.println("");
            }
        }

        System.out.println("======MATRIX ADJENCY to COMPOSITION=======");
        //making of logical matrix adjency 
        if (list_relationship6.getLength() != 0) {
            String[][] matrixAdjency_comp = new String[ordo][ordo];
            for (i = 0; i < ordo; i++) {
                for (j = 0; j < list_relationship6.getLength(); j++) {
                    //matrixAdjency[i][j] = arr_className[i];
                    if (matrixBase[i][0].equalsIgnoreCase(matrixComp[0][j])) {
                        System.out.println("FOUND !");
                        for (int m = 0; m < ordo; m++) {
                            if (matrixComp[1][j].equalsIgnoreCase(matrix2[1][m])) {
                                System.out.println("FOUND AGAIN !");
                                matrixAdjency[i][m] = 4;
                            }
                        }
                    }
                }
                //System.out.println("");
            }
        }

        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                if (matrixAdjency[i][j] != 0) {
                    matrixBinary[i][j] = 1;
                }
            }
        }

        //PRINTING UPDATED ADJENCY METRIX
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                System.out.print(matrixAdjency[i][j] + " ");
            }
            System.out.println("");
        }

        //PRINTING UPDATED BINARY METRIX
        System.out.println("=========MULTIPLY WITH THIS=========");
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                System.out.print(matrixBinary[i][j] + " ");
            }
            System.out.println("");
        }

        int x = ordo, y = ordo, p = ordo, q = ordo, sum = 0, c, d, k;
        for (c = 0; c < x; c++) {
            for (d = 0; d < q; d++) {
                for (k = 0; k < p; k++) {
                    sum = sum + matrixAdjency[c][k] * matrixBinary[k][d];
                }

                matrixLongestD[c][d] = sum;
                sum = 0;
            }
        }

        //PRINTING LONGEST PATH
        System.out.println("=========MULTIPLICATION RESULT (LONGEST DISTANCE MATRICS) =========");
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                System.out.print(matrixLongestD[i][j] + " ");
            }
            System.out.println("");
        }

        //CALCULATE THE LAST RESULT (MAXROC, MAXRIC)
        System.out.println("======CALCULATING THE RESULTS=========");
        int maxRoc[] = new int[ordo];
        int maxRic[] = new int[ordo];

        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                maxRic[i] = matrixLongestD[j][i] + matrixLongestD[j][i];
            }
            System.out.print("RIC = " + maxRic[i]);
        }
        for (i = 0; i < ordo; i++) {
            for (j = 0; j < ordo; j++) {
                maxRoc[i] = matrixLongestD[i][j] + matrixLongestD[j][(i)];

            }
            System.out.println("ROC = " + maxRoc[i]);
        }
    }
}
