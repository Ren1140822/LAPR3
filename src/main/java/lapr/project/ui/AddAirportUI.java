/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lapr.project.controller.AddAirportController;

/**
 * UI add airport
 * @author Pedro Fernandes
 */
public class AddAirportUI extends JDialog {
    /**
     * Guarda a janela anterior
     */
    private MenuUI framePai;   
    /**
     * dimension of default label
     */
    private static final Dimension LABEL_SIZE = new JLabel("Longitude: ").
                                                        getPreferredSize();
    /**
     * dimensions
     */
    private static final int UP = 5;
    private static final int DOWN = 5;
    private static final int LEFT = 5;
    private static final int RIGHT = 5;    
    /**
     * Saves the IATA
     */
    private JTextField txtIATA;
    /**
     * Saves the name
     */
    private JTextField txtName;
    /**
     * Saves the town
     */
    private JTextField txtTown;
    /**
     * Saves the country
     */
    private JTextField txtCountry;
    /**
     * Saves the latitude
     */
    private JTextField txtLatitude;
    /**
     * Saves the longitude
     */
    private JTextField txtLongitude;
    /**
     * Saves the altitude
     */
    private JTextField txtAltitude;
    /**
     * controller
     */
    private transient AddAirportController controller;
    
    public AddAirportUI(MenuUI framePai){
        super(framePai, "Adicionar Aeroporto", true);
        
        
    }
    
}
