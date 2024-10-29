package Tree.binarysearchtree;

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root , int val){
       if(root.data < val){
        root.right = delete(root.right, val);
       }
       else if(root.data > val){
        root.left = delete(root.left, val);
       }
       else{
        if(root.right == null && root.left == null){
            return null;
        }
        if(root.left != null){
            return root.left;
        }
        else if (root.right != null){
            return root.right;
        }
        
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            delete(root.right, IS.data);
       }
       return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int[] values = { 8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        if(search(root, 1)){
            System.out.println("Found");
        } else{
            System.out.println("Not Found");
        }

        delete(root, 1);

        inOrder(root);
    }

}
