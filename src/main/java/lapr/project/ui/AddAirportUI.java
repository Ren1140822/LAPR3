/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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
     * panel
     */
    private JPanel panel;
    /**
     * save button
     */
    private JButton saveBtn;
    /**
     * clean button
     */
    private JButton cleanBtn;
    /**
     * back button
     */
    private JButton backBtn;
    /**
     * controller
     */
    private transient AddAirportController controller;
    
    public AddAirportUI(MenuUI framePai){
        super(framePai, "Add Airport", true);
        
        this.framePai = framePai;
        
        controller = new AddAirportController();
        
        add(createComponents()); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(framePai);
        pack();
        setVisible(true);
    }
    
    public JPanel createComponents(){
        panel = new JPanel(new BorderLayout());
                
        panel.add(createPanelNorth(), BorderLayout.NORTH);
        panel.add(createPanelData(), BorderLayout.CENTER);
        panel.add(createPanelButons(), BorderLayout.SOUTH);
        
        return panel;
    }
    
    public JPanel createPanelNorth(){
        ImageIcon background = new ImageIcon("src/main/resources/images/airport.jpg");
        
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(5, 10, 5, 10));
        p.add(label, BorderLayout.CENTER);

        return p;
    }
    
    public JPanel createPanelData(){
        
        JPanel p = new JPanel();
        
        p.setBorder(BorderFactory.createTitledBorder("New Airport:"));
        
        JPanel pright = new JPanel(new GridLayout(4,1));
        
        txtLatitude = new JTextField(10);
        txtLongitude = new JTextField(10);
        txtAltitude = new JTextField(10);
        
        pright.add(createPanelLabelTextLabel("Latitude:", txtLatitude, ""));
        pright.add(createPanelLabelTextLabel("Longitude: ", txtLongitude, ""));
        pright.add(createPanelLabelTextLabel("Altitude: ", txtAltitude, "meters"));       
        
        JPanel pleft = new JPanel(new GridLayout(4,1));
        
        txtIATA = new JTextField(30);
        txtIATA.requestFocusInWindow();
        txtName = new JTextField(30);
        txtTown = new JTextField(30);
        txtCountry = new JTextField(30);

        pleft.add(createPanelLabelTextLabel("IATA: ", txtIATA, ""));
        pleft.add(createPanelLabelTextLabel("Name: ", txtName, ""));
        pleft.add(createPanelLabelTextLabel("Town: ", txtTown, ""));
        pleft.add(createPanelLabelTextLabel("Country: ", txtCountry, ""));
        
        p.add(pleft);
        p.add(pright);
        
        return p;
    }
    
    /**
     * create panel to label1, text and label2
     * @param label1 label1
     * @param texto text
     * @param label2 label2
     * @return painel
     */
    private JPanel createPanelLabelTextLabel(String label1, JTextField text, String label2) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_SIZE);
        
        JLabel lb2 = new JLabel(label2, JLabel.LEFT);
        lb2.setPreferredSize(new Dimension(80,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(lb1);
        p.add(text);
        p.add(lb2);

        return p;
    }

    public JPanel createPanelButons(){
        
        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);
        
        p.setBorder(BorderFactory.createTitledBorder("Options:"));
        
        JButton bt1 = createButonSave();
        JButton bt2 = createButonClean();
        JButton bt3 = createButonBack();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
        
        
    }
    
    public JButton createButonSave(){
        saveBtn = new JButton("Save Airport");
        saveBtn.setMnemonic(KeyEvent.VK_B);
        saveBtn.setToolTipText("Save the airport and go to previous window");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String IATA = txtIATA.getText();
                    String name = txtName.getText();
                    String town = txtTown.getText();
                    String country = txtCountry.getText();
                    double latitude = Double.parseDouble(txtLatitude.getText());
                    double longitude = Double.parseDouble(txtLongitude.getText());
                    int altitude = Integer.parseInt(txtAltitude.getText());

                    controller.setAirportData(IATA, name, town, country,latitude,longitude,altitude);

                    if(controller.saveAirport()){
                        finish();
                    }else{
                        JOptionPane.showMessageDialog(
                                    null,
                                    "It was not possible to add the airport!\n",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE); 
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(
                                    null,
                                    "Check all airport data, please!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE); 
                }       
            }
        });
        return saveBtn;
        
    }
    
    public JButton createButonClean(){
        cleanBtn = new JButton("Clean");
        cleanBtn.setMnemonic(KeyEvent.VK_C);
        cleanBtn.setToolTipText("Clean all data inserted");
        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAltitude.setText("");
                txtCountry.setText("");
                txtIATA.setText("");
                txtLatitude.setText("");
                txtLongitude.setText("");
                txtName.setText("");
                txtTown.setText("");
            }
        });
        return cleanBtn;        
    }
    
    public JButton createButonBack(){
        backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Cancel add airport and go to previous window");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        return backBtn;
    }
    
    public void closeWindow(){
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Add Airport?";
        int opcao = JOptionPane.showOptionDialog(framePai, question,
                "Add Airport", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void finish() {
        //implementar para gravacao na bd
        JOptionPane.showMessageDialog(
                                    null,
                                    "Airport added successfully!",
                                    "Add Airport",
                                    JOptionPane.DEFAULT_OPTION);
        dispose();
    }
}
