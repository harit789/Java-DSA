import java.util.*;

public class SinglyLinkedList{
  
    public static class Node{
        int data;
        Node next;

        public  Node(int data){
            this.data=data;
            this.next=null;
        }

        public Node(int data , Node next){
            this.data = data;
            this.next = next;
        }
    }
    
        public static Node head;
        public static Node tail;
        public static int size;

        public void insertFirst(int val){
            Node node = new Node(val);
            if(head == null){
                head = tail =node;
                size+=1;
                return;
            }
            node.next = head;
            head = node;
            size+=1;
        }

        public void insertLast(int val){
            Node node = new Node(val);
            if(head == null){
                head= tail = node;
                return;
            }
            tail.next = node;
            tail = node;
            size+=1;
        }

        public void insertIndex(int index , int val){
            Node node = new Node(val);
            if(index == 0){
                insertFirst(val);
                return;
            }

            if(index == size){
                insertLast(val);
                return;
            }

            Node temp = head;
            for(int i =0 ; i<index-1 ; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }


        public int deleteFirst(){
            int val = head.data;
            if(size == 0){
                System.out.println("LinkedList is empty");
            }
            if(size ==1){
                head=null;
                size=0;
                return val;
            }
            head = head.next;
            size-=1;
            return val;
        }

        public  int deleteLast(){
            if(size==0){
                System.out.println("LinkedList is empty");
            } else if(size==1){
                int val = head.data;
                head = null;
                size =0;
                return val;
            }
            
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = null;
            size -=1;
            return val;
        }

        public  int deleteIndex(int index){
            if(index == 0){
                deleteFirst();
            }
            if(index == size){
                deleteLast();
            }
            Node temp = head;
            for(int i =0 ; i<index -1 ; i++){
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            size-=1;
            return val;
        }

        public int search(int key){
            Node temp = head;
            int idx = 0;
            while(temp != null){
                if(temp.data == key){
                    return idx;
                }
                temp = temp.next;
                idx++;
            }
            return -1;
        }

        
        public  void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data +" -> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
    

        public static void main(String[] args) {
            SinglyLinkedList list  = new SinglyLinkedList();
            list.insertFirst(3);
            list.insertFirst(2);
            list.insertFirst(1);

            list.display();

            list.insertLast(5);
            list.insertLast(6);
            list.insertLast(7);

            list.display();

            list.insertIndex(3, 4);

            list.display();

            list.deleteFirst();

            list.display();

            list.deleteLast();

            list.display();

            list.deleteIndex(1);

            list.display();


        }
}