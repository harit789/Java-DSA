public class CircularLinkedList{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val){
        Node temp = head;
        if(temp == null){
            return;
        }
        if(temp.data == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = temp.next;
            if(n.data == val){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while(temp != head);
    }


    public void display(){
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            while(temp != head);
        }
        System.out.println("head");

    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.display();

        list.delete(2);

        list.display();
    }
}