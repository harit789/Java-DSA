import java.util.*; 

public class DoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void insertFirst(int val) {
        Node node = new Node(val);
        size += 1;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head = node;
        node.prev = null;

    }

    public void insertLast(int val) {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size += 1;
    }

    public void insertIndex(int index, int val) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        size += 1;
    }

    public int delelteFirst() {
        int val = head.data;
        if (head == null) {
            System.out.println("LinkedList is empty");
        }
        if (size == 1) {
            head = tail = null;
            return val;
        }
        Node temp = head;
        head = temp.next;
        head.prev = null;
        size -= 1;
        return val;
    }

    public int deleteLast() {
        int val = tail.data;
        if (tail == null) {
            System.out.println("LinkedList is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
            return val;
        }
        Node temp = tail;
        temp.prev = tail;
        tail.next = null;
        size -= 1;
        return val;
    }

    public int deleteIndex(int index){
        if(index == 0){
            delelteFirst();
        }
        if(index == size){
            deleteLast();
        }
        Node temp = head;
        for(int i =0 ; i<index-1 ; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        size-=1;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.display();

        list.insertLast(4);

        list.display();

        list.insertIndex(4, 5);

        list.display();

        list.delelteFirst();

        list.display();

        list.deleteLast();

        list.display();

        list.deleteIndex(1);

        list.display();
    }
}