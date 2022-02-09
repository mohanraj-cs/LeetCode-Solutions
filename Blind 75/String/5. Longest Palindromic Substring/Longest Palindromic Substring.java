// O(N*2) optimsed Solution
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extendPalindrome(s, i, i); //assume odd length, try to extend Palindrome as possible
            String s2 = extendPalindrome(s, i, i + 1); //assume even length.
            if (s1.length() > res.length())
                res = s1;
            if (s2.length() > res.length())
                res = s2;
        }
        return res;
    }
    public String extendPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r))
                break;
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}

// storing length alone instead of string - 1.
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

// storing length alone instead of string - 2.
class Solution {
    public String longestPalindrome(String s) {
        int max = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i), len2 = extend(s, i, i + 1);
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx + max);
    }

    private int extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i - 2 + 1; // 2 means current two unmatched char
    }
}

//DP
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;

        int maxStart = 0, maxLen = 1;
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (maxLen < end - start + 1) {
                            maxStart = start;
                            maxLen = end - start + 1;
                        }
                    }
                }

            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }
}

// O(N*3) Brute force solution
class Solution {
  public String longestPalindrome(String str) {
      int len = str.length();
      int start = 0, maxLength = 1;
      for(int i=0; i<len; i++) {
          for(int j=i; j<len; j++) {
              int currMax = j-i+1, flag = 1;
              for(int k=0; k< currMax/2; k++) {
                  if(str.charAt(i + k) != str.charAt(j - k)) {
                      flag = 0;
                  }
              }
              if(flag!=0 && currMax > maxLength) {
                  start = i;
                  maxLength = currMax;
              }
          }
      }
      return str.substring(start, start+maxLength);
  }
}
