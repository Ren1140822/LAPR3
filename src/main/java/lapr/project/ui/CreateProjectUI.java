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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.CreateProjectController;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class CreateProjectUI extends JDialog {
    
    private Project project;
    private transient CreateProjectController controller;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtDescription;
    private static final Dimension LABEL_SIZE = new JLabel("DESCRIPTION: ", JLabel.RIGHT).getPreferredSize();
    private JButton create;
    private JButton clean;
    private JButton back;
    private JButton importdata;
    
    public CreateProjectUI(JFrame frame){
        
        super(frame, "Create Project", true);    
        
        controller = new CreateProjectController();
        
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
    
    private void createComponents(){
                
        add(createPanelImage(), BorderLayout.NORTH);
        add(createPanel(), BorderLayout.CENTER);
        add(createPanelOp(), BorderLayout.SOUTH);
    }
    
    private JPanel createPanelImage(){
        ImageIcon im = new ImageIcon("src/main/resources/images/projectfolder.png");
        
        JLabel label = new JLabel();
        label.setIcon(im);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(label, BorderLayout.CENTER);

        return p;
    }
    
    private JPanel createPanel(){
        txtId = new JTextField(30);
        txtId.setEditable(false);
        txtName = new JTextField(30);
        txtDescription = new JTextField(30);
        
        JPanel p = new JPanel(new GridLayout(3, 1, 20, 20));
        
        p.add(createPanelLabelText("ID:", txtId));
        p.add(createPanelLabelText("Name:", txtName));
        p.add(createPanelLabelText("Description:", txtDescription));
        
        return p;
    }
    
    /**
     * create panel to label1, text and label2
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
    
    private JPanel createPanelOp(){

        JPanel p = new JPanel();        
        
        p.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(
                "Options:"), new EmptyBorder(30, 30, 30, 30)));
        
        getRootPane().setDefaultButton(createButtonCreate());
        
        p.add(createButtonCreate());
        p.add(createButtonImportData());
        p.add(createButtonClean());
        p.add(createButtonBack());
        
        return p; 
    }
    
    private JButton createButtonClean(){
        clean = new JButton("Clean"); 
        clean.setMnemonic(KeyEvent.VK_C);
        clean.setToolTipText("Clean all fields");
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean();
            }
        });
        return clean;
    }
    
    private JButton createButtonImportData(){
        importdata = new JButton("Import Data"); 
        importdata.setEnabled(false);
        importdata.setMnemonic(KeyEvent.VK_I);
        importdata.setToolTipText("Import data");
        importdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importdata();
            }
        });
        return importdata;
    }
    
    private JButton createButtonCreate(){
        create = new JButton("Create Project"); 
        create.setMnemonic(KeyEvent.VK_P);
        create.setToolTipText("Create Project");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        return create;
    }
    
    private JButton createButtonBack(){
        back = new JButton("Back"); 
        back.setMnemonic(KeyEvent.VK_B);
        back.setToolTipText("Back and cancel new Project");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.hasProjectCreated()){
                    JOptionPane.showMessageDialog(
                    null,
                    "New Project created:\n\nName: \n"
                            + project.getName()
                            + "\nDescription: \n" 
                            + project.getDescription(),
                    "Create Project",
                    JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }else{
                    closeWindow();
                }                
            }
        });
        return back;
    }
    private void closeWindow(){
            String[] op = {"Yes", "No"};
            String question = "Cancel create project?";
            int opcao = JOptionPane.showOptionDialog(CreateProjectUI.this, question,
                    this.getTitle(), JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            if (opcao == JOptionPane.YES_OPTION) {
                finish();
            } else {
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
    }
    
    private boolean create(){
        if (txtName.getText().isEmpty() || txtDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Check all data project, please!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            if(controller.setProject(txtName.getText(), txtDescription.getText())){
                project = controller.getProject();
                importdata.setEnabled(true);
                create.setEnabled(false);
                clean.setEnabled(false);
                txtName.setEditable(false);
                txtDescription.setEditable(false);
                JOptionPane.showMessageDialog(
                    null,
                    "Project created sucessfuly!",
                    "Create Project",
                    JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "It was not possible create new project!",
                    "Create Project",
                    JOptionPane.ERROR_MESSAGE);                
            }            
        }
        
        return true;
    }
    
    private void clean(){
        txtName.setText("");
        txtDescription.setText("");
    }
    
    private void importdata(){ 
        ImportDataUI imp = new ImportDataUI(project, CreateProjectUI.this);        
    }
    
    private void finish() {
        dispose();
    }
    
}
