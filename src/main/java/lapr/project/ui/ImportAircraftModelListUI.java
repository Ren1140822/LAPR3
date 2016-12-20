/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import lapr.project.controller.ImportAircraftModelListController;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportAircraftModelListUI extends JFileChooser{
    /**
     * file chooser
     */
    private JFileChooser fileChooser;
    /**
     * controller
     */
    private ImportAircraftModelListController controller;
    
    public ImportAircraftModelListUI(){
        controller = new ImportAircraftModelListController();
        try{
                    fileChooser = new JFileChooser();
                    defineFilterExtXML(fileChooser);
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    int resposta = fileChooser.showOpenDialog(ImportAircraftModelListUI.this);

                    if (resposta == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();              
                        if(controller.importXMLAircraftModelList(file)){
                            JOptionPane.showMessageDialog(ImportAircraftModelListUI.this,
                            "Aircraft Model List imported successfully!",
                            "Import Aircraft Model List",
                            JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(ImportAircraftModelListUI.this, 
                            "Aircraft Model List was not imported successfully",
                            "Error",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(ImportAircraftModelListUI.this, 
                            ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }        
    }
    
    private void defineFilterExtXML(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String ex = ex(f);
                if (ex != null) {
                    return ex.equals("xml");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }

            private String ex(File f) {
                String ex = null;
                String str = f.getName();
                int i = str.lastIndexOf(".");
                if (i != -1) {
                    ex = str.substring(i + 1).toLowerCase();
                }
                return ex;
            }
        });
    }
}
