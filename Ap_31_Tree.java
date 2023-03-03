package com.krushnaDSA;

import java.util.LinkedList;
import java.util.Queue;

public class Ap_31_Tree {
    static class  Node{
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }
    static class BinaryTree{
        static  int ind =-1 ;
        // this function take the preOrder of the traversal array ;
        public static Node buildTree(int nodes[]){
            ind++ ;
            if (nodes[ind]==-1){
                return  null ;
            }
            Node newNode = new Node(nodes[ind]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode ;

        }
        public  static void preOrder(Node root){
            if (root== null){
//                System.out.print(-1 + " ");
                return ;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public  static void inOrder(Node root){
            if (root== null){
//                System.out.print(-1 + " ");
                return ;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public  static void postOrder(Node root){
            if (root== null){
//                System.out.print(-1 + " ");
                return ;
            }
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data + " ");

        }
        public  void  levelOrder(Node root){
            if (root== null){
//                System.out.print(-1 + " ");
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode==null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null){
                        q.add(currNode.left);
                    }
                    if (currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }

        }
        // height of the Tree
        public int height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int h = Math.max(lh , rh ) +1 ;
            return  h ;
        }

        // count the Nodes
        public  int countNode(Node root){
            if(root==null){
                return 0;
            }
            int leftCount = countNode(root.left) ;
            int rightCount = countNode(root.right) ;
            return  leftCount + rightCount + 1;

        }

        // Sum of the Nodes
        public  int sumOfNodes(Node root ){
            if(root==null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSUm = sumOfNodes(root.right);
            return  leftSum + rightSUm + root.data ;
        }

        // Diameter problem
        public int diameter(Node root){
            if (root==null){
                return  0;
            }
            int leftDiam = diameter(root.left);
            int leftHeight = height(root.left);
            int rightDiam = diameter(root.right);
            int rightHeight = height(root.right);
            int seftDiam = leftHeight + rightHeight + 1;
            return  Math.max(seftDiam , Math.max(leftDiam , rightDiam));
        }

    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree() ;
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("Pre order traversal ");
        tree.preOrder(root);

        System.out.println("\nIn order traversal ");
        tree.inOrder(root);
        System.out.println("\nPost Order Traversal ");
        tree.postOrder(root);
        System.out.println("\nLever Order Traversal ");
        tree.levelOrder(root);
        System.out.println("The Height of the tree");
        int hight = tree.height(root);
        System.out.println(hight);
        System.out.println("The Node of Nodes : "+ tree.countNode(root));
        System.out.println("The Sum of the Nodes Value : "+ tree.sumOfNodes(root));


    }
}
