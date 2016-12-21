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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.Project;

/**
 * Menu of the active project
 * @author Pedro Fernandes
 */
public class MenuProjectUI extends JDialog{
    
    private JButton edit;
    private JButton export;
    private JButton analyses;
    private JButton importxml;
    private JButton back;

    public MenuProjectUI(JFrame frame){
        
        super(frame, "Project: " + Project.getName(), true);        
        
        createComponents();        
        
        pack();
        setResizable(true);        
        setMinimumSize(new Dimension(800, 650));
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMenuProject();
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
        JPanel pback = new JPanel(new BorderLayout());
        pback.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(20, 20, 20, 20)));
        pback.add(createButtonBack(), BorderLayout.CENTER);

        return pback;
    }
    
    private JPanel createPanelImage() {
        ImageIcon background = new ImageIcon("src/main/resources/images/airport_mini.jpg");
        
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 10, 10, 10));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
    
    public JPanel createPanelButons(){
        
        JPanel grid = new JPanel(new GridLayout(1,2));

        JPanel p1 = new JPanel(new GridLayout(2,1));        
        
        p1.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Data:"), new EmptyBorder(30, 30, 30, 30)));
        
        getRootPane().setDefaultButton(createButtonImport());
        
        p1.add(createButtonImport());
        p1.add(createButtonEdit());
        
        JPanel p2 = new JPanel(new GridLayout(2,1));        
        
        p2.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Results:"), new EmptyBorder(30, 30, 30, 30)));
        
        p2.add(createButtonAnalyses());
        p2.add(createButtonExport());
        
        grid.add(p1);
        grid.add(p2);
        
        return grid; 
    }
    
    public JButton createButtonEdit(){
        edit = new JButton("Edit Project"); 
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
        importxml = new JButton("Import Data"); 
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
        export = new JButton("Export Results"); 
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
    public JButton createButtonAnalyses(){
        analyses = new JButton("View Analyses"); 
        analyses.setMnemonic(KeyEvent.VK_A);
        analyses.setToolTipText("View Analyses");
        analyses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyses();
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
        
        menu.add(createItemEdit());
        menu.add(createItemImportData());
        menu.addSeparator();
        menu.add(createItemAnalyses());
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
    private JMenuItem createItemAnalyses(){
        JMenuItem item = new JMenuItem("Analyses", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyses();
            }
        });

        return item;
    }
    
    private JMenuItem createItemClose(){
        JMenuItem item = new JMenuItem("Exit", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeMenuProject();
            }
        });

        return item;
    }
    
    public void closeMenuProject(){
        String[] op = {"Yes", "No"};
        String question = "Close aplication?";
        int opcao = JOptionPane.showOptionDialog(MenuProjectUI.this, question,
                this.getTitle(), JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            closeBack();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void editProject(){
        EditProjectUI editproj = new EditProjectUI(this);
    }
    
    private void importData(){
        ImportDataUI imp = new ImportDataUI(this);
    }
    
    private void exportResults(){
        ExportProjectUI proj = new ExportProjectUI();
    }
    
    private void analyses(){
        // create project ui => implement
    }
    
    private void closeBack() {
        dispose();
    }
    
}
