/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import lapr.project.controller.ComparisonController;
import lapr.project.model.Project;
import lapr.project.model.analysis.Simulation;

/**
 *
 * @author Diana Silva
 */
public class ResultCompareUI extends JDialog{
     private JDialog frame;
    
    private Project project;
    private transient ComparisonController controller;

    private final int WINDOW_WIDTH = 850;
    private final int WINDOW_HEIGHT = 600;
    private final String WINDOW_TITLE = "Compare Results";
    private JPanel pTable;
    private DialogSelectable dialog;
    private DefaultTableModel model;
    
    public ResultCompareUI(ComparisonController controller, JDialog frame){
        super(frame, "Compare Options", true);
        this.frame = frame;
        this.controller=controller;
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        setLocationRelativeTo(frame);
        this.setResizable(false);
   
        createComponents();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }
    
    private void createComponents(){
        add(createTablePanel());
    }
   
        
    private JPanel createTablePanel(){
        pTable=new JPanel();   
        pTable.setLayout(new BorderLayout());
        pTable.setBorder(new TitledBorder("Comparison Results:"));
        pTable.add(createTable(), BorderLayout.NORTH);
        return pTable;    
    } 
    
    
    private JTable createTable(){     
        String[] column={"DISTANCE", "","", "TIMEFLIGHT","","","FUEL","",""};
                 
         model=new DefaultTableModel(){
            
            @Override
            public int getColumnCount(){
                return column.length; 
            }
            
            @Override
            public String getColumnName(int index){
                return column[index];
            } 
           
        };
        
        model.addColumn(column);
        
        JTable table = new JTable(model);  
       
        //Add the scroll pane to this panel.
        pTable.add(new JScrollPane(table));
        fillTable();
       
        return table;
    }
    
    private void fillTable(){ 
       String[] column={"DISTANCE", "","", "TIMEFLIGHT","","","FUEL","",""};
        model.addRow(column);
       
      
        for(Simulation s: controller.getListSimulations()){
             String[] columnNames={"Shortest", "Fastest", "Ecologic","Shortest", "Fastest", "Ecologic","Shortest", "Fastest", "Ecologic"};
       
            model.addRow(columnNames);
            model.addRow(controller.getResults(s));
           
        } 
        controller.calculateAverage();
        model.addRow(controller.getAverages());
        String[] dif={"DifShortest", "DifFastest", "DifEcologic","Shortest", "Fastest", "Ecologic","Shortest", "Fastest", "Ecologic"};
        model.addRow(dif);
        model.addRow(controller.getDifAvg());
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
