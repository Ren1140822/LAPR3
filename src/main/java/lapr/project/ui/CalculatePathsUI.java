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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.controller.CalculatePathsController;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.Project;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Pedro Fernandes
 */
public class CalculatePathsUI extends JDialog {

    private Project project;
    private transient CalculatePathsController controller;
    private JList listAirOri;
    private JList listAirDest;
    private JList listAircraftModels;
    private JButton btnClean, btnBack, btnEco, btnFast, btnShort;
    private JTextField txt;
    /**
     * Guarda a janela anterior
     */
    private final JDialog dialog;

    public CalculatePathsUI(Project project, JDialog dialog) {

        super(dialog, "Calculate Paths", true);
        this.project = project;
        this.dialog = dialog;
        controller = new CalculatePathsController(project);

        if (controller.getAircraftsModelList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Aircraft Model List is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else if (controller.getAirportList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Airport List is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else {

            components();

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    close();
                }
            });
            pack();
            setResizable(false);
            setSize(new Dimension(800, 600));
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }
    
    private void components() {
        add(createPanelLists(), BorderLayout.CENTER);
        
        btnClean = UI.createButtonClean();
        btnBack = UI.createButtonBack();
        buttonBackAddListener();
        buttonCleanAddListener();
        
        JPanel p = new JPanel(new BorderLayout());
        p.add(UI.createButtonsCleanBackPanel(btnClean, btnBack), BorderLayout.SOUTH);
        p.add(createPanelFind(), BorderLayout.CENTER);
        p.add(createTimeStepLabel(),BorderLayout.NORTH);

        add(p, BorderLayout.SOUTH);

    }

    private JPanel createPanelLists() {
        JPanel p = new JPanel(new GridLayout(1, 3, 5, 5));

        String l1 = "Aircraft Models";
        String l2 = "Origin Airport";
        String l3 = "Destination Airport";

        listAirOri = new JList(new LinkedList().toArray());
        listAirDest = new JList(new LinkedList().toArray());
        listAircraftModels = new JList(controller.getAircraftsModelList().toArray());
        listAircraftModels.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        listAirOri.setListData(controller.getAirportList().toArray());
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex);
                }
            }
        });

        listAirOri.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        String s = listAirOri.getSelectedValue().toString();
                        listAirDest.setListData(controller.getPossibleEndAirportsByAirportID(s).toArray());
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex);
                }
            }
        });
        
        listAirDest.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        btnEco.setEnabled(true);
                        btnFast.setEnabled(true);
                        btnShort.setEnabled(true);
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex);
                }
            }
        });
        
        p.add(createListsPanel(l1, listAircraftModels));
        p.add(createListsPanel(l2, listAirOri));
        p.add(createListsPanel(l3, listAirDest));

        return p;
    }
    
    private JPanel createTimeStepLabel(){
        JPanel p=new JPanel();
        txt=new JTextField(10);
        p.add(UI.createPanelLabelTextLabel("Time step: ", txt, "seg"));
        return p;
    }
    
    private JPanel createListsPanel(String title, JList jlist) {

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sPane = new JScrollPane(jlist);

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(title),
                new EmptyBorder(5, 5, 5, 5)));

        panel.add(sPane, BorderLayout.CENTER);

        return panel;
    }
    
    private JPanel createPanelFind() {
        JPanel p = new JPanel();

        int aux = 2;
        JPanel imports = new JPanel(new GridLayout(1, 3, aux, aux));
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Simulate:"), new EmptyBorder(aux, aux, aux, aux)));
        imports.add(createButtonShortest());
        imports.add(createButtonFastest());
        imports.add(createButtonEcologic());

        p.add(imports);

        return p;
    }
    
    public void buttonCleanAddListener() {
        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAirDest.clearSelection();
                listAirOri.clearSelection();
                listAircraftModels.clearSelection();
            }
        });
    }

    public void buttonBackAddListener() {
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
    }
    
    private JButton createButtonShortest() {
        Icon icone = new ImageIcon("src/main/resources/images/shortest.png");
        btnShort = new JButton("Find Shortest Path", icone);
        btnShort.setContentAreaFilled(false);
        btnShort.setBorderPainted(false);
        btnShort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShort.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShort.setMnemonic(KeyEvent.VK_S);
        btnShort.setEnabled(false);
        btnShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(createSimulation(TypePath.SHORTEST_PATH)){
                     createSimulation(TypePath.SHORTEST_PATH);
                    FindBestPathResultUI result=new FindBestPathResultUI(controller.getSimulation(),
                            TypePath.SHORTEST_PATH, CalculatePathsUI.this);
                    } else {
                    JOptionPane.showMessageDialog(CalculatePathsUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    
            }
        });

        return btnShort;
    }

    private JButton createButtonFastest() {
        Icon icone = new ImageIcon("src/main/resources/images/fastest.png");
        btnFast = new JButton("Find Fastest Path", icone);
        btnFast.setContentAreaFilled(false);
        btnFast.setBorderPainted(false);
        btnFast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFast.setMnemonic(KeyEvent.VK_F);
        btnFast.setEnabled(false);
        btnFast.addActionListener((ActionEvent e) -> {
                if(createSimulation(TypePath.FASTEST_PATH)){
                     createSimulation(TypePath.FASTEST_PATH);
                    FindBestPathResultUI result=new FindBestPathResultUI(controller.getSimulation(),
                            TypePath.FASTEST_PATH, CalculatePathsUI.this);
                } else {
                    JOptionPane.showMessageDialog(CalculatePathsUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
        });
        return btnFast;
    }

    private JButton createButtonEcologic() {
        Icon icone = new ImageIcon("src/main/resources/images/ecologic.png");
        btnEco = new JButton("Find Ecologic Path", icone);
        btnEco.setContentAreaFilled(false);
        btnEco.setBorderPainted(false);
        btnEco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEco.setMnemonic(KeyEvent.VK_E);
        btnEco.setEnabled(false);
        btnEco.setToolTipText("Please insert all data");
        btnEco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(createSimulation(TypePath.ECOLOGIC_PATH)){
                        createSimulation(TypePath.ECOLOGIC_PATH);
                    FindBestPathResultUI result=new FindBestPathResultUI(controller.getSimulation(),
                            TypePath.ECOLOGIC_PATH, CalculatePathsUI.this);
                } else {
                    JOptionPane.showMessageDialog(CalculatePathsUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                } catch (java.lang.UnsupportedOperationException en) {

                    JOptionPane.showMessageDialog(dialog,
                            "It wasn´t possible to create simulation", "Erro", JOptionPane.ERROR_MESSAGE);
                    throw en;
                }
            }
        });
        return btnEco;
    }

    

    private void close() {
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Calculate Paths?";
        int opcao = JOptionPane.showOptionDialog(dialog, question,
                "Calculate Paths", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private boolean createSimulation(TypePath type){
        controller.createBestPathSimulation(type);
        setData();
        controller.calculatePath(type);
        return controller.saveSimulation();
    }
    
    private void setData(){

        try {
               int timeStep=Integer.parseInt(txt.getText());
               AircraftModel model=(AircraftModel)listAircraftModels.getSelectedValue();
               Airport start=(Airport) listAirOri.getSelectedValue();
               Airport end=(Airport) listAirDest.getSelectedValue();
            if (!txt.getText().isEmpty()) {
                try {
                    
                    if (controller.validateData()){
               
                     controller.setData(timeStep, model, start, end);
                    }else{
                      JOptionPane.showMessageDialog(dialog, "Please verify the maximum number of passengers/crew", "Error", JOptionPane.ERROR_MESSAGE);
                     }    
                } catch (NumberFormatException ne1) {
                    JOptionPane.showMessageDialog(dialog, "Field invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println(ne1.getMessage());
                }
            }
             
            else {
                
                JOptionPane.showMessageDialog(dialog, "Fill all fields, please!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ne2) {
            JOptionPane.showMessageDialog(dialog, "Max Passengers fields invalid!", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(ne2.getMessage());
        }

    }
       

}
