/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lapr.project.model.Project;

/**
 *
 * @author Diana Silva
 */
public class AnalysisUI extends JDialog{
     private JDialog frame;
    private ComparisonUI comp;
    private FindBestPathUI best;
    
    private Project project;

    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 250;
    private final String WINDOW_TITLE = "Analysis";
    
    public AnalysisUI(Project project, JDialog frame){
        super(frame, "Analysis", true);
        this.project = project;
        this.frame = frame;
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        setLocationRelativeTo(frame);
        this.setResizable(false);
        createComponents();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }
    
    private void createComponents() {
        JPanel p=new JPanel(new GridLayout(1,2));
        p.add(createJButtonPath());
        p.add(createJButtonCompare()); 
        
        add(p);
    }
    
    private JButton createJButtonPath() {
        Icon icone = new ImageIcon( "src/main/resources/images/findPath.jpg" );
        JButton button = new JButton("Find Best Path", icone);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        button.setMnemonic(KeyEvent.VK_S);
        button.setToolTipText("Simulates flight and results of simulation");

        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
               if(project.getAircraftModelList().getModelList().isEmpty() ||
                       project.getAirportList().getAirportList().isEmpty() ||
                       project.getAirNetwork().getSegmentList().isEmpty())
                   
                   JOptionPane.showMessageDialog(frame,
                "There aren´t aircrafts/airports/segments created", "Erro", JOptionPane.ERROR_MESSAGE);
                else
                   best=new FindBestPathUI(project, frame);
               
                
            }

        });
        return button;
    }
    
    private JButton createJButtonCompare() {
        Icon icone = new ImageIcon( "src/main/resources/images/compare.png" );
        JButton button = new JButton("Compare", icone);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        button.setMnemonic(KeyEvent.VK_S);
        button.setToolTipText("Compare Aircrafts/Engines");
        
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if(project.getSimulationsList().getSimulationsList().isEmpty())
                   JOptionPane.showMessageDialog(frame,
                "There aren´t simulations created", "Erro", JOptionPane.ERROR_MESSAGE);
                else  
                 comp=new ComparisonUI(project, frame);        
            }
        });
        return button;
    }
    
    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Comparison Results", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
}