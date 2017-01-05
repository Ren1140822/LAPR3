/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.FindBestPathController;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.TypePath;

/**
 *
 * @author DianaSilva
 */
public class FindBestPathUI extends JDialog{
 
    /**
     * Guarda a janela anterior
     */
    private final JDialog frame;   
   
    /**
     * Saves the analysis input data
     */
    private JTextField txtPassenger, txtCrew, txtCargoLoad, txtFuelLoad;
    
    /**
     * panel with analysis input data 
     */
    private JPanel panel,panelData;
    
    /**
     * buttons
     */
    private JButton btClean, btBack;
    
    /**
     * list of aircrafts, list of airports, list of possible destinations
     */
    private JList listAircrafts, listStartAirports, listEndAirports;
    
    /**
     * controller
     */
    private transient FindBestPathController controller;
    
    private transient Project project;
    
    /**
     * aircrafts, start nodes, possible end nodes
     */
    private transient List<Aircraft> aircrafts;
    /**
     * aircrafts, start nodes, possible end nodes
     */
    private transient List<Airport> startAirports, endAirports;
    
    private int dialogResult=JOptionPane.CANCEL_OPTION;
    
    private JButton btEco, btFast,btShort, btAll;
   
    public FindBestPathUI(Project project, JDialog frame){
        super(frame, "Find BestPath", true);
        this.project = project;
        this.frame = frame;
        
        controller = new FindBestPathController(this.project);
        controller.newSImulation();
        aircrafts= controller.getAircraftsList();
        startAirports=controller.getAirportList();
        endAirports=new LinkedList();
         
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
    
    private JPanel createComponents(){
        panel = new JPanel(new BorderLayout());
        panel.add(createInputPanel(), BorderLayout.NORTH);
        
        btClean=UI.createButtonClean();
        btBack=UI.createButtonBack();
        buttonBackAddListener();
        buttonCleanAddListener();     
        panel.add(UI.createButtonsCleanBackPanel(btClean, btBack), BorderLayout.SOUTH);
        panel.add(createPanelFind(), BorderLayout.CENTER);
        return panel;
    }
       
    private JPanel createInputPanel(){
        
        panelData = new JPanel(new BorderLayout());
        
        panelData.setBorder(BorderFactory.createTitledBorder("Simulation Data:"));
        
        JPanel pSelect=new JPanel(new BorderLayout());    
        pSelect.add(createPanelImage(), BorderLayout.NORTH);
        pSelect.add(createPanelInputData(), BorderLayout.CENTER);

        panelData.add(createPanelAircraft(), BorderLayout.EAST);
        panelData.add(pSelect, BorderLayout.WEST);
        panelData.add(createPanelAirports(), BorderLayout.CENTER);
        
        return panelData;
    }
    
    private JPanel createPanelAircraft(){
        JPanel pleft = new JPanel(new BorderLayout());
    
        JLabel labelAircraft = UI.createJLabels("Select aircraft:");
        listAircrafts = UI.createJListAircraft(aircrafts);
        JTextArea txtDetails=new JTextArea();
        txtDetails.setPreferredSize(new Dimension(150,100));
        listAircrafts.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    for(Aircraft a: controller.getAircraftsList()){
                        
                        txtDetails.setText("teste");
                        if (a.equals(listAircrafts.getSelectedValue())){
                            txtDetails.setText(a.toStringInfo());
                        }
                    }
                }
                if(listStartAirports.getSelectedValue()!=null && 
                        listEndAirports.getSelectedValue()!=null && 
                        validateData()){
                    btEco.setEnabled(true);
                    btAll.setEnabled(true);
                }
            }
            
        });   
        pleft.add(labelAircraft, BorderLayout.NORTH);
        pleft.add(listAircrafts, BorderLayout.CENTER);
        pleft.add(txtDetails, BorderLayout.SOUTH);
        return pleft;
    }
    
    private JPanel createPanelInputData(){
        JPanel pcenter = new JPanel(new GridLayout(4,1));
        
        txtPassenger = new JTextField(10);
        txtCrew = new JTextField(10);
        txtCargoLoad = new JTextField(10);
        txtFuelLoad=new JTextField(10);
        
        pcenter.add(UI.createPanelLabelTextLabel("No.Passengers:", txtPassenger, ""));
        pcenter.add(UI.createPanelLabelTextLabel("No.Crew members: ", txtCrew, ""));
        pcenter.add(UI.createPanelLabelTextLabel("Cargo load: ", txtCargoLoad, "Kg"));  
        pcenter.add(UI.createPanelLabelTextLabel("Fuel load: ", txtFuelLoad, "Kg"));
        
        return pcenter;
    }
    
    private JPanel createPanelAirports(){
       JPanel panel=new JPanel(new BorderLayout());
        JPanel pright=new JPanel();
        JPanel pleft=new JPanel();
        JPanel po=new JPanel(new BorderLayout());
        JLabel labelOrigin = UI.createJLabels("Select origin:");
        listStartAirports = UI.createJListAirport(startAirports);
        
        listStartAirports.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                Airport selected=(Airport) listStartAirports.getSelectedValue();
                Node startNode=controller.convertAirportToNode(selected);
                
                endAirports=controller.getPossibleEndAirports(startNode);
                endAirports.remove(0);
                if(!endAirports.isEmpty())
                    listEndAirports.setListData(endAirports.toArray());
            }
        });   
   
        po.add(labelOrigin, BorderLayout.NORTH);
        po.add(listStartAirports, BorderLayout.CENTER);
       
        JLabel labelADest = UI.createJLabels("Select destination:");
        labelADest.setPreferredSize(new JLabel("Select destination: ").
                                                        getPreferredSize());
        JPanel pd=new JPanel(new BorderLayout());
        listEndAirports = UI.createJListAirport(endAirports);
        listEndAirports.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                btShort.setEnabled(true);
                btFast.setEnabled(true);
            }
                
             if(listAircrafts.getSelectedValue()!=null && validateData()){
                btEco.setEnabled(true);
                btAll.setEnabled(true);
             
            }
        }); 

        pd.add(labelADest, BorderLayout.NORTH);
        pd.add(listEndAirports, BorderLayout.CENTER);
        
        pleft.add(po);
        pright.add(pd);
        
//        pright.add(createPanelFind(), BorderLayout.SOUTH);
        panel.add(pleft, BorderLayout.WEST);
        panel.add(pright, BorderLayout.EAST);
        return panel;
    }
    
    private JPanel createPanelFind(){
        JPanel p=new JPanel();
        
        int aux= 2;
        JPanel imports = new JPanel(new GridLayout(1,4, aux,aux));          
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Simulate:"), new EmptyBorder(aux, aux, aux, aux)));        
        imports.add(createButtonShortest());
        imports.add(createButtonFastest());
        imports.add(createButtonEcologic());
        imports.add(createButtonAll());

        p.add(imports);     
                
        return p;
    }
    
    private JPanel createPanelImage(){
        ImageIcon background = new ImageIcon("src/main/resources/images/path.jpg");
        
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(5, 10, 5, 10));
        p.add(label, BorderLayout.CENTER);

        return p;
    }
            
    public void buttonCleanAddListener(){
        btClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPassenger.setText("");
                txtCrew.setText("");
                txtCargoLoad.setText("");
                txtFuelLoad.setText("");
            }
        });       
    }
    
    public void buttonBackAddListener(){
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }
    
    public void closeWindow(){
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Find Best Path?";
        int opcao = JOptionPane.showOptionDialog(frame, question,
                "Find Best Path", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void finish() {
        JOptionPane.showMessageDialog(
                                    null,
                                    "Simulation concluded successfully!",
                                    "Find Best Path",
                                    JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private JButton createButtonShortest() {
        Icon icone = new ImageIcon( "src/main/resources/images/shortest.png" );
        btShort = new JButton("Find Shortest Path", icone);
        btShort.setContentAreaFilled(false);
        btShort.setBorderPainted(false);
        btShort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btShort.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        btShort.setMnemonic(KeyEvent.VK_S);
        btShort.setEnabled(false);
        btShort.setToolTipText("Please insert origin and destination airports");
        btShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSimulation(TypePath.SHORTEST_PATH);
                openResultWindow(TypePath.SHORTEST_PATH);
            }
        });
    
        return btShort;
    }

    private JButton createButtonFastest() {
        Icon icone = new ImageIcon( "src/main/resources/images/fastest.png" );
        btFast = new JButton("Find Fastest Path", icone);
        btFast.setContentAreaFilled(false);
        btFast.setBorderPainted(false);
        btFast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        btFast.setMnemonic(KeyEvent.VK_F);
        btFast.setEnabled(false);
        btFast.setToolTipText("Please insert origin and destination airports");
        btFast.addActionListener((ActionEvent e) -> {
             createSimulation(TypePath.FASTEST_PATH);
                openResultWindow(TypePath.FASTEST_PATH);
        });
        return btFast;
    }

    private JButton createButtonEcologic() {
        Icon icone = new ImageIcon( "src/main/resources/images/ecologic.png" );
        btEco = new JButton("Find Ecologic Path", icone);
        btEco.setContentAreaFilled(false);
        btEco.setBorderPainted(false);
        btEco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        btEco.setMnemonic(KeyEvent.VK_E);
        btEco.setEnabled(false);
        btEco.setToolTipText("Please insert all data");
        btEco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Airport startAirportSelected=(Airport)listStartAirports.getSelectedValue();
                    Airport endAirportSelected=(Airport) listEndAirports.getSelectedValue();
                    controller.createBestPathSimulation(startAirportSelected, endAirportSelected, TypePath.ECOLOGIC_PATH);
                    setData();
                    controller.calculateEcologicPath();
                    openResultWindow(TypePath.ECOLOGIC_PATH);
                    
                }catch(java.lang.UnsupportedOperationException en){
                    
                    JOptionPane.showMessageDialog(frame,
                                "It wasn´t possible to create simulation", "Erro", JOptionPane.ERROR_MESSAGE);
                     throw new RuntimeException(en);
                }
            }
        });
        return btEco;
    }
    
    private JButton createButtonAll() {
        Icon icone = new ImageIcon( "src/main/resources/images/findPath.jpg" );
        btAll = new JButton("All Best Paths", icone);
        btAll.setContentAreaFilled(false);
        btAll.setBorderPainted(false);
        btAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        btAll.setMnemonic(KeyEvent.VK_E);
        btAll.setEnabled(false);
        btAll.setToolTipText("Please insert all data");
        btAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Airport startAirportSelected=(Airport)listStartAirports.getSelectedValue();
                    Airport endAirportSelected=(Airport) listEndAirports.getSelectedValue();
                    controller.createBestPathSimulation(startAirportSelected, endAirportSelected,TypePath.ALL);
                    setData();
                    controller.calculateShortesPath();
                    controller.calculateFastestPath();
                    controller.calculateEcologicPath();

                    
                }catch(java.lang.UnsupportedOperationException en){
                        JOptionPane.showMessageDialog(frame,
                                "It wasn´t possible to create simulation", "Erro", JOptionPane.ERROR_MESSAGE);
                         throw new RuntimeException(en);
                }
                
            }
        });
        return btAll;
    }
   
    private void openResultWindow(TypePath type) {
        ResultUI result=new ResultUI(controller,controller.getResult(type), type, null);
    }
    
    private boolean validateData(){
        return !txtCargoLoad.getText().equals("") &&
                !txtPassenger.getText().equals("") &&
                !txtCrew.getText().equals("") &&
                !txtFuelLoad.getText().equals("");
    }
    
    private void setData(){
        Aircraft aircraft=(Aircraft) listAircrafts.getSelectedValue();
        int passenger=Integer.parseInt(txtPassenger.getText());
        int crew= Integer.parseInt(txtCrew.getText());
        double cargo= Double.parseDouble(txtCargoLoad.getText());
        double fuel=Double.parseDouble(txtFuelLoad.getText());
        
        controller.setData(aircraft,passenger, crew,cargo,fuel);    
    }
 
    private void createSimulation(TypePath type){
        
        Airport startAirportSelected=(Airport)listStartAirports.getSelectedValue();
        Airport endAirportSelected=(Airport) listEndAirports.getSelectedValue();
        controller.createBestPathSimulation(startAirportSelected, endAirportSelected, type);
        if(listAircrafts.getSelectedValue()==null || !validateData()){
            int dialogButton=JOptionPane.YES_NO_OPTION;
            dialogResult = JOptionPane.showConfirmDialog (frame,"You didn´t insert all data. Would you like to proceed?","Warning",dialogButton);
        }else{
            setData();
        }
        try{   
            controller.calculateShortesPath();
        }catch(java.lang.UnsupportedOperationException en){
            JOptionPane.showMessageDialog(frame,
                    "It wasn´t possible to create simulation", "Erro", JOptionPane.ERROR_MESSAGE);
             throw new RuntimeException(en);
        }
    }
}