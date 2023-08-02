package linkedlist;

//class Node int data and Node next
class Node {
    int data;
    Node next;
}

public class LinkedList {
//a
    // Method to insert a new Node at the end of the LinkedList
    public Node insert(Node node, int val) {
        if (node == null) {
            return getNewNode(val);
        }

        Node firstNode = node;

        while (node.next != null) {
            node = node.next;
        }

        node.next = getNewNode(val);
        return firstNode;
    }

    // Method to check if a node with the given value exists in the LinkedList
    public boolean ifNodeExists(int val, Node node) {
        if (node == null) {
            return false;
        }
        while (node != null) {
            if (node.data == val) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // Method to create a new Node with the given value
    private Node getNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;
        return newNode;
    }

    // Method to merge two sorted LinkedLists
    public Node merge(Node a, Node b) {
        Node temp = new Node();
        Node finalList = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        temp.next = (a == null) ? b : a;
        return finalList.next;
    }

    // Method to print the elements of the LinkedList
    public void printList(Node node) {
        if (node == null) {
            return;
        }

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node rotateAntiClockwise(int k, Node node) {
        if (node == null || k < 0) {
            return node;
        }

        int count = 1;
        Node current = node;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return node;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node = kthNode.next;
        kthNode.next = null;

        return node;
    }

    public static void main(String[] args) {

        LinkedList a = new LinkedList();
        Node head = null;
        head = a.insert(head, 12);
        head = a.insert(head, 39);

        boolean ifExist = a.ifNodeExists(123, head);
        System.out.println(ifExist);

        // Testing merge method
        Node list1 = a.getNewNode(2);
        list1.next = a.getNewNode(5);
        list1.next.next = a.getNewNode(8);

        Node list2 = a.getNewNode(3);
        list2.next = a.getNewNode(6);
        list2.next.next = a.getNewNode(9);

        Node mergedList = a.merge(list1, list2);
        System.out.println("Merged List:");
        a.printList(mergedList);
    }
}
