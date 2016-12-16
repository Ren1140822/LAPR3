/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Start Menu of the aplication
 * @author Pedro Fernandes
 */
public class MenuUI extends JFrame{
    
    private MenuUI framePai;
    
    public MenuUI(){
        super("Menu");
        
        framePai = MenuUI.this;
        
        createComponents();
        
        pack();
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void createComponents(){
        
        add(createPanelButons());
   
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
                AddAirportUI addairport = new AddAirportUI(framePai);
            }
        });
        
        JButton bt2 = new JButton("Export Project");
        bt2.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                ExportProjectUI proj = new ExportProjectUI();
            }
        });
        
        JButton bt3 = new JButton("blbbla");
        bt3.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                                null,
                                "In construction! \nSorry.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE); 
            }
        });
        
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
        
        
    }
    
    
    
}
