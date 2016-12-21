/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Pedro Fernandes
 */
public class EditProjectUI extends JDialog{
    
    /**
     * Guarda a janela anterior
     */
    private final MenuProjectUI frame;
    
    public EditProjectUI(MenuProjectUI frame){
        super(frame, "Edit Project", true);
        
        this.frame = frame;
        
        add(createPanelButons()); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        pack();
        setResizable(false);
        setMinimumSize(new Dimension(1100, 500));
        setLocationRelativeTo(frame);        
        setVisible(true);
        
    }
    
    public JPanel createPanelButons(){
        
        FlowLayout l = new FlowLayout();

        l.setHgap(40);
        l.setVgap(40);

        JPanel p = new JPanel();

        JButton bt1 = new JButton("Add Airport");
        bt1.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                AddAirportUI addairport = new AddAirportUI(frame);
            }
        });
        
        JButton bt2 = new JButton("Export Project");
        bt2.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
//    converter para jdialog     AddAircraftUI aircraft = new AddAircraftUI(frame);
            }
        });
        
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        
        return p;
        
        
    }
    
}
