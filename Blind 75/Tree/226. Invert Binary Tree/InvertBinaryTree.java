//Recursion DFS
public TreeNode invertTree(TreeNode root) {
  if (root == null) {
    return null;
  }

  TreeNode left = root.left, right = root.right;
  root.left = invertTree(right);
  root.right = invertTree(left);
  return root;
}


// The above solution is correct, but it is also bound to the application stack, which means that it's no so much scalable
// - (you can find the problem size that will overflow the stack and crash your application), so more robust solution would be to use stack data structure.
// LIFO
// https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
public TreeNode invertTree(TreeNode root) {
  if (root == null) {
    return null;
  }

  Deque < TreeNode > stack = new LinkedList < > ();
  stack.push(root);

  while (!stack.isEmpty()) {
    TreeNode node = stack.pop();
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    if (node.left != null) {
      stack.push(node.left);
    }
    if (node.right != null) {
      stack.push(node.right);
    }
  }
  return root;
}

// Finally we can easly convert the above solution to BFS - or so called level order traversal.
// FIFO
public TreeNode invertTree(TreeNode root) {

    if (root == null) {
        return null;
    }

    final Queue < TreeNode > queue = new LinkedList < > ();
    queue.offer(root);

    while (!queue.isEmpty()) {
        final TreeNode node = queue.poll();
        final TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
    }
    return root;
}
