package main;

import java.util.ArrayList;
import java.util.List;

public class TreeItem {

    private final List<TreeItem> children = new ArrayList<TreeItem>();
    private String guid = null;
    private String name = null;
    private List<String> tags = new ArrayList<String>();
    private int descendants = 0;

    private boolean isTagged = false;
    private boolean isItem;

    public TreeItem(String name) {
        this.name = name;
        this.isItem = false;
    }

    public TreeItem(nuix.Item item) {
        this.isItem = true;
        //this.item = item;
        this.name = item.getName();
        this.descendants = item.getDescendants().size();
        this.guid = item.getGuid();
        this.tags = new ArrayList<>(item.getTags());
        this.isItem = true;
    }

    public void addChild(TreeItem childItem) {
        children.add(childItem);
    }

    public List<TreeItem> getChildren() {
        return children;
    }

    public boolean hasChild(TreeItem childItem) {
        return children.contains(childItem);
    }
    
    public TreeItem getChild(TreeItem childItem){
        return children.get(children.indexOf(childItem));
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof TreeItem) {
            TreeItem that = ((TreeItem) object);
            if (!this.isItem && !that.isItem) {
                return this.name.equals(that.name);
            }
        }
        return super.equals(object);
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

    public int getDescendants() {
        return descendants;
    }

}
