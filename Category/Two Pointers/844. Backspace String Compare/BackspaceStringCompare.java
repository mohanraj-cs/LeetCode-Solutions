// Time complexity #
// The time complexity of the below algorithm will be O(M+N)O(M+N) where ‘M’ and ‘N’ are the lengths of the two input strings respectively.
//
// Space complexity #
// The algorithm runs in constant space O(1)O(1).
// Solution from grokking
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int l1 = s.length() - 1, l2 = t.length() - 1;
        while (l1 >= 0 || l2 >= 0) { // While there may be chars in build(S) or build (T)
            // Find position of next possible char and skip #
            l1 = getNextValidCharacter(s, l1);
            l2 = getNextValidCharacter(t, l2);
            if (l1 < 0 && l2 < 0)
                return true;

            // If expecting to compare char vs nothing
            if (l1 < 0 || l2 < 0)
                return false;
            // If two actual characters are different
            if (s.charAt(l1) != t.charAt(l2))
                return false;

            l1--;
            l2--;
        }
        return true;
    }

    private int getNextValidCharacter(String s, int idx) {
        int skip = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') // Found a backspace character
                skip++;
            else if (skip > 0) // a non backspace character
                skip--;
            else
                break;
            idx--; // skip a backspace character or a valid character
        }
        return idx;
    }
}

// Using Stack
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        Stack < Character > stack = new Stack();
        for (char c: str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
