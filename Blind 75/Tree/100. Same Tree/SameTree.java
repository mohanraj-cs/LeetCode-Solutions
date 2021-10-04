//Recusursion
public boolean isSameTree(TreeNode p, TreeNode q) {
	if(p == null && q == null) 
		return true;
	if(p == null || q == null) 
		return false;
	if(p.val == q.val)
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	return false;
}

//Commented Version
public boolean isSameTree(TreeNode p, TreeNode q) {
    
    // Equal nullity denotes that this branch is the same (local equality)
    // This is a base case, but also handles being given two empty trees
    if (p == null && q == null) 
		return true;
    
    // Unequal nullity denotes that the trees aren't the same
    // Note that we've already ruled out equal nullity above
    else if (p == null || q == null) 
		return false;
        
    // Both nodes have values; descend iff those values are equal
    // "&&" here allows for any difference to overrule a local equality
    else if (p.val == q.val) 
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    
    // If we're here, both nodes have values, and they're unequal, so the trees aren't the same
    return false;
}

//Improve replace first two check
	// if (p == NULL || q == NULL)
	// 	return (p == q);

