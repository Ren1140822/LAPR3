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
import lapr.project.controller.ImportAirportController;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportAirportUI extends JFileChooser{
    /**
     * file chooser
     */
    private JFileChooser fileChooser;
    /**
     * controller
     */
    private ImportAirportController controller;
    
    public ImportAirportUI(){
        controller = new ImportAirportController();
        try{
                    fileChooser = new JFileChooser();
                    fileChooser.setAcceptAllFileFilterUsed(false);
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
                }        
    }    
}
