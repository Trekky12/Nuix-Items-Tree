package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
    private final String savePathProp = "C:\\temp";
    private final String searchQueryProp = "mime-type:filesystem/directory";
    private final String tagImportantNameProp = "important";
    private final String tagNotImportantNameProp = "unimportant";
    private final int maxLevelProp = 4;

    public static String savePath;
    public static String searchQuery;
    public static String tagImportantName;
    public static String tagNotImportantName;
    public static int maxLevel;

    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            File jarFolder = new File(MainFrame.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
            propertiesFile = new File(jarFolder, this.properties_filename);
            loadProperties(propertiesFile);

        } catch (URISyntaxException ex) {
            logger.error("Error loading properties", ex);
        }

        pathField.setText(savePath);
        searchQueryField.setText(searchQuery);
        tagImportantField.setText(tagImportantName);
        tagNotImportantField.setText(tagNotImportantName);
        maxLevelField.setText(Integer.toString(maxLevel));
    }

    private void loadProperties(File f) {
        try ( FileInputStream in = new FileInputStream(f)) {
            properties.load(in);
            SettingsDialog.savePath = properties.getProperty("savePath", savePathProp);
            SettingsDialog.searchQuery = properties.getProperty("searchQuery", searchQueryProp);
            SettingsDialog.tagImportantName = properties.getProperty("tagImportantName", tagImportantNameProp);
            SettingsDialog.tagNotImportantName = properties.getProperty("tagNotImportantName", tagNotImportantNameProp);
            SettingsDialog.maxLevel = Integer.parseInt(properties.getProperty("maxLevel", Integer.toString(maxLevelProp)));
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

        properties.setProperty("savePath", savePathProp);
        properties.setProperty("searchQuery", searchQueryProp);
        properties.setProperty("tagImportantName", tagImportantNameProp);
        properties.setProperty("tagNotImportantName", tagNotImportantNameProp);
        properties.setProperty("maxLevel", Integer.toString(maxLevelProp));

        saveProperties(f);

        SettingsDialog.savePath = savePathProp;
        SettingsDialog.searchQuery = searchQueryProp;
        SettingsDialog.tagImportantName = tagImportantNameProp;
        SettingsDialog.tagNotImportantName = tagNotImportantNameProp;
        SettingsDialog.maxLevel = maxLevelProp;
    }

    public void reloadProperties() {
        properties.setProperty("savePath", pathField.getText());
        properties.setProperty("searchQuery", searchQueryField.getText());
        properties.setProperty("tagImportantName", tagImportantField.getText());
        properties.setProperty("tagNotImportantName", tagNotImportantField.getText());
        properties.setProperty("maxLevel", maxLevelField.getText());

        saveProperties(propertiesFile);

        // save in static attributes
        SettingsDialog.savePath = pathField.getText();
        SettingsDialog.searchQuery = searchQueryField.getText();
        SettingsDialog.tagImportantName = tagImportantField.getText();
        SettingsDialog.tagNotImportantName = tagNotImportantField.getText();
        SettingsDialog.maxLevel = Integer.parseInt(maxLevelField.getText());

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        GridBagConstraints gridBagConstraints;

        pathLabel = new JLabel();
        pathField = new JTextField();
        pathBtn = new JButton();
        searchQueryLabel = new JLabel();
        searchQueryField = new JTextField();
        tagImportantLabel = new JLabel();
        tagImportantField = new JTextField();
        tagNotImportantLabel = new JLabel();
        tagNotImportantField = new JTextField();
        maxLevelLabel = new JLabel();
        maxLevelField = new JTextField();
        saveBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        pathLabel.setText("Path:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(pathLabel, gridBagConstraints);

        pathField.setEditable(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(pathField, gridBagConstraints);

        pathBtn.setText("Set Path");
        pathBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pathBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 6, 6, 10);
        getContentPane().add(pathBtn, gridBagConstraints);

        searchQueryLabel.setText("Search-Query:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(searchQueryLabel, gridBagConstraints);

        searchQueryField.setText("mime-type:filesystem/directory");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(searchQueryField, gridBagConstraints);

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

        maxLevelLabel.setText("Max. Level:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(maxLevelLabel, gridBagConstraints);

        maxLevelField.setText("8");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(10, 6, 6, 6);
        getContentPane().add(maxLevelField, gridBagConstraints);

        saveBtn.setText("Save");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 5.0;
        gridBagConstraints.insets = new Insets(10, 10, 6, 6);
        getContentPane().add(saveBtn, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void pathBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_pathBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(SettingsDialog.savePath));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            pathField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_pathBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField maxLevelField;
    private JLabel maxLevelLabel;
    private JButton pathBtn;
    private JTextField pathField;
    private JLabel pathLabel;
    public JButton saveBtn;
    private JTextField searchQueryField;
    private JLabel searchQueryLabel;
    private JTextField tagImportantField;
    private JLabel tagImportantLabel;
    private JTextField tagNotImportantField;
    private JLabel tagNotImportantLabel;
    // End of variables declaration//GEN-END:variables
}
