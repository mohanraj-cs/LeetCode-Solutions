// with DP
public int climbStairs(int n) {
    if (n <= 1 ) return n;

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i - 2];
    }
    return dp[n];
}

//without DP | O(1) space
public int climbStairs(int n) {
    // base cases
    if(n <= 2) return n;
    int total_ways = 0;
    int two_steps_before = 1; // when n = 3, [n-2] way is 2
    int one_step_before = 2; // when n = 3, [n-1] way is 2

    for (int i = 2; i < n; i++) {
        total_ways = one_step_before + two_steps_before; // Add the Total Ways 
        // Move the last 2
        two_steps_before = one_step_before; // Store two steps from current one step before value
        one_step_before = total_ways; // Store one step from current value
    }
    return total_ways;
}