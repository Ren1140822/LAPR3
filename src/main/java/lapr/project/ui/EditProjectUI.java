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
import javax.swing.JTextField;
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
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private static final Dimension dim = new Dimension(250, 60);
    
    public EditProjectUI(Project project, JDialog frame){
        super(frame, "Edit Project: " + project.getName(), true);
        
        this.project = project;
        this.frame = frame;
        
        createComponents(); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                back();
            }
        });
        
        pack();
        setResizable(false);
        setSize(new Dimension(900, 600));
        setLocationRelativeTo(frame);        
        setVisible(true);
        
    }
    
    private void createComponents(){
        JMenuBar menuBar= createBarMenu();
        setJMenuBar(menuBar);
        
        add(createPanelDataProject(),BorderLayout.NORTH);        
        add(createPanelCenter(),BorderLayout.CENTER);   
        add(createPanelBtnBack(),BorderLayout.SOUTH);   
    }
    
    private JPanel createPanelDataProject(){
        int z = 30;
        JLabel l1 = new JLabel("ID:", JLabel.RIGHT);
        JLabel l2 = new JLabel("Name:", JLabel.RIGHT);
        JLabel l3 = new JLabel("Description:", JLabel.RIGHT);
        txt1 = new JTextField(""+project.getIdProject(),z);
        txt1.setEditable(false);
        txt2 = new JTextField(project.getName(),z);
        txt2.setEditable(false);
        txt3 = new JTextField(project.getDescription(),z);
        txt3.setEditable(false);
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1.add(l1);
        p1.add(txt1);
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(l2);
        p2.add(txt2);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p3.add(l3);
        p3.add(txt3);
        
        JPanel pleft = new JPanel(new GridLayout(3,1));
        pleft.add(p1);
        pleft.add(p2);
        pleft.add(p3);
        
        int x = 10;
        JPanel pb = new JPanel();
        pb.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Project:"), new EmptyBorder(x, x, x, x)));
        pb.add(pleft);
        pb.add(createButtonEditDataProject());

        return pb;
    }
    private JPanel createPanelCenter(){
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
                "Aircrafts:"), new EmptyBorder(x, x, x, x)));
        JPanel g2 = new JPanel(new GridLayout(2,1, x, x));
        g2.add(createButtonAddAircraft());
        g2.add(createButtonEditAircraft());
        
        pAircraft.add(l2);
        pAircraft.add(g2);
        
        JPanel pFlight = new JPanel();
        pFlight.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Flight Plan:"), new EmptyBorder(x, x, x, x)));
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
    
    private JPanel createPanelBtnBack(){
        int x = 10;
        JPanel pb = new JPanel(new BorderLayout());
        pb.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(x, x, x, x)));
        pb.add(createButtonBack(), BorderLayout.CENTER);

        return pb;
    }
    
    private JButton createButtonEditDataProject(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/editbutton.png");
        editDataBtn = new JButton("Edit Data Project",icon); 
        editDataBtn.setPreferredSize(new Dimension(250, 80));
        editDataBtn.setMnemonic(KeyEvent.VK_P);
        editDataBtn.setContentAreaFilled(false);
        editDataBtn.setToolTipText("Edit Data Project");
        editDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDataProject();
            }
        });
        return editDataBtn;
    }
    
    private JButton createButtonAddAirport(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/addbutton.png");
        addAirportBtn = new JButton("Add Airport",icon); 
        addAirportBtn.setPreferredSize(dim);
        addAirportBtn.setContentAreaFilled(false);
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
    private JButton createButtonEditAirport(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/editbutton.png");
        editAirportBtn = new JButton("Edit Airport",icon); 
        editAirportBtn.setPreferredSize(dim);
        editAirportBtn.setContentAreaFilled(false);
        editAirportBtn.setMnemonic(KeyEvent.VK_E);
        editAirportBtn.setToolTipText("Edit Airport");
        editAirportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAirport();
            }
        });
        return editAirportBtn;
    }
    private JButton createButtonAddAircraft(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/addbutton.png");
        addAircraftModelBtn = new JButton("Add Aircraft",icon); 
        addAircraftModelBtn.setPreferredSize(dim);
        addAircraftModelBtn.setContentAreaFilled(false);
        addAircraftModelBtn.setMnemonic(KeyEvent.VK_M);
        addAircraftModelBtn.setToolTipText("Add Aircraft");
        addAircraftModelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAircraft();
            }
        });
        return addAircraftModelBtn;
    }
    private JButton createButtonEditAircraft(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/editbutton.png");
        editAircraftModelBtn = new JButton("Edit Aircraft",icon); 
        editAircraftModelBtn.setPreferredSize(dim);
        editAircraftModelBtn.setContentAreaFilled(false);
        editAircraftModelBtn.setMnemonic(KeyEvent.VK_D);
        editAircraftModelBtn.setToolTipText("Edit Aircraft");
        editAircraftModelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAircraft();
            }
        });
        return editAircraftModelBtn;
    }
    private JButton createButtonAddFlight(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/addbutton.png");
        addFlightBtn = new JButton("Add Flight Plan",icon); 
        addFlightBtn.setPreferredSize(dim);
        addFlightBtn.setContentAreaFilled(false);
        addFlightBtn.setMnemonic(KeyEvent.VK_F);
        addFlightBtn.setToolTipText("Add Flight Plan");
        addFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
        return addFlightBtn;
    }
    private JButton createButtonEditFlight(){
        ImageIcon icon = new ImageIcon("src/main/resources/images/editbutton.png");
        editFlightBtn = new JButton("Edit Flight Plan",icon); 
        editFlightBtn.setPreferredSize(dim);
        editFlightBtn.setContentAreaFilled(false);
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
    private JButton createButtonBack(){
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
    
    private JMenuItem createMenuEditDataProject(){
        JMenuItem item = new JMenuItem("Edit Data Project", KeyEvent.VK_D);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));      
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDataProject();
            }
        });
        return item;
        
    }
    private JMenu createSubMenuAirport(){
         JMenu menu = new JMenu("Airport");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add(createItemAddAirport());
        menu.add(createItemEditAirport());

        return menu;
    }
    
    private JMenu createSubMenuAircraftModel(){
         JMenu menu = new JMenu("Aircraft");
        menu.setMnemonic(KeyEvent.VK_M);

        menu.add(createItemAddAircraft());
        menu.add(createItemEditAircraft());


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
    private JMenuItem createItemAddAircraft(){
        JMenuItem item = new JMenuItem("Add Aircraft", KeyEvent.VK_M);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAircraft();
            }
        });

        return item;
    }
    private JMenuItem createItemEditAircraft(){
        JMenuItem item = new JMenuItem("Edit Aircraft", KeyEvent.VK_D);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAircraft();
            }
        });

        return item;
    }
    private JMenuItem createItemAddFlight(){
        JMenuItem item = new JMenuItem("Add Flight Plan", KeyEvent.VK_F);
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
        JMenuItem item = new JMenuItem("Edit Flight Plan", KeyEvent.VK_L);
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
    private void addAircraft(){
        AddAircraftUI aircraft = new AddAircraftUI(project,EditProjectUI.this);
    }
    private void editAircraft(){
        // implement
    }
    private void addFlight(){
        AddFlightPlanUI addflight = new AddFlightPlanUI(project,EditProjectUI.this);
    }
    private void editFlight(){
        // implement
    }
    private void editDataProject(){
        EditDataProjectUI editdata = new EditDataProjectUI(project, EditProjectUI.this);
        dispose();
    }
    private void back(){
        dispose();
    }
}
