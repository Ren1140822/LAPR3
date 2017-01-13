/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Node;

/**
 *
 * @author DianaSilva
 */
public class UI {
    
     public static JList createJListAirport(List<Airport> list) {
        JList jList = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jList.setBorder(border);
        jList.setPreferredSize(new Dimension(50, 150));
        jList.setListData(list.toArray());
        return jList;
    }
     
      public static JList createJListNodes(List<Node> list) {
        JList jList = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jList.setBorder(border);
        jList.setPreferredSize(new Dimension(50, 150));
        jList.setListData(list.toArray());
        return jList;
    }
     
      public static JLabel createJLabels(String text) {
        JLabel label = new JLabel(text);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setPreferredSize(new Dimension(100,15));
        return label;
    }
     
     public static JPanel createButtonsCleanBackPanel(JButton bt1, JButton bt2){
        
        FlowLayout l = new FlowLayout();

        l.setHgap(5);
        l.setVgap(5);

        JPanel p = new JPanel(l);
        
        p.setBorder(BorderFactory.createTitledBorder("Options:"));

        p.add(bt1);
        p.add(bt2);
        
        return p;
    }
     
     public static JButton createButtonClean(){
        JButton backBtn = new JButton("Clean");
        backBtn.setMnemonic(KeyEvent.VK_C);
        backBtn.setToolTipText("Clean all data inserted");
        return backBtn;
    }
     
     public static JButton createButtonBack(){
        JButton backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Cancel operation and go to previous window");
        return backBtn;
    }
     
      /**
     * create panel to label1, text and label2
     * @param label1 label1
     * @param text
     * @param label2 label2
     * @return panel
     */
    public static JPanel createPanelLabelTextLabel(String label1, JTextField text, String label2) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(new JLabel("Number of passengers: ").
                                                        getPreferredSize());
        
        JLabel lb2 = new JLabel(label2, JLabel.LEFT);
        lb2.setPreferredSize(new Dimension(100,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(lb1);
        p.add(text);
        p.add(lb2);

        return p;
    }
    
    public static JPanel createPanelLabelComboLabel(String label1, JComboBox combo, String label2) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(new JLabel("Number of passengers: ").
                                                        getPreferredSize());
        
        JLabel lb2 = new JLabel(label2, JLabel.LEFT);
        lb2.setPreferredSize(new Dimension(100,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(lb1);
        p.add(combo);
        p.add(lb2);

        return p;
    }
     
    public static JList createJListAircraft(List<Aircraft> list) {
        JList jList = new JList();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jList.setBorder(border);
        jList.setPreferredSize(new Dimension(300, 70));
        jList.setListData(list.toArray());
   
        return jList;
    }   
}
