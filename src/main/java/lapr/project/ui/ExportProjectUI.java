/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportProjectUI extends JFrame {

    private final int WINDOW_WIDTH = 250;
    private final int WINDOW_HEIGHT = 150;
    private final String WINDOW_TITLE = "Export data";

    public ExportProjectUI(JFrame parentFrame) {
            this.setLocationRelativeTo(parentFrame);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        this.setResizable(false);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        JLabel label = createLabellHTML();
        JLabel label2 = createLabelCSV();
        this.add(label, BorderLayout.EAST);
        this.add(label2, BorderLayout.WEST);
    }

    private JLabel createLabellHTML() {
        JLabel label = new JLabel();
        label.setText("");
        Icon icon = new ImageIcon("src/main/resources/images/html.png");

        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ExportHTMLUI instance = new ExportHTMLUI(ExportProjectUI.this);
                ExportProjectUI.this.setVisible(false);
            }
        });
        Dimension d = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        label.setPreferredSize(d);
     
        return label;
    }

    private JLabel createLabelCSV() {
        JLabel label = new JLabel();
        label.setText("");
        Icon icon = new ImageIcon("src/main/resources/images/csv.png");
        label.setIcon(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ExportCSVUI instance = new ExportCSVUI(ExportProjectUI.this);
                ExportProjectUI.this.setVisible(false);
            }
        });
        Dimension d = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        label.setPreferredSize(d);
        return label;
    }
    
     public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(null, question,
                "Export Project", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
}
