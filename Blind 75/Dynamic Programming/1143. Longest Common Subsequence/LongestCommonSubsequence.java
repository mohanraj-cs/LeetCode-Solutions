// Bottom-up DP
// For every i in s1, j in s2, we will choose one of the following two options:

// if two characters match, length of the common subsequence would be 1 plus the length of the common subsequence till the i-1 andj-1 indexes
// if two characters doesn't match, we will take the longer by either skipping i or j indexes

public int longestCommonSubsequence(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[m][n];
}

// Method 2:

// Space Optimization

// Obviously, the code in method 1 only needs information of previous row to update current row. So we just use a two-row 2D array to save and update the matching results for chars in s1 and s2.


// Brute Force
// TLE - not feassible solution
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (text1.charAt(i) == text2.charAt(j))
            return 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
        else
            return Math.max(
                longestCommonSubsequence(text1, text2, i + 1, j),
                longestCommonSubsequence(text1, text2, i, j + 1)
            );
    }
