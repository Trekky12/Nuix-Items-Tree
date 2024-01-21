package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import org.apache.log4j.Logger;

public class SettingsDialog extends javax.swing.JDialog {

    private final static Logger logger = Logger.getLogger(SettingsDialog.class);

    // Settings
    private final Properties properties = new Properties();
    private final String properties_filename = "nuix-items-tree.ini";
    private File propertiesFile;
    private final String tagImportantNameProp = "important";
    private final String tagNotImportantNameProp = "unimportant";
    private final boolean showDescendantsCountProp = true;

    public static String tagImportantName;
    public static String tagNotImportantName;
    public static boolean showDescendantsCount;

    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            File jarFolder = new File(NuixItemsTree.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
            propertiesFile = new File(jarFolder, this.properties_filename);
            loadProperties(propertiesFile);

        } catch (URISyntaxException ex) {
            logger.error("Error loading properties", ex);
        }

        tagImportantField.setText(tagImportantName);
        tagNotImportantField.setText(tagNotImportantName);
        showDescendantsCountCheckbox.setSelected(showDescendantsCount);
    }

    private void loadProperties(File f) {
        try ( FileInputStream in = new FileInputStream(f)) {
            properties.load(in);
            SettingsDialog.tagImportantName = properties.getProperty("tagImportantName", tagImportantNameProp);
            SettingsDialog.tagNotImportantName = properties.getProperty("tagNotImportantName", tagNotImportantNameProp);
            SettingsDialog.showDescendantsCount = Boolean.parseBoolean(properties.getProperty("showDescendantsCount"));
        } catch (Exception ex) {
            logger.error("Error loading properties", ex);
            createDefaultProperties(f);
        }
    }

    private void saveProperties(File f) {
        try ( FileOutputStream out = new FileOutputStream(f)) {
            properties.store(out, "Nuix Items Tree");
        } catch (Exception ex) {
            logger.error("Error saving properties", ex);
        }
    }

    private void createDefaultProperties(File f) {
        logger.info("Create default configuration");

        properties.setProperty("tagImportantName", tagImportantNameProp);
        properties.setProperty("tagNotImportantName", tagNotImportantNameProp);
        properties.setProperty("showDescendantsCount", Boolean.toString(showDescendantsCountProp));

        saveProperties(f);

        SettingsDialog.tagImportantName = tagImportantNameProp;
        SettingsDialog.tagNotImportantName = tagNotImportantNameProp;
        SettingsDialog.showDescendantsCount = showDescendantsCountProp;
    }

    public void reloadProperties() {
        properties.setProperty("tagImportantName", tagImportantField.getText());
        properties.setProperty("tagNotImportantName", tagNotImportantField.getText());
        properties.setProperty("showDescendantsCount", Boolean.toString(showDescendantsCountCheckbox.isSelected()));

        saveProperties(propertiesFile);

        // save in static attributes
        SettingsDialog.tagImportantName = tagImportantField.getText();
        SettingsDialog.tagNotImportantName = tagNotImportantField.getText();
        SettingsDialog.showDescendantsCount = showDescendantsCountCheckbox.isSelected();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        tagImportantLabel = new JLabel();
        tagImportantField = new JTextField();
        tagNotImportantLabel = new JLabel();
        tagNotImportantField = new JTextField();
        saveBtn = new JButton();
        showDescendantsCountCheckbox = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        tagImportantLabel.setText("Tag Name \"Important\":");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(tagImportantLabel, gridBagConstraints);

        tagImportantField.setText("important");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(tagImportantField, gridBagConstraints);

        tagNotImportantLabel.setText("Tag Name \"Not Important\":");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(tagNotImportantLabel, gridBagConstraints);

        tagNotImportantField.setText("unimportant");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(tagNotImportantField, gridBagConstraints);

        saveBtn.setText("Save");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 5.0;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(saveBtn, gridBagConstraints);

        showDescendantsCountCheckbox.setSelected(true);
        showDescendantsCountCheckbox.setText("Show Descendants Count");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(showDescendantsCountCheckbox, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton saveBtn;
    private JCheckBox showDescendantsCountCheckbox;
    private JTextField tagImportantField;
    private JLabel tagImportantLabel;
    private JTextField tagNotImportantField;
    private JLabel tagNotImportantLabel;
    // End of variables declaration//GEN-END:variables
}
