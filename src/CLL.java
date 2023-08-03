import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("Circular Linked List is empty. Cannot delete.");
            return;
        }
        Node curr = head, prev = null;
        do {
            if (curr.data == data) {
                if (prev == null) {
                    Node temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    temp.next = head.next;
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Element " + data + " deleted from the Circular Linked List.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Element " + data + " not found in the Circular Linked List.");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class CLL {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Circular Linked List Operations:");
        System.out.println("1. Insert element");
        System.out.println("2. Insert element at the beginning");
        System.out.println("3. Delete element");
        System.out.println("4. Get length of the Circular Linked List");
        System.out.println("-1. Exit");
        int option;
        do {
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            if (option == 1) {
                System.out.print("Enter the element to insert: ");
                int data = scanner.nextInt();
                list.insert(data);
            } else if (option == 2) {
                System.out.print("Enter the element to insert at the beginning: ");
                int data = scanner.nextInt();
                list.insertAtBeginning(data);
            } else if (option == 3) {
                System.out.print("Enter the element to delete: ");
                int data = scanner.nextInt();
                list.delete(data);
            } else if (option == 4) {
                int length = list.length();
                System.out.println("Length of the Circular Linked List: " + length);
            } else if (option != -1) {
                System.out.println("Invalid option. Please try again.");
            }
        } while (option != -1);
        System.out.println("Final Circular Linked List:");
        list.display();
    }
}
