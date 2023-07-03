package linkedlist;
//How to create linked list,
//Linked list creation,
//linked list insertion,
//linked list creation algorithm
//linked list creation in java
//linked list create example
//linked list Data Structure,
//coding simplified,
//linked list,
//java,

/*
 * Node class contains the LinkedList Node Structure. (int Data & a reference point)
 */
class Node {
    Node next;
    int data;
}

/*
 * Linked class contains the necessary functions to make the operations.
 */
class Linked {
    Node root;

    public Linked() {
        root = null;
    }

    /*
     * getNewNode() method to generate a new node
     */
    public Node getNewNode(int key) {
        Node a = new Node();
        a.next = null;
        a.data = key;
        return a;
    }

    /*
     * insert method is used to insert the element in Linked List
     */
    public Node insert(Node node, int key) {
        if (node == null)
            return getNewNode(key);
        else
            node.next = insert(node.next, key);

        return node;
    }
}

/*
 * LinkedList class to initiate the operation.
 */
public class Main {

    public static void main(String[] args) {

        Node root = null;
        Linked a = new Linked();
        root = a.insert(root, 1);
        root = a.insert(root, 2);
        root = a.insert(root, 3);
        root = a.insert(root, 4);
    }
}
