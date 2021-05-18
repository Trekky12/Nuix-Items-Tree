package main;

import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TreeItemsModel implements TreeModel {

    private final TreeItem root;

    public TreeItemsModel(TreeItem root) {
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public boolean isLeaf(Object node) {
        List<TreeItem> children = ((TreeItem) node).getChildren();
        return children.size() < 1;
    }

    @Override
    public int getChildCount(Object parent) {
        List<TreeItem> children = ((TreeItem) parent).getChildren();
        return children.size();
    }

    @Override
    public Object getChild(Object parent, int index) {
        List<TreeItem> children = ((TreeItem) parent).getChildren();
        return children.get(index);
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        List<TreeItem> children = ((TreeItem) parent).getChildren();
        return children.indexOf(child);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }
}
