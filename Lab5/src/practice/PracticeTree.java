package practice;



import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class PracticeTree extends TreeFrame {
    ArrayList <String> lifeChilren;
    ArrayList <String> typeChildren;

    void initTree() {
        lifeChilren = new ArrayList <String> (Arrays.asList("Växter", "Djur", "Svampar"));
        typeChildren = new ArrayList <String> (Arrays.asList("Växter", "Djur", "Svampar"));
        root = new DefaultMutableTreeNode("Liv");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        buildTree();
    }

    private void buildTree() {
        for (String child: lifeChilren){
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
            root.add(childNode);
            for (String childChild: typeChildren) {
                DefaultMutableTreeNode childChildNode = new DefaultMutableTreeNode(childChild);
                childNode.add(childChildNode);
            }
        }
    }

    public static void main(String[] args) {
        new PracticeTree();
    }
}
