package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import main.TreeItemsRenderer;
import main.TreeItem;
import nuix.Case;
import nuix.Utilities;
import org.apache.log4j.Logger;

public class InvestigatePanel extends javax.swing.JPanel {

    private final static Logger logger = Logger.getLogger(InvestigatePanel.class);

    private final Case nuixCase;
    private final Utilities utilities;

    private DefaultTreeModel itemsTreeModel;
    private JTree itemsTree;
    private TreeItem root;

    public InvestigatePanel(Case nuixCase, Utilities utilities) {
        initComponents();

        this.nuixCase = nuixCase;
        this.utilities = utilities;
        buildTree();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        addTagNotImportantBtn = new javax.swing.JButton();
        removeTagNotImportantBtn = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        searchPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        add(scrollPane, gridBagConstraints);

        searchPanel.setLayout(new java.awt.GridBagLayout());
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
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
    }// </editor-fold>//GEN-END:initComponents

    private void addTagNotImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagNotImportantBtnActionPerformed

        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagNotImportantName, true)) {
                node.addTag(SettingsDialog.tagNotImportantName);

                addTagImportantBtn.setEnabled(false);
                removeTagImportantBtn.setEnabled(false);
                addTagNotImportantBtn.setEnabled(false);
                removeTagNotImportantBtn.setEnabled(true);
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
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_removeTagNotImportantBtnActionPerformed

    private void addTagImportantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagImportantBtnActionPerformed
        Thread tagThread = new Thread(() -> {
            TreeItem node = (TreeItem) itemsTree.getLastSelectedPathComponent();

            if (tagItem(node, SettingsDialog.tagImportantName, true)) {
                node.addTag(SettingsDialog.tagImportantName);

                addTagImportantBtn.setEnabled(false);
                removeTagImportantBtn.setEnabled(true);
                addTagNotImportantBtn.setEnabled(false);
                removeTagNotImportantBtn.setEnabled(false);
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

                addTagImportantBtn.setEnabled(true);
                removeTagImportantBtn.setEnabled(false);
                addTagNotImportantBtn.setEnabled(true);
                removeTagNotImportantBtn.setEnabled(false);
            }
            itemsTree.repaint();
        });
        tagThread.start();
    }//GEN-LAST:event_removeTagImportantBtnActionPerformed

    private void resetTree() {
        logger.info("Reset Tree");

        if (itemsTree != null) {
            itemsTree.setModel(null);
        }
        root = new TreeItem(nuixCase.getName());

        addTagImportantBtn.setEnabled(false);
        removeTagImportantBtn.setEnabled(false);
        addTagNotImportantBtn.setEnabled(false);
        removeTagNotImportantBtn.setEnabled(false);
    }

    public void buildTree() {

        logger.info("Starting tree building");

        resetTree();

        Thread processThread = new Thread(() -> {
            try {

                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }

                List<nuix.Item> items = nuixCase.getRootItems();

                logger.info(String.format("%s root items found", items.size()));

                progressBar.setIndeterminate(true);
                for (nuix.Item item : items) {
                    logger.info(String.format("Create root item (%s)", item.getName()));
                    TreeItem rootItem = new TreeItem(item);
                    if (this.nuixCase.isCompound()) {
                        TreeItem caseName = new TreeItem(item.getCaseName());

                        if (root.hasChild(caseName)) {
                            caseName = root.getChild(caseName);
                        } else {
                            root.add(caseName);
                        }

                        if (!caseName.hasChild(rootItem)) {
                            caseName.add(rootItem);
                        }
                    } else {
                        if (!root.hasChild(rootItem)) {
                            root.add(rootItem);
                        }
                    }
                }

                itemsTreeModel = new DefaultTreeModel(root);
                itemsTree = new JTree();
                itemsTree.setLargeModel(true);
                itemsTree.setRowHeight(20);
                itemsTree.setShowsRootHandles(true);

                itemsTree.setCellRenderer(new TreeItemsRenderer());

                itemsTree.addTreeWillExpandListener(new TreeWillExpandListener() {
                    @Override
                    public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {

                        TreePath path = event.getPath();
                        if (path.getLastPathComponent() instanceof TreeItem) {

                            logger.info(String.format("Expanding tree on item %s", path.getLastPathComponent()));

                            Thread expandThread = new Thread(() -> {
                                TreeItem node = (TreeItem) path.getLastPathComponent();

                                progressBar.setIndeterminate(true);
                                if (!node.isLoaded()) {
                                    logger.info(String.format("This item has %s children", node.getChildItemsCount()));

                                    List<TreeItem> children = new ArrayList<>();

                                    /*
                                    List<nuix.Item> nuixChildren = node.getChildItems();
                                    for (nuix.Item nuixChild : nuixChildren) {
                                        children.add(new TreeItem(nuixChild));
                                    }
                                    node.setChildren(children);
                                    */
                                    try {
                                        
                                        Set<nuix.Item> nuixChildrenSet = nuixCase.searchUnsorted(String.format("parent-guid:%s", node.getGuid()));
                                        List<nuix.Item> nuixChildren = utilities.getItemUtility().sortItemsByPosition(nuixChildrenSet);
                                        
                                        for (nuix.Item nuixChild : nuixChildren) {
                                            children.add(new TreeItem(nuixChild));
                                        }
                                        node.setChildren(children);
                                    } catch (IOException ex) {
                                        logger.error("Error when searching for childs");
                                    }

                                    itemsTreeModel.nodeStructureChanged(node);
                                    logger.info(String.format("Tree updated"));
                                }
                                progressBar.setIndeterminate(false);
                            });
                            expandThread.start();

                        }
                    }

                    @Override

                    public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {

                    }
                }
                );

                itemsTree.setModel(itemsTreeModel);

                TreeItem root = (TreeItem) itemsTreeModel.getRoot();

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

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }

            progressBar.setIndeterminate(false);

        });
        processThread.start();

    }

    private boolean tagItem(TreeItem node, String tagName, boolean doTag) {
        boolean result = false;
        try {
            List<nuix.Item> items = nuixCase.search(String.format("guid:%s", node.getGuid()));

            if (items.size() != 1) {
                logger.error(String.format("Item %s not found for tagging!", node.getGuid()));
                NuixItemsTree.makeMessageAndExit("Item not found. Probably already tagged or wrong or closed nuix case.", false);
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
                    NuixItemsTree.makeMessageAndExit("Item could not be tagged. Probably already tagged or wrong or closed nuix case.", false);
                }

            }

        } catch (IOException ex) {
            logger.fatal(null, ex);
        }

        return result;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton removeTagImportantBtn;
    private javax.swing.JButton removeTagNotImportantBtn;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
