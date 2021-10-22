public int characterReplacement(String s, int k) {
    int len = s.length();
    int[] count = new int[26];
    int maxFreq = 0, res = 0;
    for (int start = 0, end = 0; end < len; end++) {
        count[s.charAt(end) - 'A']++;
        maxFreq = Math.max(maxFreq, count[s.charAt(end) - 'A']);
        if (end - start + 1 - maxFreq > k) {
            count[s.charAt(start) - 'A']--;
            start++;
        }
        res = Math.max(res, end - start + 1);
    }
    return res;
}

// redability trade off for better runtime
public int characterReplacement(String s, int k) {
    int len = s.length();
    int[] count = new int[26];
    int maxFreq = 0, res = 0;
    for (int start = 0, end = 0; end < len; end++) {
        maxFreq = Math.max(maxFreq, ++count[s.charAt(end) - 'A']);
        if (end - start + 1 - maxFreq > k) {
            count[s.charAt(start) - 'A']--;
            start++;
        }
        res = Math.max(res, end - start + 1);
    }
    return res;
}