/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.FindBestPathController;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.Project;

/**
 *
 * @author DianaSilva
 */
public class FindBestPathUI extends JDialog{
    Project project;
    /**
     * Guarda a janela anterior
     */
    private JDialog frame;   
    /**
     * dimension of default label
     */
    private static final Dimension LABEL_SIZE = new JLabel("Number of passengers: ").
                                                        getPreferredSize(); 
    /**
     * Saves the analysis input data
     */
    private JTextField txtPassenger, txtCrew, txtCargoLoad, txtFuelLoad;
    
    /**
     * panel with analysis input data 
     */
    private JPanel panel,panelData, panelAircraft, panelAirports;
    
    /**
     * buttons
     */
    private JButton saveBtn, cleanBtn, backBtn;
    /**
     * controller
     */
    private transient FindBestPathController controller;
    
    /**
     * list of aircrafts, list of airports, list of possible destinations
     */
    private JList listAircrafts, listStartNodes, listEndNodes;
    
    /**
     * aircrafts, start nodes, possible end nodes
     */
    private transient List<Aircraft> aircrafts, endNodes;
    /**
     * aircrafts, start nodes, possible end nodes
     */
    private transient List<Airport> startNodes;
    
    public FindBestPathUI(Project project, JDialog frame){
        super(frame, "Find BestPath", true);
        this.project = project;
        this.frame = frame;
        
        /**---------------------------test---------------------------*/
        Aircraft a=new Aircraft();
        Aircraft b=new Aircraft();
        b.setRegistration("cucu");
        project.getAircraftList().getAircraftList().add(a);
        project.getAircraftList().getAircraftList().add(b);
        //--------------------------------------------------------//
        Airport e= new Airport();
        Airport f=new Airport();
        project.getAirportList().getAirportList().add(e);
        project.getAirportList().getAirportList().add(f);
             /**---------------------------test---------------------------*/
        Node c=new Node();
        Node d=new Node();
        project.getAirNetwork().getNodeList().add(c);
        project.getAirNetwork().getNodeList().add(d);
        //--------------------------------------------------------/        
        
        controller = new FindBestPathController(project);
        aircrafts= controller.getAircraftsList();
        startNodes=controller.getAirportsList();
        endNodes=new LinkedList();
        
        add(createComponents()); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        pack();
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);        
        setVisible(true);
    }
    
    public JPanel createComponents(){
        panel = new JPanel(new BorderLayout());
        panel.add(createInputPanel(), BorderLayout.CENTER);
        panel.add(createButtonsPanel(), BorderLayout.SOUTH);
        
        return panel;
    }
       
    public JPanel createInputPanel(){
        
        panelData = new JPanel(new BorderLayout());
        
        panelData.setBorder(BorderFactory.createTitledBorder("Input data:"));
        
        JPanel pleft = new JPanel(new BorderLayout());
        
        JLabel labelAircrafts = createJLabels("Select aircraft:");
        listAircrafts = createJListAircraft(aircrafts);
        JTextArea txtDetails=new JTextArea();
        listAircrafts.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    for(Aircraft a: project.getAircraftList().getAircraftList()){
                        
                        txtDetails.setText("teste");
                        if (a.equals(listAircrafts.getSelectedValue())){
                            txtDetails.setText(a.toStringInfo());
                        }
                    }
                }
            }
        });   
         
        pleft.add(labelAircrafts, BorderLayout.NORTH);
        pleft.add(listAircrafts, BorderLayout.CENTER);
        pleft.add(txtDetails, BorderLayout.SOUTH);
        
        JPanel pSelect=new JPanel(new BorderLayout());
        JPanel pcenter = new JPanel(new GridLayout(4,1));
        
        txtPassenger = new JTextField(10);
        txtCrew = new JTextField(10);
        txtCargoLoad = new JTextField(10);
        txtFuelLoad=new JTextField(10);
        
        pcenter.add(createPanelLabelTextLabel("No.Passengers:", txtPassenger, ""));
        pcenter.add(createPanelLabelTextLabel("No.Crew members: ", txtCrew, ""));
        pcenter.add(createPanelLabelTextLabel("Cargo load: ", txtCargoLoad, "grams"));  
        pcenter.add(createPanelLabelTextLabel("Fuel load: ", txtFuelLoad, "L")); 
        
        pSelect.add(pcenter, BorderLayout.NORTH);
        
        JPanel pright=new JPanel();
        JLabel labelOrigin = createJLabels("Select origin:");
        listStartNodes = createJListAirport(startNodes);
        pright.add(labelOrigin);
        pright.add(listStartNodes);
        
        JLabel labelADest = createJLabels("Select destination:");
        listEndNodes = createJListAircraft(endNodes);
        pright.add(labelADest);
        pright.add(listEndNodes);
        
         pSelect.add(pright, BorderLayout.CENTER);
                
        panelData.add(pleft, BorderLayout.WEST);
        panelData.add(pSelect, BorderLayout.CENTER);
        
        return panelData;
    }
    
    
    private JList createJListAircraft(List<Aircraft> list) {
        JList jList = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jList.setBorder(border);
        jList.setPreferredSize(new Dimension(150, 70));
        jList.setListData(list.toArray());
        return jList;
    }
    
     
    private JList createJListAirport(List<Airport> list) {
        JList jList = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jList.setBorder(border);
        jList.setPreferredSize(new Dimension(150, 70));
        jList.setListData(list.toArray());
        return jList;
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
    
    private JLabel createJLabels(String text) {
        JLabel label = new JLabel(text);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        return label;
    }

    public JPanel createButtonsPanel(){
        
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
        saveBtn = new JButton("Save Simulation");
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
    
    public JButton createButonClean(){
        cleanBtn = new JButton("Clean");
        cleanBtn.setMnemonic(KeyEvent.VK_C);
        cleanBtn.setToolTipText("Clean all data inserted");
        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPassenger.setText("");
                txtCrew.setText("");
                txtCargoLoad.setText("");
                txtFuelLoad.setText("");
            }
        });
        return cleanBtn;        
    }
    
    public JButton createButonBack(){
        backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Cancel find best path and go to previous window");
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
        String question = "Close window and discard Find Best Path?";
        int opcao = JOptionPane.showOptionDialog(frame, question,
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
                                    "Simulation added successfully!",
                                    "Find Best Path",
                                    JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
