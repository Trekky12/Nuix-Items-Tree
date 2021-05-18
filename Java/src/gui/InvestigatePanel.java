package gui;

import com.google.gson.Gson;
import java.awt.Window;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.TreePath;
import main.TreeItemsRenderer;
import main.TreeItemsModel;
import main.TreeItem;
import nuix.Case;
import org.apache.log4j.Logger;

public class InvestigatePanel extends javax.swing.JPanel {

    private final static Logger logger = Logger.getLogger(InvestigatePanel.class);

    private final Case nuixCase;

    private TreeItemsModel itemsTreeModel;
    private JTree itemsTree;
    private final Map<String, TreeItem> treeItems = new HashMap<String, TreeItem>();
    private TreeItem root;

    private boolean isTreeGenerated = false;
    private Thread processThread;

    private final String toggleSearchBtnText = "Create Tree.. ";

    private File treeFile = null;

    public InvestigatePanel(Case nuixCase) {
        initComponents();

        this.nuixCase = nuixCase;

        searchPanel.setVisible(false);
        createTreeToggle.setText("▽  " + toggleSearchBtnText);

        setMaxLevelBtnText();

        searchField.setText(SettingsDialog.searchQuery);
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        addTagNotImportantBtn = new javax.swing.JButton();
        removeTagNotImportantBtn = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        loadBtn = new javax.swing.JButton();
        openTreeBtn = new javax.swing.JButton();
        createTreeToggle = new javax.swing.JToggleButton();
        saveTreeBtn = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        progressBar = new javax.swing.JProgressBar();
        generateBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        addTagImportantBtn = new javax.swing.JButton();
        removeTagImportantBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        statusLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(650, 457));
        setPreferredSize(new java.awt.Dimension(650, 457));
        setLayout(new java.awt.GridBagLayout());

        addTagNotImportantBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sharp_local_offer_red_24dp.png"))); // NOI18N
        addTagNotImportantBtn.setText("Add Tag \"Not Important\"");
        addTagNotImportantBtn.setEnabled(false);
        addTagNotImportantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagNotImportantBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        add(addTagNotImportantBtn, gridBagConstraints);

        removeTagNotImportantBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sharp_local_offer_red_24dp.png"))); // NOI18N
        removeTagNotImportantBtn.setText("Remove Tag \"Not Important\"");
        removeTagNotImportantBtn.setEnabled(false);
        removeTagNotImportantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTagNotImportantBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 10);
        add(removeTagNotImportantBtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        add(scrollPane, gridBagConstraints);

        loadBtn.setText("Load Tree");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        add(loadBtn, gridBagConstraints);

        openTreeBtn.setText("Open max. 4 levels");
        openTreeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTreeBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 10);
        add(openTreeBtn, gridBagConstraints);

        createTreeToggle.setText("Create Tree...");
        createTreeToggle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createTreeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTreeToggleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        add(createTreeToggle, gridBagConstraints);

        saveTreeBtn.setText("Save Tree");
        saveTreeBtn.setEnabled(false);
        saveTreeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTreeBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(saveTreeBtn, gridBagConstraints);

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        searchPanel.add(searchField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        searchPanel.add(progressBar, gridBagConstraints);

        generateBtn.setText("Search items and create Tree");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 0);
        searchPanel.add(generateBtn, gridBagConstraints);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 10);
        searchPanel.add(cancelBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        add(searchPanel, gridBagConstraints);

        addTagImportantBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sharp_local_offer_green_24dp.png"))); // NOI18N
        addTagImportantBtn.setText("Add Tag \"Important\"");
        addTagImportantBtn.setEnabled(false);
        addTagImportantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagImportantBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        add(addTagImportantBtn, gridBagConstraints);

        removeTagImportantBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sharp_local_offer_green_24dp.png"))); // NOI18N
        removeTagImportantBtn.setText("Remove Tag \"Important\"");
        removeTagImportantBtn.setEnabled(false);
        removeTagImportantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTagImportantBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 10);
        add(removeTagImportantBtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jSeparator2, gridBagConstraints);

        statusLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 6);
        add(statusLabel, gridBagConstraints);
    }//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        loadTree();
    }//GEN-LAST:event_loadBtnActionPerformed

    private void openTreeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTreeBtnActionPerformed
        expandTree(itemsTree, true);
    }//GEN-LAST:event_openTreeBtnActionPerformed

    private void createTreeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTreeToggleActionPerformed
        if (searchPanel.isVisible()) {
            searchPanel.setVisible(false);
            createTreeToggle.setText("▽  " + toggleSearchBtnText);
        } else {
            searchPanel.setVisible(true);
            createTreeToggle.setText("△  " + toggleSearchBtnText);
        }
    }//GEN-LAST:event_createTreeToggleActionPerformed

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        buildTree();
    }//GEN-LAST:event_generateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        logger.info("Cancel tree building");
        processThread.interrupt();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addTagNotImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagNotImportantBtnActionPerformed

        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagNotImportantName, true)) {
                node.addTag(SettingsDialog.tagNotImportantName);
                
                addTagImportantBtn.setEnabled(false);
                removeTagImportantBtn.setEnabled(false);
                addTagNotImportantBtn.setEnabled(false);
                removeTagNotImportantBtn.setEnabled(true);
                
                saveTree();
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_addTagNotImportantBtnActionPerformed

    private void removeTagNotImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTagNotImportantBtnActionPerformed

        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagNotImportantName, false)) {
                node.removeTag(SettingsDialog.tagNotImportantName);

                addTagImportantBtn.setEnabled(true);
                removeTagImportantBtn.setEnabled(false);
                addTagNotImportantBtn.setEnabled(true);
                removeTagNotImportantBtn.setEnabled(false);

                saveTree();
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_removeTagNotImportantBtnActionPerformed

    private void saveTreeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTreeBtnActionPerformed
        saveTree();
    }//GEN-LAST:event_saveTreeBtnActionPerformed

    private void addTagImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagImportantBtnActionPerformed
        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagImportantName, true)) {
                node.addTag(SettingsDialog.tagImportantName);

                addTagImportantBtn.setEnabled(false);
                removeTagImportantBtn.setEnabled(true);
                addTagNotImportantBtn.setEnabled(false);
                removeTagNotImportantBtn.setEnabled(false);

                saveTree();
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_addTagImportantBtnActionPerformed

    private void removeTagImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTagImportantBtnActionPerformed
        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagImportantName, false)) {
                node.removeTag(SettingsDialog.tagImportantName);
                saveTree();

                addTagImportantBtn.setEnabled(true);
                removeTagImportantBtn.setEnabled(false);
                addTagNotImportantBtn.setEnabled(true);
                removeTagNotImportantBtn.setEnabled(false);
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_removeTagImportantBtnActionPerformed

    private void buildTree() {

        logger.info("Starting tree building");

        statusLabel.setText("Generating tree...");

        resetTree();

        String query = searchField.getText();

        Map<String, Object> searchOptions = new HashMap<String, Object>();
        searchOptions.put("defaultFields", new String[]{"properties", "name", "path-name"});

        processThread = new Thread(() -> {
            try {

                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }

                generateBtn.setEnabled(false);
                cancelBtn.setEnabled(true);
                saveTreeBtn.setEnabled(false);
                logger.info("Search for items...(" + query + ")");
                //Set<nuix.Item> items = nuixCase.searchUnsorted(query);
                List<nuix.Item> items = nuixCase.search(query, searchOptions);

                logger.info(String.format("%s items found", items.size()));

                progressBar.setMaximum(items.size() - 1);
                int index = 0;
                for (nuix.Item item : items) {
                    logger.info(String.format("Create item %s (%s)", index, item.getName()));
                    processItemForTree(item);
                    progressBar.setValue(index++);
                }

                itemsTreeModel = new TreeItemsModel(root);
                initTree();
                saveTreeWithPrompt();

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }

            generateBtn.setEnabled(true);
            cancelBtn.setEnabled(false);
            saveTreeBtn.setEnabled(true);

            statusLabel.setText(" ");

        });
        processThread.start();

    }

    private void resetTree() {
        logger.info("Reset Tree");
        progressBar.setValue(0);
        progressBar.setMaximum(0);
        treeItems.clear();

        isTreeGenerated = false;

        if (itemsTree != null) {
            itemsTree.setModel(null);
        }
        root = new TreeItem(nuixCase.getName());

        addTagImportantBtn.setEnabled(false);
        removeTagImportantBtn.setEnabled(false);
        addTagNotImportantBtn.setEnabled(false);
        removeTagNotImportantBtn.setEnabled(false);
    }

    private void initTree() {
        itemsTree = new JTree(itemsTreeModel);
        itemsTree.setLargeModel(true);
        itemsTree.setRowHeight(20);

        itemsTree.setCellRenderer(new TreeItemsRenderer());

        itemsTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

                if (node == null) {
                    return;
                }

                if (!itemsTreeModel.getRoot().toString().equals(nuixCase.getName())) {
                    return;
                }

                if (node.hasTag(SettingsDialog.tagImportantName)) {
                    addTagImportantBtn.setEnabled(false);
                    removeTagImportantBtn.setEnabled(true);

                    addTagNotImportantBtn.setEnabled(false);
                    removeTagNotImportantBtn.setEnabled(false);
                } else if (node.hasTag(SettingsDialog.tagNotImportantName)) {
                    addTagImportantBtn.setEnabled(false);
                    removeTagImportantBtn.setEnabled(false);

                    addTagNotImportantBtn.setEnabled(false);
                    removeTagNotImportantBtn.setEnabled(true);
                } else {
                    addTagImportantBtn.setEnabled(true);
                    removeTagImportantBtn.setEnabled(false);

                    addTagNotImportantBtn.setEnabled(true);
                    removeTagNotImportantBtn.setEnabled(false);
                }

            }
        });

        scrollPane.setViewportView(itemsTree);

        isTreeGenerated = true;
    }

    public void processItemForTree(nuix.Item item) {

        List<nuix.Item> pathItems = item.getPath();

        // Iterate over path and create elements if they are missing
        for (nuix.Item pathItem : pathItems) {
            createTreePathItem(pathItem);
        }
    }

    private void createTreePathItem(nuix.Item pathItem) {
        String itemID = pathItem.getGuid();

        TreeItem result;
        if (!treeItems.containsKey(itemID)) {
            result = new TreeItem(pathItem);

            treeItems.put(itemID, result);

            // add this node as child to the parent
            List<nuix.Item> path = pathItem.getPath();
            if (path.size() > 1) {
                nuix.Item parent = path.get(path.size() - 2);
                if (treeItems.containsKey(parent.getGuid())) {
                    TreeItem parentTreeItem = treeItems.get(parent.getGuid());
                    if (!parentTreeItem.hasChild(result)) {
                        parentTreeItem.addChild(result);
                    }
                }
            } else {
                if (!root.hasChild(result)) {
                    root.addChild(result);
                }
            }
        }
    }

    public void saveTreeWithPrompt() {
        if (isTreeGenerated) {

            Window window = SwingUtilities.getWindowAncestor(this);
            JFrame frame = (JFrame) window;
            frame.setTitle("Nuix Items Tree");

            treeFile = null;

            File saveFolder = new File(SettingsDialog.savePath);
            File fileToSave = new File(saveFolder, String.format("%s.ntree", nuixCase.getName()));

            // Overwrite?
            if (fileToSave.exists()) {
                JFileChooser fileChooser = new JFileChooser() {
                    @Override
                    public void approveSelection() {
                        File f = getSelectedFile();
                        if (f.exists() && getDialogType() == SAVE_DIALOG) {
                            int result = JOptionPane.showConfirmDialog(this, "The file exists already. Do you want to override?", "Nuix Items Tree", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                            switch (result) {
                                case JOptionPane.YES_OPTION:
                                    super.approveSelection();
                                    return;
                                case JOptionPane.CANCEL_OPTION:
                                    cancelSelection();
                                    return;
                                case JOptionPane.NO_OPTION:
                                case JOptionPane.CLOSED_OPTION:
                                    return;
                            }
                        }
                        super.approveSelection();
                    }
                };
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Nuix Items Tree", "ntree");
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogTitle("Save Tree");
                fileChooser.setSelectedFile(fileToSave);
                fileChooser.setCurrentDirectory(saveFolder);

                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    fileToSave = fileChooser.getSelectedFile();

                    String fname = fileChooser.getSelectedFile().getAbsolutePath();
                    if (!fname.endsWith(".ntree")) {
                        fileToSave = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".ntree");
                    }
                } else {
                    return;
                }
            }
            // save the current selected file for further saving 
            treeFile = fileToSave;
            // and save the tree
            saveTree();

            frame.setTitle(String.format("Nuix Items Tree - %s", treeFile.getAbsolutePath()));
        }
    }

    private void saveTree() {
        if (treeFile != null) {
            Thread saveThread = new Thread(() -> {
                logger.info(String.format("Saving tree to file %s", treeFile));
                statusLabel.setText("Saving tree...");
                Gson gson = new Gson();
                try ( FileWriter writer = new FileWriter(treeFile)) {
                    gson.toJson(itemsTreeModel, writer);
                } catch (IOException ex) {
                    logger.error("Error saving tree", ex);
                    MainFrame.makeMessageAndExit("Error saving the tree", false);
                }
                statusLabel.setText(" ");
            });
            saveThread.start();
        } else {
            MainFrame.makeMessageAndExit("Saving not possible! No File specified!", false);
        }
    }

    public void loadTree() {
        Thread loadThread = new Thread(() -> {

            statusLabel.setText("Loading tree...");

            File loadFolder = new File(SettingsDialog.savePath);
            File fileToLoad = new File(loadFolder, String.format("%s.ntree", nuixCase.getName()));

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Load Item Tree");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Nuix Items Tree", "ntree");
            fileChooser.setFileFilter(filter);

            fileChooser.setSelectedFile(fileToLoad);
            fileChooser.setCurrentDirectory(loadFolder);

            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                resetTree();

                if (selectedFile.exists()) {

                    Gson gson = new Gson();
                    try ( FileReader reader = new FileReader(selectedFile)) {
                        itemsTreeModel = gson.fromJson(reader, TreeItemsModel.class);

                        initTree();

                        if (!itemsTreeModel.getRoot().toString().equals(nuixCase.getName())) {
                            MainFrame.makeMessageAndExit("Nuix Case Name is different from root Node, no tagging possible!", false);
                            addTagImportantBtn.setEnabled(false);
                            removeTagImportantBtn.setEnabled(false);
                            addTagNotImportantBtn.setEnabled(false);
                            removeTagNotImportantBtn.setEnabled(false);
                        }

                        // save the current selected file for further saving 
                        treeFile = selectedFile;

                        Window window = SwingUtilities.getWindowAncestor(this);
                        JFrame frame = (JFrame) window;
                        frame.setTitle(String.format("Nuix Items Tree - %s", treeFile.getAbsolutePath()));

                    } catch (IOException ex) {
                        logger.error("Error loading tree", ex);
                        MainFrame.makeMessageAndExit("Error loading the tree", false);
                    }
                }
            }
            statusLabel.setText(" ");
            saveTreeBtn.setEnabled(true);
        });
        loadThread.start();
    }

    private void expandTree(JTree tree, boolean expand) {
        TreeItem root = (TreeItem) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    private void expandAll(JTree tree, TreePath path, boolean expand) {

        if (path.getPathCount() > SettingsDialog.maxLevel) {
            return;
        }

        TreeItem node = (TreeItem) path.getLastPathComponent();

        if (node.getChildren().size() >= 0) {
            List<TreeItem> children = node.getChildren();

            for (TreeItem child : children) {
                TreePath p = path.pathByAddingChild(child);

                expandAll(tree, p, expand);
            }
        }

        if (expand) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
    }

    private boolean tagItem(TreeItem node, String tagName, boolean doTag) {
        boolean result = false;
        try {
            List<nuix.Item> items = nuixCase.search(String.format("guid:%s", node.getGuid()));

            if (items.size() != 1) {
                logger.error(String.format("Item %s not found for tagging!", node.getGuid()));
                MainFrame.makeMessageAndExit("Item not found. Probably already tagged or wrong or closed nuix case.", false);
            } else {

                if (doTag) {
                    result = items.get(0).addTag(tagName);
                    logger.info(String.format("Item %s tagging %s add result: %s", node.getGuid(), tagName, result));
                } else {
                    result = items.get(0).removeTag(tagName);
                    logger.info(String.format("Item %s tagging %s remove result: %s", node.getGuid(), tagName, result));
                }

                if (!result) {
                    logger.error(String.format("Item %s tagging %s failed", node.getGuid(), tagName));
                    MainFrame.makeMessageAndExit("Item could not be tagged. Probably already tagged or wrong or closed nuix case.", false);
                }

            }

        } catch (IOException ex) {
            logger.fatal(null, ex);
        }

        return result;
    }

    public void setMaxLevelBtnText() {
        openTreeBtn.setText("Open max. " + SettingsDialog.maxLevel + " levels");
    }

    public void repaintTree() {
        if (itemsTree != null) {
            System.out.println("reload tree!");
            itemsTree.validate();
            itemsTree.repaint();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTagImportantBtn;
    private javax.swing.JButton addTagNotImportantBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JToggleButton createTreeToggle;
    private javax.swing.JButton generateBtn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton openTreeBtn;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton removeTagImportantBtn;
    private javax.swing.JButton removeTagNotImportantBtn;
    private javax.swing.JButton saveTreeBtn;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
