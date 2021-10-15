//Recursive
class Solution {
	public List < Integer > inorderTraversal(TreeNode root) {
		List < Integer > list = new ArrayList < > ();
		inorder(root, list);
		return list;
	}

	private void inorder(TreeNode root, List < Integer > list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
}

//Iterative
public List < Integer > inorderTraversal(TreeNode root) {
    List < Integer > list = new ArrayList < > ();
    if (root == null)
        return list;
    Stack < TreeNode > stack = new Stack < > ();
    while (root != null || !stack.empty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
    }
    return list;
}