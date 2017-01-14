/**
 * Package location for UI components classes.
 */
package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * Represents a dialog to choose a selectable.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DialogSelectable extends JDialog {

    /**
     * The parent JDialog.
     */
    private final JDialog parentDialog;

    /**
     * The selected object.
     */
    private String selectable;

    /**
     * The Selectables list.
     */
    private final List<String> selectablesList;

    /**
     * The Selectables JList.
     */
    private JList<Object> selectablesJList;

    /**
     * The select button.
     */
    private JButton selectButton;

    /**
     * Text to be shown on the top of the list.
     */
    private final String chooseText;

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "Choose from list";

    /**
     * Default text to be shown on the top of the list.
     */
    private static final String DEFAULT_CHOOSE_TEXT = "Please choose from the list:";

    /**
     * Padding border.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of choose selectable dialog.
     *
     * @param parentDialog
     * @param list the list of selectables
     */
    public DialogSelectable(JDialog parentDialog, List<String> list) {
        super(parentDialog, WINDOW_TITLE, true);

        this.parentDialog = parentDialog;
        this.selectablesList = list;
        this.chooseText = DEFAULT_CHOOSE_TEXT;

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentDialog);
        setVisible(true);
    }

    /**
     * Creates an instance of choose selectable dialog.
     *
     * @param parentDialog
     * @param list selectables list
     * @param chooseText text to be shown on the top of the list
     */
    public DialogSelectable(JDialog parentDialog, List<String> list, String chooseText) {
        super(parentDialog, WINDOW_TITLE, true);

        this.parentDialog = parentDialog;
        this.selectablesList = list;
        this.chooseText = chooseText;

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(parentDialog);
        setVisible(true);
    }

    /**
     * Creates the UI components to this dialog.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(0, 10));
        componentsPanel.add(createChooseTextLabel(), BorderLayout.NORTH);
        componentsPanel.add(createListPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the top label with the text to choose a selectable.
     *
     * @return choose selectable JLabel
     */
    private JLabel createChooseTextLabel() {
        return new JLabel(this.chooseText, SwingConstants.CENTER);
    }

    /**
     * Creates the list panel
     *
     * @return list panel
     */
    private Component createListPanel() {
        JPanel listPanel = new JPanel(new BorderLayout());

        this.selectablesJList = new JList();
        this.selectablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       this.selectablesJList.setListData(selectablesList.toArray());

        this.selectablesJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                DialogSelectable.this.selectButton.setEnabled(!DialogSelectable.this.selectablesJList.isSelectionEmpty());
            }
        });

        JScrollPane jScrollPane = new JScrollPane(this.selectablesJList);
        listPanel.add(jScrollPane, BorderLayout.CENTER);

        return listPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private Component createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createSelectButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the select button.
     *
     * @return select button
     */
    private JButton createSelectButton() {
        this.selectButton = new JButton("Select");
        this.selectButton.setEnabled(false);

        this.selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogSelectable.this.selectable = (String) DialogSelectable.this.selectablesList
                        .get(DialogSelectable.this.selectablesJList.getSelectedIndex());
                dispose();
            }
        });
        
        this.rootPane.setDefaultButton(selectButton);

        return this.selectButton;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogSelectable.this.selectable = null;
                dispose();
            }
        });

        return cancelButton;
    }

    /**
     * Gets the selected item.
     *
     * @return selected item
     */
    public String  getSelectedItem() {
        return this.selectable;
    }
}
