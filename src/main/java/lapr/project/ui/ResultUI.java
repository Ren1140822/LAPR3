/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lapr.project.controller.FindBestPathController;
import lapr.project.model.anaylsis.ResultPath;

/**
 *
 * @author Diana Silva
 */
public class ResultUI extends JDialog{

     /**
     * Guarda a janela anterior
     */
    private JDialog frame;  
    
    /**
     * Simulation created
     */
    private transient ResultPath resultPath;
    
    private transient FindBestPathController controller;
    
    private transient String type="DEFAULT";
    
    private JList jListSegments;
    
     public ResultUI(FindBestPathController controller, ResultPath result, String type, JDialog frame){
        super(frame, "Simulation: ",true);
        this.controller= controller;
        this.resultPath=result;
        this.type=type;
        this.frame = frame;
        
         add(createComponents()); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        pack();
        setMinimumSize(new Dimension(400, 250));
        setLocationRelativeTo(null);        
        setVisible(true);
     }

    private JPanel createComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createResultsPanel(), BorderLayout.CENTER);
        panel.add(createButtonsPanel(), BorderLayout.SOUTH);
        
        return panel;
    }
    
    
    
    public void closeWindow(){
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Simulation Result?";
        int opcao = JOptionPane.showOptionDialog(frame, question,
                "Simulation Result", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private JPanel createResultsPanel() {
        JPanel p=new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(type));
        jListSegments=UI.createJListNodes(resultPath.getResultPath());
        jListSegments.setVisibleRowCount(1);
        jListSegments.setPreferredSize(new Dimension(150,15));
        jListSegments.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        JPanel pRes=new JPanel(new GridLayout(2,1));
        JLabel lblTravellingLabel=UI.createJLabels("Travelling time: " + resultPath.getTravellingTime() + " hour");
        JLabel lblEnergyLabel=UI.createJLabels("Energy consumption: " + resultPath.getEnergyConsum()+ "??");
        pRes.add(lblTravellingLabel);
        pRes.add(lblEnergyLabel);
        
        p.add(jListSegments, BorderLayout.CENTER);
        p.add(pRes, BorderLayout.SOUTH);
       
        
        return p;
    }

    private Component createButtonsPanel() {
        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);
        
        p.setBorder(BorderFactory.createTitledBorder("Options:"));
        
        JButton bt1 = createButtonSave();
        JButton bt2 = createButonBack();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        
        return p;
    }
    
    public JButton createButtonSave(){
        JButton saveBtn = new JButton("Save Simulation");
        saveBtn.setMnemonic(KeyEvent.VK_B);
        saveBtn.setToolTipText("Save the simulation and go to previous window");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
//                    String IATA = txtIATA.getText();
//                    String name = txtName.getText();
//                    String town = txtTown.getText();
//                    String country = txtCountry.getText();
//                    double latitude = Double.parseDouble(txtLatitude.getText());
//                    double longitude = Double.parseDouble(txtLongitude.getText());
//                    int altitude = Integer.parseInt(txtAltitude.getText());

//                    controller.setAirportData(IATA, name, town, country,latitude,longitude,altitude);
//
//                    if(controller.saveAirport()){
//                        finish();
//                    }else{
                        JOptionPane.showMessageDialog(
                                    null,
                                    "It was not possible to add the simulation!\n",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE); 
//                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(
                                    null,
                                    "Check all simulation data, please!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE); 
                }       
            }
        });
        return saveBtn;
        
    }
    
    public JButton createButonBack(){
        JButton backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Cancel save simulation and go to previous window");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        return backBtn;
    }
    
}
