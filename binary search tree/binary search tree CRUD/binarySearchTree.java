class binarySearchTree {
	static class Node
	{
		int data;
		Node left, right;

		public Node(int item)
		{
			this.data = item;
			this.left = this.right = null;
		}
	}
	static Node root;
	binarySearchTree()
	{
		root = null;
	}
	void insert(int key)
	{
		root = insertRec(root, key);
	}
	Node insertRec(Node root, int key)
	{
		if (root == null)
		{
			root = new Node(key);
			return root;
		}
		if (key < root.data)
			root.left = insertRec(root.left, key);
		else if (key > root.data)
			root.right = insertRec(root.right, key);
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder()
	{
		inorderRec(root);
	}

	// A utility function to
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);
		}
	}

	public static Node minNode(Node temp){
		if(temp.left==null)
			return temp;
		return minNode(temp.left);
	}
	
	public Node delete(Node root,int x){
		if(root == null)
			return null;
		if(x<root.data)
			root.left = delete(root.left, x);
		else if(x>root.data)
			root.right = delete(root.right,x);
		else{
			if(root.left==null){
				Node temp=root.right;
				return temp;
			}
			else if(root.right==null){
				Node temp=root.left;
				return temp;
			}
			else{
				Node temp=minNode(root.right);
				int tem=temp.data;
				temp.data=root.data;
				root.data=tem;
				root.right=delete(root.right, x);
			}
		}
		return root;

	}

	// Driver Code
	public static void main(String[] args)
	{
		binarySearchTree tree = new binarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder();
		System.out.println();
		tree.delete(root, 70);
		tree.inorder();
	}
}
// This code is contributed by Ankur Narain Verma
