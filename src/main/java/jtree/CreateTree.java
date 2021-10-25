package jtree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class CreateTree extends JFrame {
    JTree tree;
    DefaultMutableTreeNode root, parent1, parent2, child,child1, child2;

    CreateTree() {
        super("JTree Demo");

        root = new DefaultMutableTreeNode("States");
        parent1 = new DefaultMutableTreeNode("Andhra Pradesh");
        child = new DefaultMutableTreeNode("Vijayawada");
        child1 = new DefaultMutableTreeNode("Vizag");
        parent2 = new DefaultMutableTreeNode("Telangana");
        child2 = new DefaultMutableTreeNode("Hyderabad");

        // Adding child nodes to parent
        parent1.add(child);
        parent1.add(child1);
        parent2.add(child2);

        // Adding parent nodes to root
        root.add(parent1);
        root.add(parent2);

        // Adding root to JTree
        tree = new JTree(root);

        getContentPane().add(new JScrollPane(tree));
        setSize(300, 100);
        setVisible(true);
    }
}

class JTreeDemo {
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new CreateTree();
    }
}

