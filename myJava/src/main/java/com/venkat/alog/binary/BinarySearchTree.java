package com.venkat.alog.binary;

/*
    Tree traversal means visiting every node of the binary search tree exactly once in O(N)
    linear running time
    1. Pre-Order Traversal
        We visit the root node of the binary tree then the left subtree and finally the
        right subtree in a recursive manner
    2. In-Order Traversal
        we visit the left subtree of the binary tree then the root node and finally
        the right subtree in a recursive manner
    3. Post-Order Traversal
        We visit the left subtree of the binary tree then the right subtree and finally the
        root node in a recursive manner
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;

    @Override
    public void insert(T data) {
        if(root == null){
            //this is when we insert the first node, there is no parent node
            root = new Node<>(data, null);
        }else{
            //there is already node
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node){
        //this is the case when the data is smaller than the value in the node
        //goto left subtree
        if(node.getData().compareTo(data) > 0){
            if(node.getLeftChild() != null){
                //if there is already leftchild, then below
                insert(data, node.getLeftChild());
            }else{
                //if there is no leftchild node, create it
                node.setLeftChild(new Node<>(data, node));
            }
        //this is the case when the data is greater than the value in the node
        //goto right subtree
        }else{
            if(node.getRightChild() != null){
                insert(data, node.getRightChild());
            }else{
                node.setRightChild(new Node<>(data, node));
            }
        }
    }

    @Override
    public void remove(T data) {
        if(root != null) {
            remove(data, root);
        }
    }

    private void remove(T data, Node<T> node) {
        if (node == null) {
            return;
        }
        //first we have to search for the item, that to be removed
        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            //we have found the item, it should be removed
            //Case 1. if it is a leaf node means there is no left and right child
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node...");
                //check if it's a left or right child of parent
                Node<T> parent = node.getParentNode();
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(null);
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }
                //may be the root node, it should be removed
                // b/c if it is a single node, may be the root node is the one which have to remove
                if (parent == null) {
                    root = null;
                }
                //remove the node which is eligible for GC
                node = null;
            } else if (node.getLeftChild() == null && node.getRightChild() != null) {
                System.out.println("Removing a node with single right child ...");
                //Case 2a. single right child, when we remove items with a single child
                Node<T> parent = node.getParentNode();
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }
                //when we deal with the root node
                if (parent == null) {
                    root = node.getRightChild();
                }
                //we have to update the right child's parent
                node.getRightChild().setParentNode(parent);
                node = null;
            }else if (node.getLeftChild() != null && node.getRightChild() == null) {
                System.out.println("Removing a node with single left child ...");
                //Case 2b. when we remove items with a single child, single left child
                Node<T> parent = node.getParentNode();
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }
                //when we deal with the root node
                if (parent == null) {
                    root = node.getLeftChild();
                }
                //we have to update the right child's parent
                node.getLeftChild().setParentNode(parent);
                node = null;
            }else{
                System.out.println("Removing a node with 2 children ...");
                //Case 3: removing the root node so remove 2 children
                //find the predecessor(max item in the left subtree)
                Node<T> predecessor = getPredecessor(node.getLeftChild());
                //swap the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);
                //we have call the remove method recursively on the predecessor
                remove(data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void inOrderTraversal() {
        //we visit the left subtree of the binary tree then the root node and finally
        //the right subtree in a recursive manner -->In-Order Traversal(Sorted Order)
        if(root == null){
            return;
        }
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node){
        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + " -> ");
        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }

    @Override
    public void preOrderTraversal(){
        if(root == null){
            return;
        }
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<T> node){
        System.out.print(node + " -> ");
        if(node.getLeftChild() != null){
            preOrderTraversal(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            preOrderTraversal(node.getRightChild());
        }
    }

    @Override
    public void postOrderTraversal(){
        if(root == null){
            return;
        }
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<T> node){
        if(node.getLeftChild() != null){
            postOrderTraversal(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            postOrderTraversal(node.getRightChild());
        }
        System.out.print(node + " -> ");
    }

    @Override
    public T getMin() {
        if(root == null){
            return  null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node){
        if(node.getLeftChild() != null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    @Override
    public T getMax() {
        if(root == null){
            return  null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node){
        if(node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public Node<T> getKSmallest(Node<T> node, int k) {
        //number of nodes in the left subtree
        //+1 b/c we count the root node of the subtree as well
        int n = treeSize(node.getLeftChild()) + 1;
        //this is when we find the kth smallest item
        if(n == k){
            return node;
        }
        //if the number of nodes in the left subtree > k-th smallest item
        //it means the k-th smallest item is in the left subtree
        if(n > k){
            return getKSmallest(node.getLeftChild(), k);
        }
        //if the number of nodes in the left subtree is smaller, then the k-th
        //smallest item then we can discard the left subtree and consider the right subtree
        if(n < k){
            return getKSmallest(node.getRightChild(), k - n);
        }
        return null;
    }

    @Override
    public Node<T> getRoot(){
        return root;
    }

    private int treeSize(Node<T> node){
        if(node == null){
            return 0;
        }
        int num = (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
        return num;
    }

    @Override
    public int getTotalAge(Node<T> node) {
        return getAges(this.root);
    }

    private int getAges(Node<T> node){
        System.out.println("Considering node " + node);
        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;

        if(node == null){
            return 0;
        }
        //postOrderTraversal,
        //b/c we have to calculate both left and right value to be able to calculate the parent's value
        leftSum = getAges(node.getLeftChild());
        rightSum = getAges(node.getRightChild());
        System.out.println("Considering node " + node + " Total ages so far as " + (((Person)node.getData()).getAge()
                + leftSum + rightSum));

        sum = ((Person)node.getData()).getAge() + leftSum + rightSum;
        return sum;
    }
}
