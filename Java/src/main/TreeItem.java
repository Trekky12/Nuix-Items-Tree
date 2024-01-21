package main;

import gui.SettingsDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import org.apache.log4j.Logger;

public class TreeItem extends DefaultMutableTreeNode {

    private String guid = null;
    private String name = null;
    private List<String> tags = new ArrayList<>();
    private int descendantsCount = 0;
    private int childItemsCount = 0;

    private boolean isTagged = false;
    private boolean isItem = false;

    //private nuix.Item item;
    private List<nuix.Item> childItems = new ArrayList<>();
    private boolean loaded = false;

    private final static Logger logger = Logger.getLogger(TreeItem.class);

    public TreeItem(String name) {
        this.name = name;
        this.loaded = true;
    }

    public TreeItem(nuix.Item item) {
        this.name = item.getName();
        this.descendantsCount = SettingsDialog.showDescendantsCount ? item.getDescendants().size() : 0;
        this.childItemsCount = item.getChildren().size();
        this.guid = item.getGuid();
        this.isItem = true;
        this.tags = new ArrayList<>(item.getTags());
        //this.childItems = item.getChildren();
    }

    public void setChildren(List<TreeItem> children) {
        logger.info("Set children");
        removeAllChildren();
        setAllowsChildren(children.size() > 0);
        for (MutableTreeNode node : children) {
            add(node);
        }
        this.loaded = true;
    }

    public boolean hasChild(TreeItem childItem) {
        return children != null ? children.contains(childItem) : false;
    }

    public TreeItem getChild(TreeItem childItem) {
        return (TreeItem) children.get(children.indexOf(childItem));
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public boolean hasTag(String tag) {
        if (this.tags != null) {
            return this.tags.contains(tag);
        }
        return false;
    }

    public boolean isTagged() {
        return isTagged;
    }

    public void setTagged(boolean isTagged) {
        this.isTagged = isTagged;
    }

    public String getGuid() {
        return guid;
    }

    public int getDescendantsCount() {
        return descendantsCount;
    }

    public int getChildItemsCount() {
        return childItemsCount;
    }

    @Override
    public boolean isLeaf() {
        return this.isItem ? this.getChildItemsCount() == 0 : false;
    }

    public List<nuix.Item> getChildItems() {
        return childItems;
    }

    public boolean isLoaded() {
        return loaded;
    }
}
