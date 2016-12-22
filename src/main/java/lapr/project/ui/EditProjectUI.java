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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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
    private JButton addAirportBtn;
    private JButton editAirportBtn;
    private JButton addAircraftModelBtn;
    private JButton editAircraftModelBtn;
    private JButton addFlightBtn;
    private JButton editFlightBtn;
    private JButton back;
    private JButton editDataBtn;
    
    public EditProjectUI(Project project, JDialog frame){
        super(frame, "Edit Project: " + project.getName(), true);
        
        this.project = project;
        this.frame = frame;
        
        createComponents(); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        pack();
        setResizable(false);
        setSize(new Dimension(900, 600));
        setLocationRelativeTo(frame);        
        setVisible(true);
        
    }
    
    public void createComponents(){
        JMenuBar menuBar= createBarMenu();
        setJMenuBar(menuBar);
        
        add(createPanelDataProject(),BorderLayout.NORTH);        
        add(createPanelCenter(),BorderLayout.CENTER);   
        add(createPanelBtnBack(),BorderLayout.SOUTH);   
    }
    
    public JPanel createPanelDataProject(){
        int x = 10;
        JPanel pb = new JPanel(new BorderLayout());
        pb.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Project:"), new EmptyBorder(x, x, x, x)));
        pb.add(createButtonEditDataProject());

        return pb;
    }
    public JPanel createPanelCenter(){
        int x = 10;
        JPanel p = new JPanel(new GridLayout(1,3, x, x));
        
        ImageIcon i1 = new ImageIcon("src/main/resources/images/airport_2.jpg");
        JLabel l1 = new JLabel();
        l1.setIcon(i1);
        ImageIcon i2 = new ImageIcon("src/main/resources/images/aircraftmodel.jpg");
        JLabel l2 = new JLabel();
        l2.setIcon(i2);
        ImageIcon i3 = new ImageIcon("src/main/resources/images/flight.jpg");
        JLabel l3 = new JLabel();
        l3.setIcon(i3);
        
        JPanel pAirport = new JPanel();
        pAirport.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Airports:"), new EmptyBorder(x, x, x, x)));
        JPanel g1 = new JPanel(new GridLayout(2,1, x, x));
        g1.add(createButtonAddAirport());
        g1.add(createButtonEditAirport());
        
        pAirport.add(l1);
        pAirport.add(g1);
        
        JPanel pAircraft = new JPanel();
        pAircraft.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Aircraft Model:"), new EmptyBorder(x, x, x, x)));
        JPanel g2 = new JPanel(new GridLayout(2,1, x, x));
        g2.add(createButtonAddAircraftModel());
        g2.add(createButtonEditAircraftModel());
        
        pAircraft.add(l2);
        pAircraft.add(g2);
        
        JPanel pFlight = new JPanel();
        pFlight.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Flight:"), new EmptyBorder(x, x, x, x)));
        JPanel g3 = new JPanel(new GridLayout(2,1, x, x));
        g3.add(createButtonAddFlight());
        g3.add(createButtonEditFlight());
        
        pFlight.add(l3);
        pFlight.add(g3);
        
        p.add(pAirport);
        p.add(pAircraft);
        p.add(pFlight);

        return p;
    }
    
    public JPanel createPanelBtnBack(){
        int x = 10;
        JPanel pb = new JPanel(new BorderLayout());
        pb.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(x, x, x, x)));
        pb.add(createButtonBack(), BorderLayout.CENTER);

        return pb;
    }
    
    public JButton createButtonEditDataProject(){
        editDataBtn = new JButton("Edit Data Project"); 
        editDataBtn.setMnemonic(KeyEvent.VK_P);
        editDataBtn.setToolTipText("Edit Data Project");
        editDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDataProject();
            }
        });
        return editDataBtn;
    }
    
    public JButton createButtonAddAirport(){
        addAirportBtn = new JButton("Add Airport"); 
        addAirportBtn.setMnemonic(KeyEvent.VK_A);
        addAirportBtn.setToolTipText("Add Airport");
        addAirportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAirport();
            }
        });
        return addAirportBtn;
    }
    public JButton createButtonEditAirport(){
        editAirportBtn = new JButton("Edit Airport"); 
        editAirportBtn.setMnemonic(KeyEvent.VK_E);
        editAirportBtn.setToolTipText("Edit");
        editAirportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAirport();
            }
        });
        return editAirportBtn;
    }
    public JButton createButtonAddAircraftModel(){
        addAircraftModelBtn = new JButton("Add Aircraft Model"); 
        addAircraftModelBtn.setMnemonic(KeyEvent.VK_M);
        addAircraftModelBtn.setToolTipText("Add Aircraft Model");
        addAircraftModelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAircraftModel();
            }
        });
        return addAircraftModelBtn;
    }
    public JButton createButtonEditAircraftModel(){
        editAircraftModelBtn = new JButton("Edit Aircraft Model"); 
        editAircraftModelBtn.setMnemonic(KeyEvent.VK_D);
        editAircraftModelBtn.setToolTipText("Edit Aircraft Model");
        editAircraftModelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAircraftModel();
            }
        });
        return editAircraftModelBtn;
    }
    public JButton createButtonAddFlight(){
        addFlightBtn = new JButton("Add Flight"); 
        addFlightBtn.setMnemonic(KeyEvent.VK_F);
        addFlightBtn.setToolTipText("Add Flight");
        addFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
        return addFlightBtn;
    }
    public JButton createButtonEditFlight(){
        editFlightBtn = new JButton("Edit Flight"); 
        editFlightBtn.setMnemonic(KeyEvent.VK_L);
        editFlightBtn.setToolTipText("Edit Flight");
        editFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFlight();
            }
        });
        return editFlightBtn;
    }
    public JButton createButtonBack(){
        back = new JButton("Back"); 
        back.setMnemonic(KeyEvent.VK_B);
        back.setToolTipText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        return back;
    }
    
    private JMenuBar createBarMenu(){
        JMenuBar menuBar=new JMenuBar();
        
        menuBar.add(createMenuFile());
        
        return menuBar;
    }
    
    private JMenu createMenuFile(){
        JMenu menu=new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        
        menu.add(createMenuEditDataProject());
        menu.addSeparator();
        menu.add(createSubMenuAirport());
        menu.add(createSubMenuAircraftModel());
        menu.add(createSubMenuFlight());
        menu.addSeparator();
        menu.add(createItemBack());
        
        return menu;
    }
    
    private JMenu createMenuEditDataProject(){
         JMenu menu = new JMenu("Edit Data Project");
        menu.setMnemonic(KeyEvent.VK_D);

        menu.add(createItemAddAirport());
        menu.add(createItemEditAirport());


        return menu;
    }
    private JMenu createSubMenuAirport(){
         JMenu menu = new JMenu("Airport");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add(createItemAddAirport());
        menu.add(createItemEditAirport());


        return menu;
    }
    
    private JMenu createSubMenuAircraftModel(){
         JMenu menu = new JMenu("Aircraft Model");
        menu.setMnemonic(KeyEvent.VK_M);

        menu.add(createItemAddAircraftModel());
        menu.add(createItemEditAircraftModel());


        return menu;
    }
    
    private JMenu createSubMenuFlight(){
         JMenu menu = new JMenu("Flight");
        menu.setMnemonic(KeyEvent.VK_F);

        menu.add(createItemAddFlight());
        menu.add(createItemEditFlight());


        return menu;
    }
    
    private JMenuItem createItemAddAirport(){
        JMenuItem item = new JMenuItem("Add Airport", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAirport();
            }
        });

        return item;
    }
    private JMenuItem createItemEditAirport(){
        JMenuItem item = new JMenuItem("Edit Airport", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAirport();
            }
        });

        return item;
    }
    private JMenuItem createItemAddAircraftModel(){
        JMenuItem item = new JMenuItem("Add Aircraft Model", KeyEvent.VK_M);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAircraftModel();
            }
        });

        return item;
    }
    private JMenuItem createItemEditAircraftModel(){
        JMenuItem item = new JMenuItem("Edit Aircraft Model", KeyEvent.VK_D);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAircraftModel();
            }
        });

        return item;
    }
    private JMenuItem createItemAddFlight(){
        JMenuItem item = new JMenuItem("Add Flight", KeyEvent.VK_F);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });

        return item;
    }
    private JMenuItem createItemEditFlight(){
        JMenuItem item = new JMenuItem("Edit Flight", KeyEvent.VK_L);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });

        return item;
    }
 
    private JMenuItem createItemBack(){
        JMenuItem item = new JMenuItem("Back", KeyEvent.VK_B);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        return item;
    }

    private void addAirport(){
        AddAirportUI addairport = new AddAirportUI(project,EditProjectUI.this);
    }
    private void editAirport(){
        // implement
    }
    private void addAircraftModel(){
        AddAircraftUI aircraft = new AddAircraftUI(project,EditProjectUI.this);
    }
    private void editAircraftModel(){
        // implement
    }
    private void addFlight(){
        // implement
    }
    private void editFlight(){
        // implement
    }
    private void editDataProject(){
        // implement
    }
    private void back(){
        dispose();
    }
}
