import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class checkBalancedTree {
    // Initial Template for Java

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class GfG {

        static Node buildTree(String str) {

            if (str.length() == 0 || str.charAt(0) == 'N') {
                return null;
            }

            String ip[] = str.split(" ");
            // Create the root of the tree
            Node root = new Node(Integer.parseInt(ip[0]));
            // Push the root to the queue

            Queue<Node> queue = new LinkedList<>();

            queue.add(root);
            // Starting from the second element

            int i = 1;
            while (queue.size() > 0 && i < ip.length) {

                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();

                // Get the current node's value from the string
                String currVal = ip[i];

                // If the left child is not null
                if (!currVal.equals("N")) {

                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }

                // For the right child
                i++;
                if (i >= ip.length)
                    break;

                currVal = ip[i];

                // If the right child is not null
                if (!currVal.equals("N")) {

                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));

                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }

            return root;
        }

        static void printInorder(Node root) {
            if (root == null)
                return;

            printInorder(root.left);
            System.out.print(root.data + " ");

            printInorder(root.right);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());

            while (t > 0) {
                String s = br.readLine();
                Node root = buildTree(s);
                Tree g = new Tree();

                if (g.isBalanced(root) == true)
                    System.out.println(1);
                else
                    System.out.println(0);
                t--;

            }
        }

    }

    // } Driver Code Ends

    // User function Template for Java

    /*
     * A binary tree node class class Node { int data; Node left,right;
     * 
     * Node(int d) { data = d; left = right = null; } }
     */

    class Tree {
        boolean flag;

        Tree() {
            flag = true;
        }

        // Function to check whether a binary tree is balanced or not.
        /*
         * boolean solve(Node temp,int curHeight){ if(temp==null) return true;
         * maxHeight=Math.max(maxHeight,curHeight); if(temp.right==null &&
         * temp.left==null){ if(Math.abs(maxHeight-curHeight)>1){ return false; } }
         * return solve(temp.left,curHeight+1)&&solve(temp.right,curHeight+1); }
         */
        int solve(Node root) {
            if (root == null)
                return 0;
            int lh = solve(root.left);
            int rh = solve(root.right);
            // System.out.println(root.data+" "+rh+" "+lh);
            if (Math.abs(rh - lh) > 1) {
                flag = false;
            }
            return Math.max(lh, rh) + 1;
        }

        boolean isBalanced(Node root) {
            // Your code here
            solve(root);
            return flag;
        }
    }

}