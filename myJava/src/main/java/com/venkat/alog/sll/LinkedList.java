package com.venkat.alog.sll;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int numberOfItems;

    @Override
    public void insert(T data) {
        if(root == null){
            root = new Node<>(data);
            numberOfItems++;
        }else{
            //insertBeginning(data);
            insertEnd(data, root);
        }
    }

    @Override
    public void remove(T data) {
        if(root == null){
            return;
        }
        if(root.getData().compareTo(data) == 0){
            root = root.getNext();
        }else{
            remove(data, root, root.getNext());
        }
    }

    private void remove(T data, Node<T> prevNode, Node<T> actualNode){
        while(actualNode != null){
            if(actualNode.getData().compareTo(data) == 0){
                numberOfItems--;
                prevNode.setNext(actualNode.getNext());
                actualNode = null;
                return;
            }
            prevNode = actualNode;
            actualNode = actualNode.getNext();
        }
    }

    @Override
    public void traverse() {
        if(root == null){
            return;
        }
        Node<T> actualNode = root;
        while(actualNode != null){
            System.out.print(actualNode);
            actualNode = actualNode.getNext();
        }
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    private void insertBeginning(T data){
        Node<T> newNode = new Node<>(data);
        newNode.setNext(root);
        root = newNode;
        numberOfItems++;
    }

    public void insertEnd(T data, Node<T> node){
        if(node.getNext() != null){
            insertEnd(data, node.getNext());
        }else{
            Node<T> newNode = new Node<>(data);
            node.setNext(newNode);
            numberOfItems++;
        }
    }

    public Node<T> getMiddleNode(){
        Node<T> slow = this.root;
        Node<T> fast = this.root;

        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    @Override
    public Node<T> get(int index){
        int counter = 0;
        Node<T> node = this.root;
        while(node != null){
            if(index == counter){
                return node;
            }
            counter++;
            node = node.getNext();
        }
        return null;
    }

    @Override
    public void reverse(){
        Node<T> currentNode = this.root;
        Node<T> prevNode = null;
        Node<T> nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        this.root = prevNode;
    }
}
