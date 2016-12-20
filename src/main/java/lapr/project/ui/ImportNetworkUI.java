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
import lapr.project.controller.ImportNetworkController;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportNetworkUI extends JFileChooser{
    /**
     * file chooser
     */
    private JFileChooser fileChooser;
    /**
     * controller
     */
    private ImportNetworkController controller;
    
    public ImportNetworkUI(){
        controller = new ImportNetworkController();        
        try{
                    fileChooser = new JFileChooser();
                    defineFilterExtXML(fileChooser);
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    int resposta = fileChooser.showOpenDialog(ImportNetworkUI.this);

                    if (resposta == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();              
                        if(controller.importXMLNetwork(file)){
                            JOptionPane.showMessageDialog(ImportNetworkUI.this,
                            "Network List imported successfully!",
                            "Import Network",
                            JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(ImportNetworkUI.this, 
                            "Network List was not imported successfully",
                            "Error",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(ImportNetworkUI.this, 
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
                String e = e(f);
                if (e != null) {
                    return e.equals("xml");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }

            private String e(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }
    
}
