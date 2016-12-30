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
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class OpenProjectUI extends JDialog{
    
    Project project;
    JButton backBtn;
    JButton okBtn;
    JList projectsList;
    
    public OpenProjectUI(JFrame frame){
        
        super(frame, "Open Project", true);

        createComp();
        
        pack();
        setResizable(false);
        setMinimumSize(new Dimension(400, 150));
        setLocationRelativeTo(null);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setBounds(0, 0, screenSize.width, screenSize.height);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
    }
    public void createComp() {

        List projs= new ArrayList(); //receber do controller
        projs.add("teste1"); // retirar
        projs.add("teste2"); // retirar
        projs.add("teste3"); // retirar
        projs.add("teste4"); // retirar
        projs.add("teste5"); // retirar
        projs.add("teste6"); // retirar
        projs.add("teste7"); // retirar
        projs.add("teste8"); // retirar
        projs.add("teste9"); // retirar
        projs.add("teste10"); // retirar
        projs.add("teste11"); // retirar
        projs.add("teste12"); // retirar
        projectsList = new JList(projs.toArray());
        
        add(createPanelProjects("Projects:", projectsList), BorderLayout.CENTER);        
        add(createPanelButons(), BorderLayout.SOUTH);
    }
    
    public JPanel createPanelButons() {
        int aux = 10;
        JPanel pback = new JPanel();
        pback.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(aux, aux, aux, aux)));
        pback.add(createButtonOk());
        pback.add(createButtonBack());

        return pback;
    }
    
     public JPanel createPanelProjects(String title, JList list) {
         
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                okBtn.setEnabled(true);
            }
        });
        JScrollPane scrPane = new JScrollPane(list);

        JPanel p = new JPanel(new BorderLayout());
        
        final int MARGEM_SUPERIOR = 5, MARGEM_INFERIOR = 5;
        final int MARGEM_ESQUERDA = 5, MARGEM_DIREITA = 5;
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(title),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(scrPane, BorderLayout.CENTER);
         
        return p;
     }
    
    public JButton createButtonBack() {
        backBtn = new JButton("Back");
        backBtn.setMnemonic(KeyEvent.VK_B);
        backBtn.setToolTipText("Back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        return backBtn;
    }
    
    public JButton createButtonOk() {
        okBtn = new JButton("Ok");
        okBtn.setMnemonic(KeyEvent.VK_O);
        okBtn.setToolTipText("Ok");
        okBtn.setEnabled(false);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm();
            }
        });
        return okBtn;
    }
    
    private void close() {
        dispose();
    }
    
    private void confirm() {
        // implementar controller
        project = new Project(); // retirar e ir buscar o projecto pelo controller
        
        dispose();
        MenuProjectUI menuProj = new MenuProjectUI(project, OpenProjectUI.this);        
    }

}
