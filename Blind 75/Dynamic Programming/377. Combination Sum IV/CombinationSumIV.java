// bottom-up approach - DP
// https://www.youtube.com/watch?v=PomVtsn7ZoM
public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                dp[i] += dp[i - nums[j]];
            }
        }
    }
    return dp[target];
}

// order-1:
//
// for each sum in dp[]
//     for each num in nums[]
//         if (sum >= num)
//             dp[sum] += dp[sum-num];
// order-2:
//
// for each num in nums[]
//     for each sum in dp[]  >= num
//         dp[sum] += dp[sum-num];
// order-1 is used to calculate the number of combinations considering different sequences
// order-2 is used to calculate the number of combinations NOT considering different sequences
// Give an example nums[] = {1, 2, 3}, target = 4
// order-1 considers the number of combinations starting from 1, 2, and 3, respectively, so all sequences are considered as the graph below.
//
// 1 --> 1 --> 1 --> 1 --> (0)
// 1 --> 1 --> 2 --> (0)
// 1 --> 2 --> 1 --> (0)
// 1 --> 3 --> (0)
//
// 2 --> 1 --> 1 --> (0)
// 2 --> 2 --> (0)
//
// 3 --> 1 --> (0)
//
// order-2 considers the number of combinations starting from 0 (i.e., not picking anyone), and the index of the num picked next must be >= the index of previous picked num, so different sequences are not considered, as the graph below.
//
// (0) --> 1 --> 1 --> 1 --> 1
// (0) --> 1 --> 1 --> 2
// (0) --> 1 --> 3
// (0) --> 2 --> 2

// ------------------------------
// Top Down approach - recursion with mem cache
class Solution {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}

// Recursion
public int combinationSum4(int[] nums, int target) {
    if (target == 0) {
        return 1;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += combinationSum4(nums, target - nums[i]);
        }
    }
    return res;
}
