import java.util.Iterator;
import java.util.Stack;

// Data structure to store a binary tree node
class Node {
    int data;
    Node left, right;

    // Function to create a new binary tree node having a given key
    public Node(int key) {
        data = key;
        left = right = null;
    }
}

class IterativeTraversals {
    // Iterative function to perform inorder traversal on the tree
    public static void inorderIterative(Node root) {
        // create an empty stack
        Stack<Node> stack = new Stack<>();

        // start from the root node (set current node to the root node)
        Node curr = root;

        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null) {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                curr = stack.pop();
                System.out.print(curr.data + " ");

                curr = curr.right;
            }
        }
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                st.push(temp.right);
            if (temp.left != null)
                st.push(temp.left);
        }
    }

    public static void postOrderTwoStacks(Node root) {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.empty()) {
            Node temp = st1.pop();
            st2.push(temp);
            if (temp.left != null)
                st1.push(temp.left);
            if (temp.right != null)
                st1.push(temp.right);
        }
        while (!st2.empty()) {
            System.out.print(st2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        /*
         * Construct the following tree 1 / \ / \ 2 3 / / \ / / \ 4 5 6 / \ / \ 7 8
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        inorderIterative(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrderTwoStacks(root);
    }
}