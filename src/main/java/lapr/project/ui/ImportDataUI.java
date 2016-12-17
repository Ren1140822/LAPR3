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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AddAirportController;

/**
 * Class that import data into aplication
 * @author Pedro Fernandes
 */
public class ImportDataUI extends JDialog{
    
    /**
     * Guarda a janela anterior
     */
    private MenuUI framePai;
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
        
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(framePai);
        pack();
        setVisible(true);
    }
    
    public JPanel createImportPanel(){
        panel = new JPanel(new BorderLayout());
        
        int aux= 20;
        JPanel imports = new JPanel(new GridLayout(1,3, aux,aux));
          
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder("Import:"), new EmptyBorder(aux, aux, aux, aux)));
        
        imports.add(createButonImportAircraft());
        imports.add(createButonImportAirport());
        imports.add(createButonImportNetwork());

        panel.add(imports, BorderLayout.CENTER);
        panel.add(createButonBack(), BorderLayout.SOUTH);
        
        return panel;
    }
    
    
    public JButton createButonImportAirport(){
        back = new JButton("Import Airport");
        back.setMnemonic(KeyEvent.VK_A);
        back.setToolTipText("Import Airport");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });
        return back;
    }
    public JButton createButonImportAircraft(){
        back = new JButton("Import Aircraft");
        back.setMnemonic(KeyEvent.VK_R);
        back.setToolTipText("Import Aircraft");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });
        return back;
    }
    public JButton createButonImportNetwork(){
        back = new JButton("Import Network");
        back.setMnemonic(KeyEvent.VK_N);
        back.setToolTipText("Import Network");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementar
            }
        });
        return back;
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
