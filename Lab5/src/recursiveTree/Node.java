package recursiveTree;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class Node extends DefaultMutableTreeNode {

    public String name;
    public String level;
    public String info;

    public Node(String row){
        rowParser(row);
        this.setUserObject(name);
    }

    private void rowParser(String row) {

        this.level = row.substring(row.indexOf("<") + 1, row.indexOf(" "));
        this.name =  row.substring(row.indexOf("=") + 2, row.indexOf(">")-1);
        this.info = row.substring(row.indexOf(">") + 1);
    }

    public String getName() {
        return name;
    }

    public String getNLevel() {
        return level;
    }

    public String getInfo() {
        return info;
    }
}
