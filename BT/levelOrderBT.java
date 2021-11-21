import java.util.*;

class levelOrderBT {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class binaryTree {
        binaryTree() {
            Node root = null;
        }

        void insert(int data) {
            Node temp = new Node(data);
            if (root == null) {
                root = temp;
            } else {

            }
        }

        ArrayList<Integer> levelOrder(Node node) {
            ArrayList<Integer> resultArray = new ArrayList<>();
            if (node == null)
                return resultArray;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while (!isEmpty(queue)) {
                Node current = queue.poll();
                resultArray.add(current.data);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            return resultArray;
        }
    }
}