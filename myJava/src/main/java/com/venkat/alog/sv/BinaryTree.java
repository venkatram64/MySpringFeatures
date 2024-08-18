package com.venkat.alog.sv;

/*
public class BinaryTree {
}
*/
// Node class representing a single node in the binary tree
class Nodee {
    int key;
    Nodee left, right;

    public Nodee(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class representing the entire binary tree
public class BinaryTree {
    Nodee root;

    // Constructor for an empty tree
    BinaryTree() {
        root = null;
    }

    // Method to perform inorder traversal (left-root-right)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Nodee root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to perform preorder traversal (root-left-right)
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Nodee root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method to perform postorder traversal (left-right-root)
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Nodee root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Method to insert a new node at the first available position in level order
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Helper function to insert a new node (not using level-order insertion here)
    Nodee insertRec(Nodee root, int key) {
        if (root == null) {
            root = new Nodee(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Driver code to test the binary tree implementation
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Traversal outputs
        System.out.println("Inorder traversal:");
        tree.inorder();  // Output: 20 30 40 50 60 70 80

        System.out.println("\nPreorder traversal:");
        tree.preorder();  // Output: 50 30 20 40 70 60 80

        System.out.println("\nPostorder traversal:");
        tree.postorder();  // Output: 20 40 30 60 80 70 50
    }
}
