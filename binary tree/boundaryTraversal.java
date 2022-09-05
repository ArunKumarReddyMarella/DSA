import java.io.*;
import java.util.*;

class boundaryTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class GFG {
        static Node buildTree(String str) {
            // Corner Case
            if (str.length() == 0 || str.equals('N'))
                return null;
            String[] s = str.split(" ");

            Node root = new Node(Integer.parseInt(s[0]));
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            // Starting from the second element
            int i = 1;
            while (!q.isEmpty() && i < s.length) {
                // Get and remove the front of the queue
                Node currNode = q.remove();

                // Get the current node's value from the string
                String currVal = s[i];

                // If the left child is not null
                if (!currVal.equals("N")) {

                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));

                    // Push it to the queue
                    q.add(currNode.left);
                }

                // For the right child
                i++;
                if (i >= s.length)
                    break;
                currVal = s[i];

                // If the right child is not null
                if (!currVal.equals("N")) {

                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));

                    // Push it to the queue
                    q.add(currNode.right);
                }

                i++;
            }

            return root;
        }

        public static void main(String args[]) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t > 0) {
                String s = br.readLine();
                Node root = buildTree(s);

                Solution T = new Solution();

                ArrayList<Integer> res = T.boundary(root);
                for (Integer num : res)
                    System.out.print(num + " ");
                System.out.println();
                t--;
            }
        }
    }

    static class Solution {
        void leftBoundary(Node temp, ArrayList<Integer> result) {
            if (temp == null)
                return;
            if (temp.left != null) {
                result.add(temp.data);
                leftBoundary(temp.left, result);
            } else if (temp.right != null) {
                result.add(temp.data);
                leftBoundary(temp.right, result);
            }

        }

        void leaf(Node temp, ArrayList<Integer> result) {
            if (temp == null)
                return;
            leaf(temp.left, result);
            if (temp.left == null && temp.right == null)
                result.add(temp.data);
            leaf(temp.right, result);
        }

        void ReverseRightBoundary(Node temp, ArrayList<Integer> result) {
            if (temp == null)
                return;
            if (temp.right != null) {
                ReverseRightBoundary(temp.right, result);
                result.add(temp.data);
            } else if (temp.left != null) {
                ReverseRightBoundary(temp.left, result);
                result.add(temp.data);
            }

        }

        ArrayList<Integer> boundary(Node node) {
            ArrayList<Integer> result = new ArrayList<>();
            if (node == null)
                return result;
            result.add(node.data);
            leftBoundary(node.left, result);
            leaf(node, result);
            ReverseRightBoundary(node.right, result);
            return result;
        }
    }

}