//O(n) - Hash Map

class Solution {
    public int lengthOfLongestSubstring(String str) {
        int result = 0;
        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
        int length = str.length();
        for (int l = 0, r = 0; r < length; r++) {
            char ch = str.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(map.get(ch), l);
            }
            result = Math.max(result, r - l + 1);
            map.put(ch, r + 1);
        }
        return result;
    }
}

// O(2n) - Hash set 
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set < Character > set = new HashSet < > ();

    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }

    return max;
}

// O(n*3)

class Solution {
    public int lengthOfLongestSubstring(String str) {
        int result = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isUniqueString(str, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    public boolean isUniqueString(String str, int start, int end) {
        int[] charArr = new int[128];
        for (int i = start; i <= end; i++) {
            char ch = str.charAt(i);
            charArr[ch]++;
            if (charArr[ch] > 1) {
                return false;
            }
        }
        return true;
    }
}