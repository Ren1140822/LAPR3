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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lapr.project.controller.AddAircraftController;
import lapr.project.model.Project;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftUI extends JDialog {

    Project project;
    /**
     * Instance variables
     */
    private final int WINDOW_WIDTH = 900;
    private final int WINDOW_HEIGHT = 600;
    private final String WINDOW_TITLE = "Add aircraft";
    private transient AddAircraftController addAircraftController;
    private JTextField textRegistration;
    private JTextField textCompany;
    private JTextField textAircraftModel;
    private JTextField textNrOfCrewElements;  
    private JTable listclasses;    
    private DialogSelectable dialog;
    private JButton btnSubmit;
    private JButton btnClass;
    private JDialog parentFrame;
    private final String[] clHeader = {"Class", "Max Passengers"};
    private DefaultTableModel model;
    private static final Dimension LABEL_SIZE = new JLabel("Nr. of crew elements: ").
                                                        getPreferredSize();
    private Map<String, Integer> mapConfig;

    public AddAircraftUI(Project project, JDialog parentFrame) {
        super(parentFrame, "Add Aircraft", true);
        this.parentFrame = parentFrame;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
        this.project = project;
        addAircraftController = new AddAircraftController(project);
        mapConfig = new HashMap<>();
        
        this.setTitle(WINDOW_TITLE);
        
        createComponents();
        
        pack();
        setResizable(false);
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));        
        setLocationRelativeTo(parentFrame);        
        this.setVisible(true);
    }

    private void createComponents() {
        add(createPanelNorth(), BorderLayout.NORTH);
        add(createPanelCenter(), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout());
        btnSubmit = createSubmitButton();
        btnClass = createAddClassButton();
        JButton btnModel = createAddAircraftModelButton();
        buttons.add(btnModel);
        buttons.add(btnClass);
        buttons.add(btnSubmit);

        add(buttons, BorderLayout.SOUTH);
    }

    private JPanel createPanelNorth() {
        ImageIcon background = new ImageIcon("src/main/resources/images/aircraft_large.jpg");

        JLabel label = new JLabel();
        label.setIcon(background);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(5, 10, 5, 10));
        p.add(label, BorderLayout.CENTER);

        return p;
    }

    private JPanel createPanelLabelText() {
        JPanel p = new JPanel(new GridLayout(4, 1));
        
        p.setBorder(new TitledBorder("Aircarft:"));
        
        textRegistration = new JTextField(10);
        textCompany = new JTextField(10);
        textNrOfCrewElements = new JTextField(10);
        textAircraftModel = new JTextField(10);        
        textAircraftModel.setEditable(false);
        
        p.add(createPanelLabelText("Registration ID: ", textRegistration));
        p.add(createPanelLabelText("Company name: ", textCompany));
        p.add(createPanelLabelText("Nr. of crew elements: ", textNrOfCrewElements));
        p.add(createPanelLabelText("Aircarft Model: ", textAircraftModel));
        
        
        
        return p;
    }
    private JPanel createPanelLabelText(String label1, JTextField text) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_SIZE);
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(lb1);
        p.add(text);

        return p;
    }
    
    private JScrollPane createClasses(){

        model = new DefaultTableModel();
        model.setDataVector(new Object[1][1], clHeader);  
        listclasses = new JTable(model);
        listclasses.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        listclasses.setEnabled(false);        
        
        JScrollPane scrPane = new JScrollPane(listclasses);
        
        return scrPane;
    }
    
    private JPanel createPanelCenter(){
        JPanel p = new JPanel(new GridLayout(1,2));
        
        p.add(createPanelLabelText());
        p.add(createClasses());
        
        return p;
    }
    
    private JButton createSubmitButton() {
        JButton button = new JButton("Create aircraft");
        button.setPreferredSize(new Dimension(170, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (addAircraftController.setAircraftData(textRegistration.getText(), textCompany.getText(), mapConfig, Integer.parseInt(textNrOfCrewElements.getText())) && addAircraftController.hasModel() && !mapConfig.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Aircraft added sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException | NullPointerException ex) {
                    System.err.print(ex);
                    JOptionPane.showMessageDialog(rootPane, "Invalid values submitted or no valid model/cabin configuration set for this aircraft.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        button.setEnabled(false);
        return button;
    }

    private JButton createAddAircraftModelButton() {
        JButton button = new JButton("Insert aicraft model");
        button.setPreferredSize(new Dimension(170, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAircraftController.createAircraft();
                dialog = new DialogSelectable(AddAircraftUI.this, addAircraftController.getListOfAircraftModels(), "Select aircraft model");
                if (addAircraftController.setAircraftModel(dialog.getSelectedItem())) {
                    textAircraftModel.setText(dialog.getSelectedItem());
                    JOptionPane.showMessageDialog(rootPane, "Model set sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    btnClass.setEnabled(true);
                }
            }
        });        
        return button;
    }

    private JButton createAddClassButton() {
        JButton button = new JButton("Insert class info");
        button.setPreferredSize(new Dimension(170, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                try {
                    String className = JOptionPane.showInputDialog("Please insert a name for the class.");
                    int classSeats = Integer.parseInt(JOptionPane.showInputDialog("Please insert the number of seats for this class."));                    
                    if (!Pattern.matches("[0-9]+", className)) {
                        mapConfig.put(className, classSeats);  
                        model.setDataVector(new Object[0][0], clHeader);                        
                        model.setColumnIdentifiers(clHeader);
                        for (Map.Entry<String,Integer> entry : mapConfig.entrySet()){
                            model.addRow(new Object[] {entry.getKey(), entry.getValue()});
                        }
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setHorizontalAlignment(JLabel.CENTER);
                        listclasses.getColumnModel().getColumn(0).setCellRenderer(dtcr);
                        listclasses.getColumnModel().getColumn(1).setCellRenderer(dtcr);
                        JOptionPane.showMessageDialog(rootPane, "Data saved to this aircraft sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        btnSubmit.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid values submitted for number of class name, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Invalid values submitted for number of seats, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button.setEnabled(false);
        return button;
    }

    private void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Add aircraft", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
}
