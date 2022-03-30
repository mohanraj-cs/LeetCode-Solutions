// Optimzed with pre condition
public boolean canJump(int[] nums) {
    int n = nums.length, maxReachable = 0;
    for (int i = 0; i <= maxReachable; i++) {
        maxReachable = Math.max(i + nums[i], maxReachable);
        if (maxReachable >= n - 1)
            return true;
    }
    return false;
}

// O(n) Greedy Algo
public boolean canJump(int[] nums) {
    int n = nums.length, maxReachable = 0, i;
    for (i = 0; i < n && i <= maxReachable; i++) {
      maxReachable = Math.max(i + nums[i], maxReachable);
    }
    return i == n;
}

// DP - Optimized with backward scanning 72 ms
// https://leetcode.com/problems/jump-game/discuss/1150021/C%2B%2B-Solutions
public boolean canJump(int[] nums) {
    boolean[] state = new boolean[nums.length];
    state[0] = true;
    for (int i = 1; i < nums.length; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (state[j] && (j + nums[j] >= i)) { // from j, we can jump to i
                state[i] = true;
                break;
            }
        }
    }
    return state[nums.length - 1];
}

// DP - not efficient - 577ms
// state(i) as whether we can jump to i.
// state(i) is true if any state(j) is true for j can jump to i.
// Goal state is state(nums.length - 1).
// https://leetcode.com/problems/jump-game/discuss/541554/DP-and-Greedy
public boolean canJump(int[] nums) {
    boolean[] state = new boolean[nums.length];
    state[0] = true;
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (state[j] && (j + nums[j] >= i)) { // from j, we can jump to i
                state[i] = true;
                break;
            }
        }
    }
    return state[nums.length - 1];
}

// Recurssion with Memo
class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJump(nums, 0, memo);
    }

    private boolean canJump(int[] nums, int k, int[] memo) {
        if (k >= nums.length - 1)
            return true;

        if (nums[k] == 0)
            return false;

        if (memo[k] != -1)
            return memo[k] == 1;

        for (int i = 1; i <= nums[k]; i++) {
            if (canJump(nums, k + i, memo)) {
                memo[k] = 1;
                return true;
            }
        }

        memo[k] = 0;
        return false;
    }
}
