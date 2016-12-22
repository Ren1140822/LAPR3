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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
 * Menu of the active project
 * @author Pedro Fernandes
 */
public class MenuProjectUI extends JDialog{
    
    Project project;
    private JButton edit;
    private JButton export;
    private JButton analyses;
    private JButton importxml;
    private JButton back;

    public MenuProjectUI(Project project, JFrame frame){
        
        super(frame, "Project: " + project.getName(), true);        
        
        this.project = project;
        
        createComponents();        
        
        pack();
        setResizable(false);        
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeBack();
            }
        });
        
    }
    
    public void createComponents(){
        JMenuBar menuBar= createBarMenu();
        setJMenuBar(menuBar);
        
        add(createPanelImage(),BorderLayout.NORTH);        
        add(createPanelButons(),BorderLayout.CENTER);   
        add(createPanelBack(),BorderLayout.SOUTH);   
    }
    public JPanel createPanelBack(){
        int aux = 10;
        JPanel pback = new JPanel(new BorderLayout());
        pback.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(aux, aux, aux, aux)));
        pback.add(createButtonBack(), BorderLayout.CENTER);

        return pback;
    }
    
    private JPanel createPanelImage() {
        ImageIcon background = new ImageIcon("src/main/resources/images/airnetwork_2.jpg");
        
        JLabel label = new JLabel();
        label.setIcon(background);
        
        int aux = 15;
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(aux, aux, aux, aux));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
    
    public JPanel createPanelButons(){
        
        int aux = 5;
        
        JPanel grid = new JPanel(new GridLayout(1,2));

        JPanel p1 = new JPanel(new GridLayout(1,2, aux, aux));        
        
        p1.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Data:"), new EmptyBorder(aux, aux, aux, aux)));
        
        getRootPane().setDefaultButton(createButtonImport());
        
        p1.add(createButtonImport());
        p1.add(createButtonEdit());
        
        JPanel p2 = new JPanel(new GridLayout(1,2, aux, aux));        
        
        p2.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Results:"), new EmptyBorder(aux, aux, aux, aux)));
        
        p2.add(createButtonAnalysis());
        p2.add(createButtonExport());
        
        grid.add(p1);
        grid.add(p2);
        
        return grid; 
    }
    
    public JButton createButtonEdit(){
        Icon icone = new ImageIcon( "src/main/resources/images/edit.png" );
        edit = new JButton("Edit Project",icone); 
        edit.setContentAreaFilled(false);
        edit.setBorderPainted(false);
        edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        edit.setMnemonic(KeyEvent.VK_E);
        edit.setToolTipText("Edit Project");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProject();
            }
        });
        return edit;
    }
    public JButton createButtonImport(){
        Icon icone = new ImageIcon( "src/main/resources/images/importlogo.jpg" );
        importxml = new JButton("Import Data",icone); 
        importxml.setContentAreaFilled(false);
        importxml.setBorderPainted(false);
        importxml.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importxml.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM); 
        importxml.setMnemonic(KeyEvent.VK_I);
        importxml.setToolTipText("Import Data");
        importxml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importData();
            }
        });
        return importxml;
    }
    public JButton createButtonExport(){
        Icon icone = new ImageIcon( "src/main/resources/images/exportlogo.jpg" );
        export = new JButton("Export Results",icone); 
        export.setContentAreaFilled(false);
        export.setBorderPainted(false);
        export.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        export.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM); 
        export.setMnemonic(KeyEvent.VK_R);
        export.setToolTipText("Export Results");
        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportResults();
            }
        });
        return export;
    }
    public JButton createButtonAnalysis(){
        Icon icone = new ImageIcon( "src/main/resources/images/analysis.jpg" );
        analyses = new JButton("View Analysis",icone);
        analyses.setContentAreaFilled(false);
        analyses.setBorderPainted(false);
        analyses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        analyses.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM); 
        analyses.setMnemonic(KeyEvent.VK_A);
        analyses.setToolTipText("View Analysis");
        analyses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analysis();
            }
        });
        return analyses;
    }
    public JButton createButtonBack(){
        back = new JButton("Back"); 
        back.setMnemonic(KeyEvent.VK_B);
        back.setToolTipText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeBack();
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
        
        menu.add(createItemImportData());
        menu.add(createItemEdit());
        menu.addSeparator();
        menu.add(createItemAnalysis());
        menu.add(createItemResults());
        menu.addSeparator();
        menu.add(createItemClose());
        
        return menu;
    }
    
    private JMenuItem createItemEdit(){
        JMenuItem item = new JMenuItem("Edit Project", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProject();
            }
        });

        return item;
    }
    
    private JMenuItem createItemImportData(){
        JMenuItem item = new JMenuItem("Import Data", KeyEvent.VK_I);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importData();
            }
        });

        return item;
    }
    
    private JMenuItem createItemResults(){
        JMenuItem item = new JMenuItem("Export Results", KeyEvent.VK_R);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportResults();
            }
        });

        return item;
    }
    private JMenuItem createItemAnalysis(){
        JMenuItem item = new JMenuItem("View Analysis", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analysis();
            }
        });

        return item;
    }
    
    private JMenuItem createItemClose(){
        JMenuItem item = new JMenuItem("Close", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeBack();
            }
        });

        return item;
    }
    
    private void editProject(){
        EditProjectUI editproj = new EditProjectUI(project, MenuProjectUI.this);
    }
    
    private void importData(){
        ImportDataUI imp = new ImportDataUI(project, MenuProjectUI.this);
    }
    
    private void exportResults(){
        ExportProjectUI proj = new ExportProjectUI(project, MenuProjectUI.this);
    }
    
    private void analysis(){
        // create analyses ui => implement
    }
    
    private void closeBack() {
        dispose();
    }
    
}
