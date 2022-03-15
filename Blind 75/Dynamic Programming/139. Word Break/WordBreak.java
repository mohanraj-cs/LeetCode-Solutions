//DP | O(n^2)
// leetcode
// -
// leetcode
//  -
// --
// leetcode
//   -
//  --
// ---
// leetcode
//    -
//   --
//  ---
// ----     !!! leet
// leetcode
//     -
//    --
//   ---
//  ----
// -----
// leetcode
//      -
//     --
//    ---
//   ----
//  -----
// ------
// leetcode
//       -
//      --
//     ---
//    ----
//   -----
//  ------
// -------
// leetcode
//        -
//       --
//      ---
//     ----  !!! code
// All the lines below won't run b/c of break;
// Index 4 is a valid start index, and index 4 - index 7 make up the word `code`
// We can break once we've found any connecting word because
// all we're trying to do is find SOME valid way to connect to s[i].
// Once we've found SOME word that does that, there's no need to continue checking.
//    -----
//   ------
//  -------
// --------
// just want to add some comments for the time complexity:
// First DP: [length of s][size of dict][avg length of words in dict]
// Second DP: [length of s]^3
//
// BTW, for this kind of problem, which time complexity is [length of s][size of dict][avg length of words in dict]. We can usually remove [size of dict] by using Tire, remove [avg length of words in dict] by KMP, and what's more, remove both [size of dict] and [avg length of words in dict] by AC-automata. And of course these are all doable for this problem.
// This is just a insight for people who want to think deeper about this problem, hope it can help you :)
// Average O(n^2)
public boolean wordBreak(String s, List < String > wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    Set < String > set = new HashSet < > (wordDict);

    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (dp[j] && set.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
}

// Recoursion with mem - O(n^3)
class Solution {
    public boolean wordBreak(String s, List < String > wordDict) {
        Boolean[] mem = new Boolean[s.length()];
        Set < String > set = new HashSet < > (wordDict);
        return wordBreak(s, 0, set, mem);
    }

    private boolean wordBreak(String s, int p, Set < String > set, Boolean[] mem) {
        int n = s.length();
        if (p == n) {
            return true;
        }
        if (mem[p] != null) {
            return mem[p];
        }
        for (int i = p + 1; i <= n; i++) {
            if (set.contains(s.substring(p, i)) && wordBreak(i, s, set, mem)) {
                return mem[p] = true;
            }
        }
        return mem[p] = false;
    }
}

// Recursion - TLE - not feassible
class Solution {
    public boolean wordBreak(String s, List < String > wordDict) {
        // put all words into a hashset
        Set < String > set = new HashSet < > (wordDict);
        return wb(s, set);
    }

    private boolean wb(String s, Set < String > set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
