//changing a few methods adding a new one and commenting
package linkedlist;
//class Node int data and Node next
class Node {
    int data;
    Node next;
}
public class LinkedList {

    //get new Node method in order to get New Nodes in the Linked list
    private Node getNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next =  null;

        return newNode;
    }
    //adding new delete method
    public Node delete(Node node) {
        if (node == null || node.next == null) {
            return null;
        }

        Node tmp = node;

        while(tmp.next.next != null) {
            tmp = tmp.next;
        }

        tmp.next = null;
        return node;
    }
    //insert method inserting Nodes using the previous getNewNODE method.
    public Node insert(Node node, int val) {
        if(node == null) {
            return getNewNode(val);
        }

        Node firstNode = node;

        while(node.next != null) {
            node = node.next;
        }

        node.next = getNewNode(val);
        return firstNode;
    }
   public Node insertAtPosition (int i,int position, Node node) {
       if (position < 0) {
           System.out.println("Position can't be less than 1");
       }

       if (node == null && position > 1) {
           System.out.println("Position is greater than element exists");
           return node;
       }

       if (node == null && position == 1) {
           return getNewNode(i);
       }

       if (position == 1) {
           Node newNode = getNewNode(i);
           newNode.next = node;
           return newNode;
       }

       node.next = insertAtPosition(i, position - 1, node.next);
       return node;
   }
    public Node deleteFront(Node node) {
        if (node == null) {
            return null;
        }

        return node.next;
    }


    //Adding a method to insert a new element in the front as a root
    public Node insertFront (int i ,Node node){
        Node a= getNewNode(i);
        a.next = node;

        return a;
    }


    //PrintList method printing the LinkedList using a simple while loop .next
    public void printList(Node node) {
        if(node == null) {
            return;
        }

        while(node != null) {
            System.out.print(node.data + " ");

            node = node.next;
        }
    }

    public class LinkedListApp {

        public static void main(String[] args) {

            LinkedList obj = new LinkedList();
            Node head = null;

            head = obj.insert(head, 12);
            head = obj.insert(head, 7);
            head = obj.insert(head, 8);
            head = obj.insert(head, 10);

            obj.printList(head);

        }

    }
}


