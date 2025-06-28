package Heaps;
import java.util.*;
public class Priority_Queue {
    public static class Student implements Comparable<Student>{
            String name;
            int rank;
            
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public  int compareTo(Student s2){
            return this.rank - s2.rank;
        }   
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);

        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek() + " ");
        //     pq.remove();
        // }

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 3));
        pq.add(new Student("C", 2));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}

