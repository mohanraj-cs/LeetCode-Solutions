//O(n) - Hash Map
public int lengthOfLongestSubstring(String s) {
    Map < Character, Integer > map = new HashMap < > ();
    int begin = 0, end = 0, res = 0;
    while (end < s.length()) {
        char ch = s.charAt(end);
        if (map.containsKey(ch)) {
            begin = Math.max(map.get(ch) + 1, begin);
        }
        map.put(ch, end);
        res = Math.max(res, end - begin + 1);
        end++;
    }
    return res;
}

// O(n) - Hash Map, alternative with hashing count instead of index
public int lengthOfLongestSubstring(String s) {
    Map < Character, Integer > map = new HashMap < > ();
    int start = 0, end = 0, counter = 0, res = 0;

    while (end < s.length()) {
        char c = s.charAt(end);
        map.put(c, map.getOrDefault(c, 0) + 1);
        if (map.get(c) > 1) { // if (map.get(c) == 2) {
            counter++;
        }
        end++;
        while (counter > 0) {
            char tempc = s.charAt(start);
            if (map.get(tempc) > 1) { //if (map.get(tempc) == 2)
                counter--;
            }
            map.put(tempc, map.get(tempc) - 1);
            start++;
        }
        res = Math.max(res, end - start);
    }
    return res;
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
