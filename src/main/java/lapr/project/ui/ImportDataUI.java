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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Class that import data into aplication
 * @author Pedro Fernandes
 */
public class ImportDataUI extends JDialog{
    
    /**
     * Guarda a janela anterior
     */
    private final MenuUI framePai;
    /**
     * panel
     */
    private JPanel panel;
    /**
     * back button
     */
    private JButton back;
    /**
     * import airport button
     */
    private JButton airport;
    /**
     * import aircraft button
     */
    private JButton aircraft;     
    /**
     * import network button
     */
    private JButton network;
    
    public ImportDataUI(MenuUI framePai){
        super(framePai, "Import Data", true);
        
        this.framePai = framePai;
        
        add(createImportPanel()); 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeImport();
            }
        });
        
        pack();
        setResizable(false);
        setMinimumSize(new Dimension(1100, 500));
        setLocationRelativeTo(framePai);        
        setVisible(true);
    }
    
    public JPanel createImportPanel(){
        panel = new JPanel(new BorderLayout());
        
        int aux= 20;
        JPanel imports = new JPanel(new GridLayout(1,3, aux,aux));          
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Import:"), new EmptyBorder(aux, aux, aux, aux)));        
        imports.add(createButonImportAircraft());
        imports.add(createButonImportAirport());
        imports.add(createButonImportNetwork());

        panel.add(imports, BorderLayout.CENTER);     
        
        JPanel pback = new JPanel(new BorderLayout());
        pback.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(aux, aux, aux, aux)));
        pback.add(createButonBack(), BorderLayout.CENTER);
        
        panel.add(pback, BorderLayout.SOUTH);
        
        return panel;
    }
    
    
    public JButton createButonImportAirport(){
        Icon icone = new ImageIcon( "src/main/resources/images/airport_mini.jpg" );
        airport = new JButton("Import Airport", icone);
        airport.setContentAreaFilled(false);
        airport.setBorderPainted(false);
        airport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        airport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);      
        airport.setMnemonic(KeyEvent.VK_A);
        airport.setToolTipText("Import Airport");
        airport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportAirportUI impairport = new ImportAirportUI();
            }
        });
        return airport;
    }
    public JButton createButonImportAircraft(){
        Icon icone = new ImageIcon( "src/main/resources/images/aircraft.jpg" );
        aircraft = new JButton("Import Aircraft", icone);
        aircraft.setContentAreaFilled(false);
        aircraft.setBorderPainted(false);
        aircraft.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aircraft.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        aircraft.setMnemonic(KeyEvent.VK_R);
        aircraft.setToolTipText("Import Aircraft");
        aircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });
        return aircraft;
    }
    public JButton createButonImportNetwork(){
        Icon icone = new ImageIcon( "src/main/resources/images/network.jpg" );
        network = new JButton("Import Network", icone);
        network.setContentAreaFilled(false);
        network.setBorderPainted(false);
        network.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        network.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);  
        network.setMnemonic(KeyEvent.VK_N);
        network.setToolTipText("Import Network");
        network.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });
        return network;
    }
    public JButton createButonBack(){
        back = new JButton("Back");
        back.setMnemonic(KeyEvent.VK_B);
        back.setToolTipText("Cancel import and go to previous window");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeImport();
            }
        });
        return back;
    }
    
    public void closeImport(){
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(framePai, question,
                "Import Data", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
}
