// Further inspecting the above code, pre[j] is just the cur[j] before the update. So we can further reduce the memory usage to one row.
public int uniquePaths(int m, int n) {
    int[] cur = new int[n];

    for (int i = 0; i < n; i++)
        cur[i] = 1;

    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            cur[j] = cur[j] + cur[j - 1];

    return cur[n - 1];
}

// The below solution runs in O(m * n) time and costs O(m * n) space.
// However, you may have noticed that each time when we update dp[i][j], we only need dp[i - 1][j] (at the previous row) and dp[i][j - 1] (at the current row).
// So we can reduce the memory usage to just two rows (O(n)).
public int uniquePaths(int m, int n) {
    int[] cur = new int[n];
    int[] pre = new int[n];

    for (int i = 0; i < n; i++) {
        pre[i] = 1;
        cur[i] = 1;
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++)
            cur[j] = pre[j] + cur[j - 1];

        pre = cur;
    }

    return pre[n - 1];
}


// DP Bottom Up
// Bottom - Up , since solve from the start of the input 0,0;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}

// Recursion with memo
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1, new int[m][n]);
    }

    private int helper(int m, int n, int[][] memo) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 || n == 0)
            return 1;
        if (memo[m][n] > 0)
            return memo[m][n];

        memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
        return memo[m][n];
    }
}


// Recursion - 2^m + n
// Top - Bottom, since solve from the end result m - 1, n - 1;
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }

    private int helper(int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 || n == 0)
            return 1;
        return helper(m - 1, n) + helper(m, n - 1);
    }
}
