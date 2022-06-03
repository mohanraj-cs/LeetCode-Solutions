class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int k) {
        if (root == null)
            return k;

        int l = maxDepth(root.left, k + 1);
        int r = maxDepth(root.right, k + 1);

        return Math.max(l, r);
    }
}
//Recurssive
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

// DFS and BFS?
