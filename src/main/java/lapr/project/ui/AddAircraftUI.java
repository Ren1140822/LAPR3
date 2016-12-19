/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import lapr.project.controller.AddAircraftController;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftUI extends JFrame {

    /**
     * Instance variables
     */
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final String WINDOW_TITLE = "Add aircraft";
    private AddAircraftController addAircraftController;
    private JTextField textRegistration;
    private JTextField textCompany;
    private JTextField textSeatsEcon;
    private JTextField textSeatsCommercial;
    private JTextField textNrOfCrewElements;

    public AddAircraftUI() {
        addAircraftController = new AddAircraftController();
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);

        createComponents();
        this.setVisible(true);

    }

    public void createComponents() {
        JPanel panelLabels = createLabelsPanel();
        JPanel panelText = createTxtFieldPanel();
        add(panelLabels, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
        JButton btnSubmit = createSubmitButton();
        add(btnSubmit, BorderLayout.SOUTH);
    }

    public JPanel createLabelsPanel() {
        GridLayout layout = new GridLayout(5, 1);
        JPanel panel = new JPanel(layout);
        JLabel labelRegistration = createLabels("Registration ID:");
        JLabel labelCompany = createLabels("Company name:");
        JLabel labelSeatsEcon = createLabels("Nr. of seats in economic class:");
        JLabel labelSeatsCommercial = createLabels("Nr. of seats in commercial class:");
        JLabel labelNrOfCrewElements = createLabels("Nr. of crew elements:");
        panel.add(labelRegistration);
        panel.add(labelCompany);
        panel.add(labelSeatsEcon);
        panel.add(labelSeatsCommercial);
        panel.add(labelNrOfCrewElements);

        return panel;
    }

    public JPanel createTxtFieldPanel() {
        GridLayout layout = new GridLayout(5, 1);
        JPanel panel = new JPanel(layout);

        textRegistration = createJTextField();
        textCompany = createJTextField();
        textSeatsEcon = createJTextField();
        textSeatsCommercial = createJTextField();
        textNrOfCrewElements = createJTextField();
        panel.add(textRegistration);
        panel.add(textCompany);
        panel.add(textSeatsEcon);
        panel.add(textSeatsCommercial);
        panel.add(textNrOfCrewElements);
        return panel;
    }

    public JLabel createLabels(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        return label;
    }

    public JTextField createJTextField() {
        JTextField text = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        text.setBorder(border);
        text.setPreferredSize(new Dimension(10, 10));

        return text;
    }

    public JButton createSubmitButton() {
        JButton button = new JButton("Create aircraft");
        button.setPreferredSize(new Dimension(50, 30));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                addAircraftController.createAircraft();
                try {
                    if (addAircraftController.setAircraftData(textRegistration.getText(), textCompany.getText(), Integer.parseInt(textSeatsEcon.getText()), Integer.parseInt(textSeatsCommercial.getText()), Integer.parseInt(textNrOfCrewElements.getText()))) {
                          JOptionPane.showMessageDialog(rootPane, "Aircraft added sucessfully.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Invalid values submitted.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return button;
    }

}
