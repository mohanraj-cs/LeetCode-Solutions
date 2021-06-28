// O(n*3)

class Solution {
    public int lengthOfLongestSubstring(String str) {
        int result = 0;
        int n = str.length();
        for(int i=0; i<n; i++) {
            for(int j=i; j<n ; j++) {
                if(isUniqueString(str, i, j)) {
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }
    
    public boolean isUniqueString(String str, int start, int end) {
        int[] charArr = new int[128];
        for(int i=start; i<=end; i++) {
            char ch = str.charAt(i);
            charArr[ch]++;
            if(charArr[ch] > 1) {
                return false;
            }
        }
        return true;
    }
}
