/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftUI extends JFrame {
     private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_TITLE = "Add aircraft";

    public AddAircraftUI()
    {
         this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        createComponents();
        this.setVisible(true);
        
    }
    
    public void createComponents()
    {
        
    }
    
}
