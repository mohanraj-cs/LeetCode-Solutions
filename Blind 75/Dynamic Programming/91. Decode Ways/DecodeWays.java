// 1- Recursion O(2^n). A char may be decoded alone or by pairing with the next char.
public int numDecodings(String s) {
    return s.length() == 0 ? 0 : numDecodings(0, s);
}
private int numDecodings(int p, String s) {
    int n = s.length();
    if (p == n)
        return 1;
    if (s.charAt(p) == '0')
        return 0;
    int res = numDecodings(p + 1, s);
    if (p < n - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7')))
        res += numDecodings(p + 2, s);
    return res;
}

// 2- Memoization O(n)
public int numDecodings(String s) {
    int n = s.length();
    Integer[] mem = new Integer[n];
    return s.length() == 0 ? 0 : numDecodings(0, s, mem);
}
private int numDecodings(int p, String s, Integer[] mem) {
    int n = s.length();
    if (p == n)
        return 1;
    if (s.charAt(p) == '0')
        return 0;
    if (mem[p] != null)
        return mem[p];
    int res = numDecodings(p + 1, s, mem);
    if (p < n - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7')))
        res += numDecodings(p + 2, s, mem);
    return mem[p] = res;
}

// 3 - DP 
public int numDecodings(String s) {
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

// 4 - Constant Space
public int numDecodings(String s) {
    int dp1 = 1, dp2 = 0, n = s.length();
    for (int i = n - 1; i >= 0; i--) {
        int dp = s.charAt(i) == '0' ? 0 : dp1;
        if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
            dp += dp2;
        dp2 = dp1;
        dp1 = dp;
    }
    return dp1;
}