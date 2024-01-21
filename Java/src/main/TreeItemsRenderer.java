package main;

import gui.NuixItemsTree;
import gui.SettingsDialog;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeItemsRenderer extends DefaultTreeCellRenderer {

    private final Icon closedItemIcon;

    private final Icon openedItemIcon;
    
    private final Icon elementItemIcon;

    private final Icon taggedImportantIcon;

    private final Icon taggedNotImportantIcon;

    public TreeItemsRenderer() {
        this.closedItemIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(NuixItemsTree.class.getResource("/res/sharp_folder_black_24dp.png")));
        this.openedItemIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(NuixItemsTree.class.getResource("/res/sharp_folder_open_black_24dp.png")));
        this.elementItemIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(NuixItemsTree.class.getResource("/res/draft_FILL0_wght400_GRAD0_opsz24.png")));
        this.taggedImportantIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(NuixItemsTree.class.getResource("/res/sharp_local_offer_green_24dp.png")));
        this.taggedNotImportantIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(NuixItemsTree.class.getResource("/res/sharp_local_offer_red_24dp.png")));
        
        setClosedIcon(this.closedItemIcon);
        setOpenIcon(this.openedItemIcon);
        setLeafIcon(this.elementItemIcon);
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        TreeItem node = (TreeItem) value;
        if (node.hasTag(SettingsDialog.tagImportantName)) {
            setIcon(this.taggedImportantIcon);
        }
        if (node.hasTag(SettingsDialog.tagNotImportantName)) {
            setIcon(this.taggedNotImportantIcon);
        }
        if (SettingsDialog.showDescendantsCount && node.getDescendantsCount() > 0) {
            String text = String.format("%s <span style='font-size: 10pt;'>(%s)</span>", new Object[]{node, Integer.valueOf(node.getDescendantsCount())});
            setText("<html>" + text + "</html>");
        }
        return this;
    }
}
