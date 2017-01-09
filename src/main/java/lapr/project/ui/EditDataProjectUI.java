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
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtDescription;
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
        setResizable(false);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });

    }

    private void createComponents() {

        add(createPanelImage(), BorderLayout.NORTH);
        add(createPanel(), BorderLayout.CENTER);
        add(createPanelOp(), BorderLayout.SOUTH);
    }

    private JPanel createPanelImage() {
        ImageIcon im = new ImageIcon("src/main/resources/images/projectfolder.png");

        JLabel l = new JLabel();
        l.setIcon(im);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(l, BorderLayout.CENTER);

        return p;
    }

    private JPanel createPanel() {
        txtId = new JTextField(String.valueOf(controller.getIdProject()), 30);
        txtId.setEditable(false);
        txtName = new JTextField(controller.getNameProject(), 30);
        txtName.setEditable(false);
        txtDescription = new JTextField(controller.getDescriptionProject(), 30);
        txtDescription.setEditable(false);

        JPanel p = new JPanel(new GridLayout(3, 1, 20, 20));

        p.add(createPanelLabelText("ID:", txtId));
        p.add(createPanelLabelText("Name:", txtName));
        p.add(createPanelLabelText("Description:", txtDescription));

        return p;
    }

    /**
     * create panel to label1, text and label2
     *
     * @param label1 label1
     * @param texto text
     * @return painel
     */
    private JPanel createPanelLabelText(String label1, JTextField text) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_SIZE);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        p.add(lb1);
        p.add(text);

        return p;
    }

    private JPanel createPanelOp() {

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
                txtName.setEditable(true);
                txtDescription.setEditable(true);
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
        back.setMnemonic(KeyEvent.VK_B);
        back.setToolTipText("Back and cancel new Project");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        return back;
    }

    private void save() {
        if (txtName.getText().isEmpty() || txtDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Check all data project, please!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            controller.setDataProject(txtName.getText(), txtDescription.getText());
            dispose();            
        }
    }

    private void closeWindow() {
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
        txtName.setText(controller.getNameProject());
        txtDescription.setText(controller.getDescriptionProject());
    }

    private void back() {
        dispose();
    }

}
