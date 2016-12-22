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
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class EditProjectUI extends JDialog{
    
    private Project project;
    /**
     * Guarda a janela anterior
     */
    private JDialog frame;
    
    public EditProjectUI(Project project, JDialog frame){
        super(frame, "Edit Project: " + project.getName(), true);
        
        this.project = project;
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
                AddAirportUI addairport = new AddAirportUI(project,EditProjectUI.this);
            }
        });
        
        JButton bt2 = new JButton("Add aircraft");
        bt2.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                  AddAircraftUI aircraft = new AddAircraftUI(project,EditProjectUI.this);
            }
        });
        
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        
        return p;
        
        
    }
    
}
