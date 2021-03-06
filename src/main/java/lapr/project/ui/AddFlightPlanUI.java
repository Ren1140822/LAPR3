/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import lapr.project.controller.AddFlightPlanController;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class AddFlightPlanUI extends JDialog {

    private Project project;
    private JFileChooser fileChooser;
    private transient AddFlightPlanController controller;
    /**
     * Guarda a janela anterior
     */
    private JDialog dialog;
    private JTextField txtDesignator;
    private JTextField txtMinStop;
    private JList listAirOri;
    private JList listAirDest;
    private JList listAirStop;
    private JList listNodes;
    private JList listAircraft;
    private JButton backBtn;
    private JButton okBtn;
    private JButton cleanBtn;
    private JButton addAircraftBtn;
    private JButton importPatternBtn;

    public AddFlightPlanUI(Project project, JDialog dialog) {
        super(dialog, "Add Flight Plan: ", true);

        this.project = project;
        this.dialog = dialog;
        controller = new AddFlightPlanController(project);

        if (controller.getAircraftsModelList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Aircraft List is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else if (controller.getAirportList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Airport List is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else if (controller.getNodeList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Airnetwork is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        } else {

            createComponents();

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    close();
                }
            });

            pack();
            setResizable(false);
            setSize(new Dimension(900, 600));
            setLocationRelativeTo(dialog);
            setVisible(true);
        }
    }

    private void createComponents() {

        add(createPanelNorth(), BorderLayout.NORTH);
        add(createPanelLists(), BorderLayout.CENTER);
        add(createPanelButons(), BorderLayout.SOUTH);

    }

    private JPanel createPanelNorth() {
        ImageIcon background = new ImageIcon("src/main/resources/images/flight_large.png");

        JLabel label = new JLabel(background, JLabel.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(label, BorderLayout.CENTER);
        p.add(createPanelAircraftData(), BorderLayout.SOUTH);

        return p;
    }

    private JPanel createPanelAircraftData() {
        JPanel p = new JPanel(new GridLayout(1, 3));

        p.setBorder(new TitledBorder("Aircarft Data: "));

        txtDesignator = new JTextField(10);
        txtMinStop = new JTextField(10);

        p.add(UI.createPanelLabelTextLabel("Flight Designator: ", txtDesignator, ""));
        p.add(UI.createPanelLabelTextLabel("Min Stop Time: ", txtMinStop, "(Optional)"));

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(createButtonImportPattern());

        p.add(p2);

        return p;
    }

    private JPanel createPanelLists() {
        JPanel p = new JPanel(new GridLayout(1, 5, 5, 5));

        String l1 = "Aircrafts";
        String l2 = "Origin Airport";
        String l3 = "Destination Airport";
        String l4 = "Technical Stops";
        String l5 = "Mandatory Nodes";

        listAirOri = new JList(controller.getAirportList().toArray());
        listAirDest = new JList(new LinkedList().toArray());
        listAirStop = new JList(new LinkedList().toArray());
        listNodes = new JList(new LinkedList().toArray());
        listAircraft = new JList(controller.getAircraftsList().toArray());

        p.add(createPanelListButton(l1, listAircraft, createButtonAddAircraft()));
        p.add(createPanelList(l2, listAirOri));
        p.add(createPanelList(l3, listAirDest));
        p.add(createPanelList(l4, listAirStop));
        p.add(createPanelList(l5, listNodes));

        listAirOri.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        String s = listAirOri.getSelectedValue().toString();
                        listAirDest.setListData(controller.getPossibleEndAirportsByAirportID(s).toArray());
                        listAirStop.setListData(controller.getPossibleEndAirportsByAirportID(s).toArray());
                        listNodes.setListData(controller.getPossibleEndNodesByAirportId(s).toArray());
                    }
                } catch (NullPointerException ex) {
                    System.err.println(ex);
                }
            }
        });

        listAirStop.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listNodes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        return p;
    }

    private JPanel createPanelList(String title, JList jlist) {

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(jlist);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(title),
                new EmptyBorder(5, 5, 5, 5)));

        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel createPanelListButton(String title, JList jlist, JButton btn) {

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(jlist);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(title),
                new EmptyBorder(5, 5, 5, 5)));

        p.add(scrPane, BorderLayout.CENTER);
        p.add(btn, BorderLayout.SOUTH);

        return p;
    }

    private JPanel createPanelButons() {
        int aux = 10;
        JPanel pback = new JPanel();
        pback.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(aux, aux, aux, aux)));
        pback.add(createButtonOk());
        pback.add(createButtonClean());
        pback.add(createButtonBack());

        return pback;
    }

    private JButton createButtonBack() {
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

    private JButton createButtonImportPattern() {
        importPatternBtn = new JButton("Import Pattern");
        importPatternBtn.setMnemonic(KeyEvent.VK_I);
        importPatternBtn.setToolTipText("Import");
        importPatternBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                defineFilterExtCSV(fileChooser);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setCurrentDirectory(new File("src/main/resources"));
                int resposta = fileChooser.showOpenDialog(AddFlightPlanUI.this);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (controller.pattern(file)) {
                        JOptionPane.showMessageDialog(AddFlightPlanUI.this,
                                "Pattern List imported successfully!",
                                "Import Pattern",
                                JOptionPane.INFORMATION_MESSAGE);
                        okBtn.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(AddFlightPlanUI.this,
                                "Pattern List was not imported successfully",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        return importPatternBtn;
    }

    private JButton createButtonAddAircraft() {
        addAircraftBtn = new JButton("Add Aircraft");
        addAircraftBtn.setMnemonic(KeyEvent.VK_A);
        addAircraftBtn.setToolTipText("Add Aircraft");
        addAircraftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAircraftUI addaircraft = new AddAircraftUI(project, AddFlightPlanUI.this);
                listAircraft.setListData(controller.getAircraftsList().toArray());
            }
        });
        return addAircraftBtn;
    }

    private JButton createButtonClean() {
        cleanBtn = new JButton("Clean");
        cleanBtn.setMnemonic(KeyEvent.VK_C);
        cleanBtn.setToolTipText("Clean");
        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDesignator.setText("");
                txtMinStop.setText("");
                listAirDest.clearSelection();
                listAirOri.clearSelection();
                listAirStop.clearSelection();
                listAircraft.clearSelection();
                listNodes.clearSelection();
            }
        });
        return cleanBtn;
    }

    private JButton createButtonOk() {
        okBtn = new JButton("Ok");
        okBtn.setMnemonic(KeyEvent.VK_O);
        okBtn.setToolTipText("Ok");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm();
            }
        });
        okBtn.setEnabled(false);
        return okBtn;
    }

    private void close() {
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Add Flight Plan?";
        int opcao = JOptionPane.showOptionDialog(dialog, question,
                "Add Flight Plan", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void confirm() {
        try {
            if (!txtDesignator.getText().isEmpty()) {
                String desig = txtDesignator.getText();
                int minstop = 0;
                if (!txtMinStop.getText().isEmpty()) {
                    minstop = Integer.parseInt(txtMinStop.getText());
                }
                String aircraft = listAircraft.getSelectedValue().toString();
                String airOr = listAirOri.getSelectedValue().toString();
                String airDes = listAirDest.getSelectedValue().toString();

                int stopind[] = listAirStop.getSelectedIndices();
                int nodeind[] = listNodes.getSelectedIndices();
                Object stops[] = (Object[]) listAirStop.getSelectedValuesList().toArray(new Object[stopind.length]);
                Object waypoints[] = (Object[]) listNodes.getSelectedValuesList().toArray(new Object[nodeind.length]);

                controller.setData(desig, minstop, aircraft, airOr, airDes, stops, waypoints);

                if (controller.saveFlightPlan()) {
                    finish();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "It was not possible to add flight plan!\n",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Flight Designator is empty!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Check all flight plan data, please!\n",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        } catch (NullPointerException exx) {
            JOptionPane.showMessageDialog(
                    null,
                    "Check if you have selected aircraft, origin or destiantion, please!\n",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(exx);
        }
    }

    private void finish() {
        JOptionPane.showMessageDialog(
                null,
                "Flight Plan added successfully!",
                "Add Flight Plan",
                JOptionPane.INFORMATION_MESSAGE);
        String[] op = {"Yes", "No"};
        String question = "Save flight Plan in data base?";
        int opcao = JOptionPane.showOptionDialog(AddFlightPlanUI.this, question,
                "Save Flight Plan?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            save();
        } else {
            dispose();
        }
    }

    private void save() {
        //implement save on data base
        dispose();
    }

    private void defineFilterExtCSV(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String ext = ext(f);
                if (ext != null) {
                    return ext.equals("csv");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.csv";
            }

            private String ext(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }

}
