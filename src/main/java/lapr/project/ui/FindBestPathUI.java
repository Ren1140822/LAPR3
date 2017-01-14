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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lapr.project.controller.FindBestPathController;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author DianaSilva
 */
public class FindBestPathUI extends JDialog {

    /**
     * Guarda a janela anterior
     */
    private final JDialog dialog;

    /**
     * Saves the analysis input data
     */
    private JTextField txtCrew, txtCargoLoad, txtFuelLoad;
    private JComboBox comboFlights;
    /**
     * panel with analysis input data
     */
    private JPanel panelData;

    /**
     * buttons
     */
    private JButton btClean, btBack;

    /**
     * list of aircrafts, list of airports, list of possible destinations
     */
    private JList listStopAirports, listWaypoints;
    private JTextArea flightInfo;

    /**
     * controller
     */
    private transient FindBestPathController controller;

    private transient Project project;

    private int dialogResult = JOptionPane.CANCEL_OPTION;

    private JButton btEco, btFast, btShort;
    private Map<String, Integer> mapConfig;
    private int totalPassengers;
    private DefaultTableModel model;
    private JTable tableCabin;
    private final String[] header = {"Class", "Max Passengers"};

    public FindBestPathUI(Project project, JDialog frame) {
        super(frame, "Find BestPath", true);
        this.project = project;
        this.dialog = frame;

        controller = new FindBestPathController(project);
        controller.newSImulation();

        mapConfig = new HashMap<>();
        totalPassengers = 0;

        createComponents();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        pack();
        setResizable(true);
        setSize(new Dimension(900, 700));
        setLocationRelativeTo(frame);
        setVisible(true);
    }

    private void createComponents() {
        add(createInputPanel(), BorderLayout.CENTER);

        btClean = UI.createButtonClean();
        btBack = UI.createButtonBack();
        buttonBackAddListener();
        buttonCleanAddListener();

        JPanel p = new JPanel(new BorderLayout());
        p.add(UI.createButtonsCleanBackPanel(btClean, btBack), BorderLayout.SOUTH);
        p.add(createPanelFind(), BorderLayout.CENTER);

        add(p, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {

        panelData = new JPanel(new GridLayout(2, 2));

        panelData.setBorder(BorderFactory.createTitledBorder("Simulation Data:"));

        panelData.add(createPanelImage());
        panelData.add(createPanelFlightPlanInfo());
        panelData.add(createPanelInputData());
        panelData.add(createPanelCabinConfig());

        return panelData;
    }

    private JScrollPane createPanelCabinConfig() {

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        model = new DefaultTableModel();
        model.setColumnIdentifiers(header);
        tableCabin = new JTable(model);
        tableCabin.getColumnModel().getColumn(0).setCellRenderer(dtcr);
        tableCabin.getColumnModel().getColumn(1).setCellRenderer(dtcr);
        tableCabin.setEditingColumn(1);
        tableCabin.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrPane = new JScrollPane(tableCabin);

        return scrPane;
    }

    private JPanel createPanelInputData() {
        JPanel pcenter = new JPanel(new GridLayout(4, 1));

        comboFlights = new JComboBox(controller.getFlightPlanList().toArray());
        comboFlights.setSelectedIndex(-1);
        comboFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getFlightPlanSelected((FlightPlan) comboFlights.getSelectedItem());
                listStopAirports.setListData(controller.getTechnicalStops().toArray());
                listWaypoints.setListData(controller.getMandatoryWaypoints().toArray());
                flightInfo.setText(controller.getFlightPlanStringInfo());
                int i = 0;
                if (model.getColumnCount() > 0) {
                    for (i = mapConfig.size() - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }
                }
                mapConfig = controller.getCabinConfig();
                if (mapConfig.size() > 0) {
                    model.fireTableDataChanged();
                    for (Map.Entry<String, Integer> entry : mapConfig.entrySet()) {
                        model.addRow(new Object[]{entry.getKey(), entry.getValue()});
                    }
                    btEco.setEnabled(true);
                    btFast.setEnabled(true);
                    btShort.setEnabled(true);
                }
            }
        });
        txtCrew = new JTextField(10);
        txtCargoLoad = new JTextField(10);
        txtFuelLoad = new JTextField(10);

        pcenter.add(UI.createPanelLabelComboLabel("Flight Plan List", comboFlights, ""));
        pcenter.add(UI.createPanelLabelTextLabel("No.Crew members: ", txtCrew, ""));
        pcenter.add(UI.createPanelLabelTextLabel("Cargo load: ", txtCargoLoad, "Kg"));
        pcenter.add(UI.createPanelLabelTextLabel("Fuel load: ", txtFuelLoad, "Kg"));

        return pcenter;
    }

    private JPanel createPanelFlightPlanInfo() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JPanel pright = new JPanel();
        JPanel pleft = new JPanel();
        JPanel po = new JPanel(new BorderLayout());
        JLabel labelOrigin = UI.createJLabels("Tecnichal Stops:");
        listStopAirports = UI.createJListAirport(new LinkedList<>());
        po.add(labelOrigin, BorderLayout.NORTH);
        po.add(listStopAirports, BorderLayout.CENTER);

        JLabel labelADest = UI.createJLabels("Mandatory Wayoints:");
        labelADest.setPreferredSize(new JLabel("Select destination: ").
                getPreferredSize());
        JPanel pd = new JPanel(new BorderLayout());
        listWaypoints = UI.createJListNodes(new LinkedList<>());

        pd.add(labelADest, BorderLayout.NORTH);
        pd.add(listWaypoints, BorderLayout.CENTER);

        pleft.add(po);
        pright.add(pd);

        flightInfo = new JTextArea();
        flightInfo.setPreferredSize(new Dimension(150, 100));

        panel.add(flightInfo);
        panel.add(pleft);
        panel.add(pright);
        return panel;
    }

    private JPanel createPanelFind() {
        JPanel p = new JPanel();

        int aux = 2;
        JPanel imports = new JPanel(new GridLayout(1, 4, aux, aux));
        imports.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Simulate:"), new EmptyBorder(aux, aux, aux, aux)));
        imports.add(createButtonShortest());
        imports.add(createButtonFastest());
        imports.add(createButtonEcologic());

        p.add(imports);

        return p;
    }

    private JPanel createPanelImage() {
        ImageIcon background = new ImageIcon("src/main/resources/images/path.jpg");

        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(5, 10, 5, 10));
        p.add(label, BorderLayout.CENTER);

        return p;
    }

    public void buttonCleanAddListener() {
        btClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCrew.setText("");
                txtCargoLoad.setText("");
                txtFuelLoad.setText("");
            }
        });
    }

    public void buttonBackAddListener() {
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }

    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window and discard Find Best Path?";
        int opcao = JOptionPane.showOptionDialog(dialog, question,
                "Find Best Path", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private JButton createButtonShortest() {
        Icon icone = new ImageIcon("src/main/resources/images/shortest.png");
        btShort = new JButton("Find Shortest Path", icone);
        btShort.setContentAreaFilled(false);
        btShort.setBorderPainted(false);
        btShort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btShort.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btShort.setMnemonic(KeyEvent.VK_S);
        btShort.setEnabled(false);
        btShort.setToolTipText("Please insert origin and destination airports");
        btShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createSimulation(TypePath.SHORTEST_PATH)) {
                    openResultWindow(TypePath.SHORTEST_PATH);
                } else {
                    JOptionPane.showMessageDialog(FindBestPathUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        return btShort;
    }

    private JButton createButtonFastest() {
        Icon icone = new ImageIcon("src/main/resources/images/fastest.png");
        btFast = new JButton("Find Fastest Path", icone);
        btFast.setContentAreaFilled(false);
        btFast.setBorderPainted(false);
        btFast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFast.setMnemonic(KeyEvent.VK_F);
        btFast.setEnabled(false);
        btFast.setToolTipText("Please insert origin and destination airports");
        btFast.addActionListener((ActionEvent e) -> {
            if (createSimulation(TypePath.FASTEST_PATH)) {
                openResultWindow(TypePath.FASTEST_PATH);
            } else {
                JOptionPane.showMessageDialog(FindBestPathUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return btFast;
    }

    private JButton createButtonEcologic() {
        Icon icone = new ImageIcon("src/main/resources/images/ecologic.png");
        btEco = new JButton("Find Ecologic Path", icone);
        btEco.setContentAreaFilled(false);
        btEco.setBorderPainted(false);
        btEco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEco.setMnemonic(KeyEvent.VK_E);
        btEco.setEnabled(false);
        btEco.setToolTipText("Please insert all data");
        btEco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (createSimulation(TypePath.ECOLOGIC_PATH)) {
                        openResultWindow(TypePath.ECOLOGIC_PATH);
                    } else {
                        JOptionPane.showMessageDialog(FindBestPathUI.this, "Data is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (java.lang.UnsupportedOperationException en) {
                    JOptionPane.showMessageDialog(FindBestPathUI.this,
                            "It wasn´t possible to create simulation", "Error", JOptionPane.ERROR_MESSAGE);
                    throw en;
                }
            }
        });
        return btEco;
    }

    private void openResultWindow(TypePath type) {
        FindBestPathResultUI result = new FindBestPathResultUI(controller.getSimulation(), type, FindBestPathUI.this);
    }

    private boolean validateData() {
        return !txtCargoLoad.getText().isEmpty()
                && !txtCrew.getText().isEmpty()
                && !txtFuelLoad.getText().isEmpty();
    }

    private void setData() {
        try {
            totalPassengers = 0;
            for (int i = 0; i <= tableCabin.getRowCount() - 1; i++) {
                totalPassengers += Integer.parseInt(tableCabin.getValueAt(i, 1).toString());
            }
            if (validateData()) {
                try {
                    int crew = Integer.parseInt(txtCrew.getText());
                    double cargo = Double.parseDouble(txtCargoLoad.getText());
                    double fuel = Double.parseDouble(txtFuelLoad.getText());
                    controller.setData(totalPassengers, crew, cargo, fuel);
                } catch (NumberFormatException ne1) {
                    JOptionPane.showMessageDialog(dialog, "Field invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println(ne1.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Fill all fields, please!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ne2) {
            JOptionPane.showMessageDialog(dialog, "Max Passengers fields invalid!", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(ne2.getMessage());
        }
    }

    private boolean createSimulation(TypePath type) {
        controller.createBestPathSimulation(type);
        setData();
        return controller.saveSimulation();
    }
}
