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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import lapr.project.model.Project;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportProjectUI extends JFrame {
    
    Project project;

    private final int WINDOW_WIDTH = 250;
    private final int WINDOW_HEIGHT = 150;
    private final String WINDOW_TITLE = "Export data";

    public ExportProjectUI(Project project) {
        this.project = project;
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
                ExportHTMLUI instance = new ExportHTMLUI(project,ExportProjectUI.this);

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
                ExportCSVUI instance = new ExportCSVUI(project,ExportProjectUI.this);
            }
        });
        Dimension d = new Dimension(icon.getIconWidth(), icon.getIconHeight());
        label.setPreferredSize(d);
        return label;
    }
}
