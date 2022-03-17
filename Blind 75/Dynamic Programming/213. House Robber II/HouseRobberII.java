class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // Due to Circle adjacent houses, separate into tow groups and solve.
        int rob0 = rob(nums, 0, nums.length - 2); // Rob houses 0 to n - 2.
        int rob1 = rob(nums, 1, nums.length - 1); // Rob houses 1 to n - 1.
        return Math.max(rob0, rob1);
    }

    public int rob(int[] nums, int l, int r) {
        int prev1 = 0, prev2 = 0;
        for (int i = l; i <= r; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = tmp;
        }
        return prev1;
    }
}

//Long version
class Solution {
  public int rob(int[] nums) {
      if (nums.length == 1) return nums[0];
      return Math.max(rob0(nums), rob1(nums));
  }

  public int rob0(int[] nums) {
      int preMax = 0, curMax = 0;
      for (int i = 0; i < nums.length - 1; i++) {
          int t = curMax;
          curMax = Math.max(preMax + nums[i], curMax);
          preMax = t;
      }
      return curMax;
  }

  public int rob1(int[] nums) {
      int preMax = 0, curMax = 0;
      for (int i = 1; i < nums.length; i++) {
          int t = curMax;
          curMax = Math.max(preMax + nums[i], curMax);
          preMax = t;
      }
      return curMax;
  }
}
