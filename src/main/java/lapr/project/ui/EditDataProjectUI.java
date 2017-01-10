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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.EditDataProjectController;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class EditDataProjectUI extends JDialog {

    private Project project;
    private transient EditDataProjectController controller;
    private JDialog dialog;
    private JTextField txtIdProj;
    private JTextField txtNameProj;
    private JTextField txtDescProj;
    private static final Dimension LABEL_SIZE = new JLabel("DESCRIPTION: ", JLabel.RIGHT).getPreferredSize();
    private JButton save;
    private JButton edit;
    private JButton clean;
    private JButton back;

    public EditDataProjectUI(Project project, JDialog dialog) {

        super(dialog, "Edit Data Project -> ID: " + project.getIdProject(), true);

        this.dialog = dialog;
        this.project = project;

        controller = new EditDataProjectController(project);

        createComponents();

        pack();        
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWind();
            }
        });

    }

    private void createComponents() {

        add(createPanelNorth(), BorderLayout.NORTH);
        add(createPanelCenter(), BorderLayout.CENTER);
        add(createPanelSouth(), BorderLayout.SOUTH);
    }

    private JPanel createPanelNorth() {
        ImageIcon im = new ImageIcon("src/main/resources/images/projectfolder.png");

        JLabel l = new JLabel();
        l.setIcon(im);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(l, BorderLayout.CENTER);

        return p;
    }

    private JPanel createPanelCenter() {
        txtIdProj = new JTextField(String.valueOf(controller.getIdProject()), 30);
        txtIdProj.setEditable(false);
        txtNameProj = new JTextField(controller.getNameProject(), 30);
        txtNameProj.setEditable(false);
        txtDescProj = new JTextField(controller.getDescriptionProject(), 30);
        txtDescProj.setEditable(false);

        JPanel p = new JPanel(new GridLayout(3, 1, 20, 20));

        p.add(createPanelLabelText("ID:", txtIdProj));
        p.add(createPanelLabelText("Name:", txtNameProj));
        p.add(createPanelLabelText("Description:", txtDescProj));

        return p;
    }

    /**
     * create panel to label1, text and label2
     *
     * @param lab label1
     * @param texto text
     * @return painel
     */
    private JPanel createPanelLabelText(String lab, JTextField text) {
        JLabel l = new JLabel(lab, JLabel.RIGHT);
        l.setPreferredSize(LABEL_SIZE);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(l);
        p.add(text);

        return p;
    }

    private JPanel createPanelSouth() {

        JPanel p = new JPanel();

        p.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(30, 30, 30, 30)));

        getRootPane().setDefaultButton(createButtonSave());

        p.add(createButtonEdit());
        p.add(createButtonSave());
        p.add(createButtonClean());
        p.add(createButtonBack());

        return p;
    }

    private JButton createButtonSave() {
        save = new JButton("Save Project");
        save.setMnemonic(KeyEvent.VK_S);
        save.setToolTipText("Save Project");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        save.setEnabled(false);
        return save;
    }

    private JButton createButtonEdit() {
        edit = new JButton("Edit Project");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.setToolTipText("Edit Project");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNameProj.setEditable(true);
                txtDescProj.setEditable(true);
                save.setEnabled(true);
                edit.setEnabled(false);
            }
        });
        return edit;
    }

    private JButton createButtonClean() {
        clean = new JButton("Restore");
        clean.setMnemonic(KeyEvent.VK_R);
        clean.setToolTipText("Restore values of the project");
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restore();
            }
        });
        return clean;
    }

    private JButton createButtonBack() {
        back = new JButton("Back");        
        back.setToolTipText("Back and cancel new Project");
        back.setMnemonic(KeyEvent.VK_B);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWind();
            }
        });
        return back;
    }

    private void save() {
        if (txtNameProj.getText().isEmpty() || txtDescProj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Check all data project, please!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            controller.setDataProject(txtNameProj.getText(), txtDescProj.getText());
            JOptionPane.showMessageDialog(
                    null,
                    "Project edited sucessfully!",
                    "Edit Data Project",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();            
        }
    }

    private void closeWind() {
        String[] op = {"Yes", "No"};
        String question = "Cancel edit data project?";
        int opcao = JOptionPane.showOptionDialog(EditDataProjectUI.this, question,
                this.getTitle(), JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            back();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void restore() {
        txtNameProj.setText(controller.getNameProject());
        txtDescProj.setText(controller.getDescriptionProject());
    }

    private void back() {
        dispose();
    }

}
