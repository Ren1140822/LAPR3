/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.Project;

/**
 * Start Menu of the aplication
 * @author Pedro Fernandes
 */
public class MenuUI extends JFrame{
    
    private Project project;
    private MenuUI frame;
    private JButton open;
    private JButton create;
    private JButton exit;
    
    public MenuUI(Project project){
        super("AirNetwork Projects Simulator");
        
        this.project = project;
        frame = MenuUI.this;
        
        createComponents();        
        
        pack();
        setResizable(true);        
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }
    
    public void createComponents(){
        JMenuBar menuBar= createBarMenu();
        setJMenuBar(menuBar);
        
        add(createPanelImage(),BorderLayout.CENTER);
        
        add(createPanelButons(),BorderLayout.SOUTH);   
    }
    
    private JMenuBar createBarMenu(){
        JMenuBar menuBar=new JMenuBar();
        
        menuBar.add(createMenuFile());
        menuBar.add(createMenuOptions());
        
        return menuBar;
    }
    
    private JMenu createMenuFile(){
        JMenu menu=new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        
        menu.add(createItemOpen());
        menu.add(createItemCreate());
        menu.addSeparator();
        menu.add(createItemExit());
        
        return menu;
        
    }
    
    private JMenu createMenuOptions(){
        JMenu menu=new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        
        menu.add(createSubMenuStyle());
        menu.addSeparator();
        menu.add(createItemAbout());
        
        return menu;
    }
    
    private JMenu createSubMenuStyle(){
         JMenu menu = new JMenu("Style");
        menu.setMnemonic(KeyEvent.VK_S);

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            menu.add(createItemStyle(info));
        }

        return menu;
    }
    
    private JMenuItem createItemStyle(UIManager.LookAndFeelInfo info) {
        JMenuItem item = new JMenuItem(info.getName());

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(MenuUI.this);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    JOptionPane.showMessageDialog(MenuUI.this,
                            ex.getMessage(),
                            "Style " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(MenuUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return item;
    }
    
    private JMenuItem createItemAbout(){
        JMenuItem item = new JMenuItem("About", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuUI.this,
                        "@Copyright\n\nDiana Silva, Flávio Relvas, Pedro Fernandes"
                                + ", Renato Oliveira\n\nLAPR3 2016/2017",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }
    
    private JMenuItem createItemOpen(){
        JMenuItem item = new JMenuItem("Open Project", KeyEvent.VK_O);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });

        return item;
    }
    private JMenuItem createItemCreate(){
        JMenuItem item = new JMenuItem("Create Project", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });

        return item;
    }
    private JMenuItem createItemExit(){
        JMenuItem item = new JMenuItem("Exit", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        return item;
    }
    
    private JPanel createPanelImage() {
        ImageIcon background = new ImageIcon("src/main/resources/images/airnetwork.png");
        
        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 10, 10, 10));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
    
    public JPanel createPanelButons(){

        JPanel p = new JPanel();        
        
        p.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(30, 30, 30, 30)));
        
        getRootPane().setDefaultButton(createButtonOpen());
        
        p.add(createButtonOpen());
        p.add(createButtonCreate());
        p.add(createButtonClose());
        
        return p; 
    }
    
    public JButton createButtonOpen(){
        open = new JButton("Open Project"); 
        open.setMnemonic(KeyEvent.VK_O);
        open.setToolTipText("Open Project");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        return open;
    }
    
    public JButton createButtonCreate(){
        create = new JButton("Create Project"); 
        create.setMnemonic(KeyEvent.VK_C);
        create.setToolTipText("Create Project");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        return create;
    }
    
    public JButton createButtonClose(){
        exit = new JButton("Exit"); 
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Create Project");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        return exit;
    }
    
    public void closeWindow(){
        String[] op = {"Yes", "No"};
        String question = "Close aplication?";
        int opcao = JOptionPane.showOptionDialog(frame, question,
                this.getTitle(), JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            finish();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void open(){
        MenuProjectUI menuproj = new MenuProjectUI(project,frame);
    }
    
    private void create(){
        // create project ui => implement
    }
    
    private void finish() {
        dispose();
    }
    
}
