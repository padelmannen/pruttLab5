package recursiveTree;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class LifeTree extends TreeFrame {

    String currLevel;
    Deque<String> levelStack;
    static Scanner sc;

    // Overrides method in TreeFrame
    void initTree() {
        levelStack = new ArrayDeque<>();
            try {
                File file = new File("C:/Users/jespe/OneDrive/Dokument/KTH/Prutten/pruttLab5/Lab5/src/recursiveTree/Liv.txt");
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        String currRow = sc.nextLine();
        Node root = new Node(currRow);
        currLevel = root.getNLevel();
        levelStack.push(currLevel);
        treeModel = new DefaultTreeModel(root);
        tree = new JTree( treeModel );
        tree.setBackground(Color.green);
        buildTree(root);
    }
    // New method

    private void levelChecker(String row){

        String currEndTag = row.substring(row.indexOf("</") + 2, row.lastIndexOf(">"));
        String correctTag = levelStack.pop();
        if (!currEndTag.equals(correctTag)) {
            System.out.println("Felaktig sluttagg");
            System.exit(0);
        }
    }
    private void buildTree(Node parent) {
        while (Objects.equals(parent.getNLevel(), levelStack.peek())) {
            if (sc.hasNext()) {
                String currRow = sc.nextLine();

                if (currRow.contains("</")) {
                    levelChecker(currRow);
                }
                else {
                    Node child = new Node(currRow);
                    currLevel = child.getNLevel();

                    if (!Objects.equals(currLevel, levelStack.peek())) {
                        levelStack.push(currLevel);
                        parent.add(child);
                        buildTree(child);
                    }
                }
            }
        }
    }

    // Overrides method in TreeFrame
    void showDetails(TreePath p){
        if ( p == null )
            return;
        Node clicked = (Node) p.getLastPathComponent();
        String level = clicked.getNLevel();
        String info = clicked.getInfo();
        String name = clicked.getName();
        JOptionPane.showMessageDialog( this, level + ": "+ name + info);
    }

    public static void main(String[] args) {

        new LifeTree();
    }
}