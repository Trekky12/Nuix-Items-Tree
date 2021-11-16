package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import nuix.Case;
import org.apache.log4j.Logger;

public class NuixItemsTree extends javax.swing.JFrame {

    private final static Logger logger = Logger.getLogger(NuixItemsTree.class);

    private final SettingsDialog settingsDialog = new SettingsDialog(this, false);

    public NuixItemsTree(Case nuixCase) {
        logger.info("Starting Nuix Items Tree");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuix Items Tree");

        InvestigatePanel investigatePanel = new InvestigatePanel(nuixCase);
        setContentPane(investigatePanel);
        setMinimumSize(investigatePanel.getMinimumSize());

        JMenuBar mainMenuBar = new JMenuBar();
        JMenu settingsMenu = new JMenu();
        JMenuItem settingsMenuItem = new JMenuItem();
        settingsMenu.setText("Settings");
        settingsMenuItem.setText("Settings");
        settingsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settingsMenuItemActionPerformed(evt);
            }
        });

        settingsMenu.add(settingsMenuItem);
        mainMenuBar.add(settingsMenu);
        setJMenuBar(mainMenuBar);

        pack();

        settingsDialog.saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logger.info("Save Settings");
                settingsDialog.reloadProperties();

                JOptionPane.showConfirmDialog(null,
                        "Please note that when the tag names are changed the tree needs to be reloaded to represent the changes.\nThe displayed tree is using the old tag names!",
                        "Settings closed",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                investigatePanel.setMaxLevelBtnText();
                investigatePanel.repaintTree();
            }
        });
    }

    private void settingsMenuItemActionPerformed(ActionEvent evt) {
        settingsDialog.setVisible(true);
    }

    public static void makeMessageAndExit(String text, boolean exit) {
        JOptionPane pane = new JOptionPane(text);
        JDialog dialog = pane.createDialog("Nuix Items Tree");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        if (exit) {
            System.exit(0);
        }
    }
}
