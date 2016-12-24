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
import lapr.project.model.Location;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Wind;
import lapr.project.model.lists.AirportList;

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
    private JPanel panel,panelData, panelAircraft, panelAirports;
    
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
    
   private enum Type {
        SHORTEST_PATH, FASTEST_PATH,ECOLOGIC_PATH
    };
  
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
        Node startNode=new Node("test1", 40, 40);
        Node intNode=new Node("test2", 50, 70);
        Node endNode=new Node("test3", 40, 80);
        
        Wind windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1","test1", "test3", direction,windTest);       
        Segment segment2=new Segment("segmentTest2", "test1", "test2", direction,windTest);
        Segment segment3=new Segment("segmentTest3", "test2", "test3", direction, windTest);
        
        project.getAirNetwork().getAirNetwork().insertVertex(startNode);
        project.getAirNetwork().getAirNetwork().insertVertex(intNode);
        project.getAirNetwork().getAirNetwork().insertVertex(endNode);
        
        project.getAirNetwork().getNodeList().add(startNode);
        project.getAirNetwork().getNodeList().add(intNode);
        project.getAirNetwork().getNodeList().add(endNode);

        project.getAirNetwork().getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        project.getAirNetwork().getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        project.getAirNetwork().getAirNetwork().insertEdge(startNode, endNode, segment1, 20); 
        
        Airport airport1=new Airport("OPO", "", "", "", new Location(40,40,10));
        Airport airport2=new Airport("LIS", "", "", "", new Location(50,70,10));
        Airport airport3=new Airport("LON", "", "", "", new Location(40,80,10));
        
        AirportList airportsList=project.getAirportList();
        airportsList.getAirportList().add(airport1);
        airportsList.getAirportList().add(airport2);
        airportsList.getAirportList().add(airport3);
        //-----------------------------------------------------------------------///
        
        controller = new FindBestPathController(project);
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
        panel.add(createInputPanel(), BorderLayout.CENTER);
        
        btClean=UI.createButtonClean();
        btBack=UI.createButtonBack();
        buttonBackAddListener();
        buttonCleanAddListener();     
        panel.add(UI.createButtonsCleanBackPanel(btClean, btBack), BorderLayout.SOUTH);
        
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
        pcenter.add(UI.createPanelLabelTextLabel("Cargo load: ", txtCargoLoad, "grams"));  
        pcenter.add(UI.createPanelLabelTextLabel("Fuel load: ", txtFuelLoad, "L"));
        
        return pcenter;
    }
    
    private JPanel createPanelAirports(){
        JPanel pright=new JPanel(new BorderLayout());
        JPanel pBlock=new JPanel();
        JPanel po=new JPanel(new GridLayout(2,1));
        JLabel labelOrigin = UI.createJLabels("Select origin:");
        listStartAirports = UI.createJListAirport(startAirports);
        
        listStartAirports.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    Airport selected=(Airport) listStartAirports.getSelectedValue();
                    Node startNode=controller.convertAirportToNode(selected);
                    
                    endAirports=controller.getPossibleEndAirports(startNode);
                    listEndAirports.setListData(endAirports.toArray());
                }
            }
        });   
   
        po.add(labelOrigin);
        po.add(listStartAirports);
        
       
        JLabel labelADest = UI.createJLabels("Select destination:");
        JPanel pd=new JPanel(new GridLayout(2,1));
        listEndAirports = UI.createJListAirport(endAirports);
        pd.add(labelADest);
        pd.add(listEndAirports);
        
        pBlock.add(po);
        pBlock.add(pd);
        pright.add(pBlock, BorderLayout.CENTER);
        pright.add(createPanelFind(), BorderLayout.SOUTH);
        
        return pright;
    }
    
    private JPanel createPanelFind(){
        JPanel p=new JPanel();
        
        int aux= 2;
        JPanel imports = new JPanel(new GridLayout(1,3, aux,aux));          
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Simulate:"), new EmptyBorder(aux, aux, aux, aux)));        
        imports.add(createButtonShortest());
        imports.add(createButtonFastest());
        imports.add(createButtonEcologic());

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
                                    "Simulation added successfully!",
                                    "Find Best Path",
                                    JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private JButton createButtonShortest() {
        Icon icone = new ImageIcon( "src/main/resources/images/shortest.png" );
        JButton button = new JButton("Find Shortest Path", icone);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        button.setMnemonic(KeyEvent.VK_S);
        button.setToolTipText("Find Shortest Path");
        button.addActionListener((ActionEvent e) -> {
            Airport startAirportSelected=(Airport)listStartAirports.getSelectedValue();
            Airport endAirportSelected=(Airport) listEndAirports.getSelectedValue();
            
            controller.createBestPathSimulation(startAirportSelected, endAirportSelected);
            
            controller.calculateShortesPath();
            openResultWindow(Type.SHORTEST_PATH);
        });
        return button;
    }

    private JButton createButtonFastest() {
        Icon icone = new ImageIcon( "src/main/resources/images/fastest.png" );
        JButton button = new JButton("Find Fastest Path", icone);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        button.setMnemonic(KeyEvent.VK_F);
        button.setToolTipText("Find Fastest Path");
        button.addActionListener((ActionEvent e) -> {
            controller.calculateFastestPath();
            openResultWindow(Type.FASTEST_PATH);
        });
        return button;
    }

    private JButton createButtonEcologic() {
        Icon icone = new ImageIcon( "src/main/resources/images/ecologic.png" );
        JButton button = new JButton("Find Ecologic Path", icone);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        button.setMnemonic(KeyEvent.VK_E);
        button.setToolTipText("Find Ecologic Path");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.calculateEcologicPath();
                 openResultWindow(Type.ECOLOGIC_PATH);
            }
        });
        return button;
    }
    
    private void openResultWindow(Type type) {
        ResultUI result=new ResultUI(controller,controller.getResult(type.name()), type.toString(), frame);
    }
}
