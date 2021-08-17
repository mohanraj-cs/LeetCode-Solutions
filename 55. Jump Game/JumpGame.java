// O(n) Greedy Algo
public boolean canJump(int[] nums) {
    int n = nums.length, maxReachable = 0, i;
    for(i = 0; i < n && i <= maxReachable; i++) 
        maxReachable = Math.max(i + nums[i], maxReachable);
    return i == n;
}


// Optimzed with pre condition
public boolean canJump(int[] nums) {
  int n = nums.length, maxReachable = 0;
  for(int i = 0; i <= maxReachable; i++) {
      maxReachable = Math.max(i + nums[i], maxReachable);
      if(maxReachable >= n-1)
          return true;
  }
  return false;
}