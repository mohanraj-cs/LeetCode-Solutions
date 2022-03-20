// Constant Space
public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int prev1 = 1, prev2 = 0, n = s.length();
    for (int i = n - 1; i >= 0; i--) {
        int dp = s.charAt(i) == '0' ? 0 : prev1;
        if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
            dp += prev2;
        prev2 = prev1;
        prev1 = dp;
    }
    return prev1;
}

// Top Down - DP
public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= n; i++) {
        int first = Integer.valueOf(s.substring(i - 1, i));
        int second = Integer.valueOf(s.substring(i - 2, i));
        if (first >= 1) {
            dp[i] += dp[i - 1];
        }
        if (second >= 10 && second <= 26) {
            dp[i] += dp[i - 2];
        }
    }
    return dp[n];
}

// Bottom Up - DP
public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
        if (s.charAt(i) != '0') {
            dp[i] = dp[i + 1];
            if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
                dp[i] += dp[i + 2];
        }
    }
    return dp[0];
}

// Memoization O(n)
class Solution {
    private Integer[] mem;

    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        mem = new Integer[s.length()];
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int p) {
        if (p == s.length())
            return 1;
        if (s.charAt(p) == '0')
            return 0;
        if (mem[p] != null)
            return mem[p];
        int res = numDecodings(s, p + 1);
        if (p < s.length() - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7')))
            res += numDecodings(s, p + 2);
        return mem[p] = res;
    }
}

// Recursion O(2^n). A char may be decoded alone or by pairing with the next char.
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int p) {
        if (p == s.length())
            return 1;
        if (s.charAt(p) == '0')
            return 0;
        int res = numDecodings(s, p + 1);
        if (p < s.length() - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7')))
            res += numDecodings(s, p + 2);
        return res;
    }
}
