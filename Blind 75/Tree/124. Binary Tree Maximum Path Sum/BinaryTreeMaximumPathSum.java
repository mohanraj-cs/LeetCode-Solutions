class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum; // as maxSum will always store the result
    }

    public int maxPathSumHelper(TreeNode root) {
        // base case
        if (root == null) return 0;

        // recursing through left and right subtree
        int leftPath = maxPathSumHelper(root.left);
        int rightPath = maxPathSumHelper(root.right);

        // finding all the four paths and the maximum between all of them
        int leftRightMax = Math.max(leftPath, rightPath);
        int oneRootPathMax = Math.max(root.val, (root.val + leftRightMax));
        int allPathMax = Math.max(oneRootPathMax, root.val + leftPath + rightPath);

        // Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, allPathMax);

        // returning the value if root was part of the answer
        return oneRootPathMax;
    }
}
