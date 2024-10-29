package Tree.binarytree;

import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
           
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh , rh) +1;
        }
    }

    public static void main(String args[]) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1,3,-1, 6, -1, -1 };

        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);

        System.out.print("PreOrder : ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("PostOrder : ");
        tree.postOrder(root);
        System.out.println();

        System.out.println("LevelOrder : ");
        tree.levelOrder(root);
        System.out.println();

        System.out.print("Height : ");
        int h = tree.height(root);
        System.out.print(h);
        
    }

}
