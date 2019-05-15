/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.xmlReader.dir;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author HP PC
 */
//
public class fileBrowser {

    xmlReader reader = new xmlReader();
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public fileBrowser() {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        //jfc.setFileFilter(new FileNameExtensionFilter("Document File", "xml"));

        File file = jfc.getSelectedFile();
        dir = file.getAbsolutePath();
        reader.setDir(dir);
        this.fileName = file.getName();
        reader.setDir(dir);
    }

}
