/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import lapr.project.controller.ExportHTMLController;
import lapr.project.model.Result;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportHTMLUI extends JFrame {

    /**
     * Instance variables.
     */
    private final int WINDOW_WIDTH = 550;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_TITLE = "Export data to HTML";
    private ExportHTMLController controller;
    private Map<String, LinkedList<Result>> results;
    private JList listBest;
    private JList listComparison;
    private JList listShortestPath;

    public ExportHTMLUI() {
        this.setResizable(false);
        controller = new ExportHTMLController();
        results = controller.getAvailableResults();
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        FlowLayout fl = new FlowLayout(FlowLayout.LEADING);
        JPanel panelLists = new JPanel(fl);
        JPanel panelLabels = new JPanel(fl);
        JLabel labelBest = createJLabels("Best consumption");
        JLabel labelComp = createJLabels("Comparison");
        JLabel labelShort = createJLabels("Shortest Path");
        panelLabels.add(labelBest);
        panelLabels.add(labelComp);
        panelLabels.add(labelShort);
        JPanel panelUpdateBtn = new JPanel();
        listBest = createJList("Best consumption");
        listComparison = createJList("Comparison");
        listShortestPath = createJList("Shortest Path");
        panelLists.add(listBest);
        panelLists.add(listComparison);
        panelLists.add(listShortestPath);
        JButton btn = createJButtonUpdate();
        panelUpdateBtn.add(btn, BorderLayout.NORTH);
        add(panelLists, BorderLayout.WEST);
       
        add(panelUpdateBtn, BorderLayout.CENTER);
        JButton btnExport = createExportJButton();
        add(btnExport, BorderLayout.SOUTH);
    }

    private JLabel createJLabels(String text) {
        JLabel label = new JLabel(text);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        return label;
    }

    private JList createJList(String keyValue) {
        JList list = new JList();

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        list.setBorder(border);
        list.setPreferredSize(new Dimension(150, 300));
        list.setListData(results.get(keyValue).toArray());
        return list;
    }

    private JButton createJButtonUpdate() {
        JButton btn = new JButton();

        Icon icon = new ImageIcon("src/main/resources/images/Update-icon.png");
        btn.setIcon(icon);
        btn.setOpaque(true);
        Icon iconPressed = new ImageIcon("src/main/resources/images/Update-iconPressed.png");
        btn.setPressedIcon(iconPressed);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        btn.setBorder(border);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                listBest.setListData(results.get("Best consumption").toArray());
                listComparison.setListData(results.get("Comparison").toArray());
                listShortestPath.setListData(results.get("Shortest Path").toArray());
            }
        });
        return btn;
    }

    private JButton createExportJButton() {
        JButton btn = new JButton();

        btn.setText("Export selected results");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        btn.setBorder(border);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (listBest.getSelectedValue() == null && listComparison.getSelectedValue() == null && listShortestPath.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Nothing selected to export.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showSaveDialog(null);
                    String path = chooser.getCurrentDirectory().getAbsolutePath();
                    if (listBest.getSelectedValue() != null) {
                        controller.exportResult((Result) listBest.getSelectedValue(), path + "\\best.html");
                    }
                    if (listComparison.getSelectedValue() != null) {
                        controller.exportResult((Result) listComparison.getSelectedValue(), path + "\\comparison.html");
                    }
                    if (listShortestPath.getSelectedValue() != null) {
                        controller.exportResult((Result) listShortestPath.getSelectedValue(), path + "\\shortestpath.html");
                    }
                }
            }
        });
        return btn;
    }

}
