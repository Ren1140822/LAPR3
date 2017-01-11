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
import lapr.project.controller.ImportAirportController;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportAirportUI extends JFileChooser{
    Project project;
    /**
     * file chooser
     */
    private JFileChooser fileChooser;
    /**
     * controller
     */
    private transient ImportAirportController controller;
    
    public ImportAirportUI(Project project) throws FileNotFoundException{
        this.project = project;
        controller = new ImportAirportController(project);        
        try{
                    fileChooser = new JFileChooser();
                    defineFilterExtXML(fileChooser);
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    fileChooser.setCurrentDirectory(new File("src/main/resources"));
                    int resposta = fileChooser.showOpenDialog(ImportAirportUI.this);

                    if (resposta == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();              
                        if(controller.importXMLAirportList(file)){
                            JOptionPane.showMessageDialog(ImportAirportUI.this,
                            "Airport List imported successfully!",
                            "Import Airport",
                            JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(ImportAirportUI.this, 
                            "Airport List was not imported successfully",
                            "Error",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(ImportAirportUI.this, 
                            ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    System.err.println(ex);
                }        
    }
    
    private void defineFilterExtXML(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String ext = ext(f);
                if (ext != null) {
                    return ext.equals("xml");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }

            private String ext(File f) {
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
