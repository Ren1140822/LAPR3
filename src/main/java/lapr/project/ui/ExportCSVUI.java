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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import lapr.project.controller.ExportCSVController;
import lapr.project.model.anaylsis.Result;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportCSVUI extends JFrame {

    private final int WINDOW_WIDTH = 550;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_TITLE = "Export data to CSV";
    private ExportCSVController controller;
    private Map<String, LinkedList<Result>> results;
    private JList listBest;
    private JList listComparison;
    private JList listShortestPath;
    private DialogSelectable dialog;
    private JFrame parentFrame;

    public ExportCSVUI(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.setLocationRelativeTo(this.parentFrame);

        this.setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });

        controller = new ExportCSVController();

        results = controller.getAvailableResults();
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        FlowLayout fl = new FlowLayout(FlowLayout.LEADING);
        FlowLayout fl2 = new FlowLayout(FlowLayout.LEADING, 50, 0);

        JPanel panelLists = new JPanel(fl);
        JPanel panelLabels = new JPanel(fl2);
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
        add(panelLabels, BorderLayout.NORTH);
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

                String[] buttons = {"Filter by nodes", "Filter by aircraft type", "Cancel"};
                int rc = JOptionPane.showOptionDialog(null, "Choose the filter", "Filter", JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[0]);
                if (rc == 0) {
                    dialog = new DialogSelectable(ExportCSVUI.this, controller.getListOfOrigins(), "Select origin node");
                    results = controller.getFlightPathAnalisysResultsGroupedByOriginDestination(dialog.getSelectedItem(), "any");
                }
                if (rc == 1) {
                    dialog = new DialogSelectable(ExportCSVUI.this, controller.getListOfOrigins(), "Select aircraft type");
                    results = controller.getFlightPathAnalisysResultsGroupedByAircraftType(dialog.getSelectedItem());
                }

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
                    int nrOfSelectedIndexes = listBest.getSelectedIndices().length + listComparison.getSelectedIndices().length + listShortestPath.getSelectedIndices().length;
                    if (nrOfSelectedIndexes > 4) {
                        JOptionPane.showMessageDialog(rootPane, "Select less than four items to export..", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int selectedIndexes[] = listBest.getSelectedIndices();
                        JFileChooser chooser = new JFileChooser();
                        chooser.showSaveDialog(null);
                        String path = chooser.getCurrentDirectory().getAbsolutePath();
                        for (int i = 0; i < selectedIndexes.length; i++) {
                            controller.exportResult((Result) listBest.getSelectedValue(), path + "\\best_results" + (i + 1) + ".html");
                        }
                        selectedIndexes = listComparison.getSelectedIndices();
                        for (int i = 0; i < selectedIndexes.length; i++) {
                            controller.exportResult((Result) listComparison.getSelectedValue(), path + "\\comparison_results" + (i + 1) + ".html");
                        }
                        selectedIndexes = listShortestPath.getSelectedIndices();
                        for (int i = 0; i < selectedIndexes.length; i++) {
                            controller.exportResult((Result) listShortestPath.getSelectedValue(), path + "\\shortestpath" + (i + 1) + ".html");
                        }

                    }
                }
            }
        });
        return btn;
    }

    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Export HTML", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
}
