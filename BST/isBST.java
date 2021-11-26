import java.util.*;
class isBST
{
  static class Node {
    int data; // data used as key value
    Node leftChild;
    Node rightChild;
    public Node()  {
      data=0;
    }
    public Node(int d)  {
      data=d;
    }
  }
  static class Result {
    static boolean solve(Node temp,int min,int max){
      if(temp==null)
        return true;
      if(temp.data<=min || temp.data >= max)
        return false;
      boolean left=solve(temp.leftChild,min,temp.data);
      boolean right=solve(temp.rightChild,temp.data,max);
      return left && right;
    }
    static int isBinarySearchTree(Node t1) {
      // Write your code here
      if(solve(t1,Integer.MIN_VALUE,Integer.MAX_VALUE))
        return 1;
      return 0;
    }
  }
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
  static Node insertLevelOrder(int arr[], Node root, int i, int n)
  {
    if (i < n)
    {
      Node temp = new Node(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }
  public static void main(String[] args)
  {
    int a[]=new int[10];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    s.close();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    System.out.println(Result.isBinarySearchTree(root));
    
  }
}