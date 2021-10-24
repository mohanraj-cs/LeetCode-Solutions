public int countSubstrings(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
        res += countPalindromes(s, i, i); //odd length
        res += countPalindromes(s, i, i + 1); //even length
    }
    return res;
}
public int countPalindromes(String s, int l, int r) {
    int count = 0;
    while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
        l--;
        r++;
        count++;
    }
    return count;
}