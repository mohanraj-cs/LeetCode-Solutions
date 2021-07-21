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

// O(N*2) optimsed brute force
class Solution {
  public String longestPalindrome(String s) {
      String res = "";
      for(int i=0; i<s.length(); i++) {
          String s1 = extendPalindrome(s, i, i), s2 = extendPalindrome(s, i, i+1);
          if(s1.length() > res.length()) 
              res = s1;
          if(s2.length() > res.length())
              res = s2;
      }
      return res;
  }
  public String extendPalindrome(String s, int l, int r) {
      for(; l>=0 && r<s.length(); l--, r++) {
          if(s.charAt(l) != s.charAt(r))
              break;
      }
      return s.substring(l+1,r);
  }
}