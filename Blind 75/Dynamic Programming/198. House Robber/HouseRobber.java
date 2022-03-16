//Iterative + 2 variables (bottom-up)
/* the order is: prev2, prev1, num  */
public int rob(int[] nums) {
    if (nums.length == 0)
        return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num: nums) {
        int tmp = prev1;
        prev1 = Math.max(prev1, prev2 + num);
        prev2 = tmp;
    }
    return prev1;
}

//Iterative + memo (bottom-up)
// this should run in O(n) time. Space complexity is O(n) as well, because of the recursion stack
public int rob(int[] nums) {
    if (nums.length == 0)
        return 0;
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
    }
    return dp[nums.length];
}

// Recursive + memo (top-down).
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}
// Recursive (top-down)
class Solution {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0)
            return 0;
        int prev1 = rob(nums, i - 1); // selected the robber gets all the possible loot from robbery of i-1 and all the following buildings
        int prev2 = rob(nums, i - 2) + nums[i]; // she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows
        return Math.max(prev1, prev2);
    }
}
