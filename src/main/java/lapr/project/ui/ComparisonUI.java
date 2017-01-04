/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lapr.project.controller.ComparisonController;
import lapr.project.model.Project;

/**
 *
 * @author Diana Silva
 */
public class ComparisonUI extends JDialog{
     private JDialog frame;
    
    private Project project;
    private transient ComparisonController controller;

    private final int WINDOW_WIDTH = 850;
    private final int WINDOW_HEIGHT = 600;
    private final String WINDOW_TITLE = "Compare Results";
    private DialogSelectable dialog;
    
    public ComparisonUI(Project project, JDialog frame){
        super(frame, "Compare Results", true);
        this.project = project;
        this.frame = frame;
        this.controller=new ComparisonController(project);
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        setLocationRelativeTo(frame);
        this.setResizable(false);
   
        createOptions();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }
    
    private void createOptions(){
        String[] buttons = controller.getComparisonOptions();
        int rc = JOptionPane.showOptionDialog(null, "Choose the filter", "Filter", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        if (rc == 0) {
            dialog = new DialogSelectable(this, controller.getAircraftsSimulated(), "Select aircraft type");
            String option = dialog.getSelectedItem();
            controller.createComparison();
            controller.setAircraft(option);
            ResultCompareUI ui=new ResultCompareUI(controller, frame);
        }
        if (rc == 1) {
            

        }
    }

    public void closeWindow() {
        String[] op = {"Yes", "No"};
        String question = "Close window?";
        int opcao = JOptionPane.showOptionDialog(this, question,
                "Comparison Results", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
}