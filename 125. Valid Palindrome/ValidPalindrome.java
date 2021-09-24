public boolean isPalindrome(String s) {
    char[] charArr = s.toCharArray();
    int i = 0, j = charArr.length - 1;
    while(i < j) {
        if (!Character.isLetterOrDigit(charArr[i])) 
            i++;
        else if (!Character.isLetterOrDigit(charArr[j])) 
            j--;
        else {
            if (Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[j]))
                return false;
            i++;
            j--;
        }
    }
    return true;
}

// Method 2
public boolean isPalindrome(String s) {
    if (s.isEmpty()) {
        return true;
    }
    int head = 0, tail = s.length() - 1;
    char cHead, cTail;
    while (head <= tail) {
        cHead = s.charAt(head);
        cTail = s.charAt(tail);
        if (!Character.isLetterOrDigit(cHead)) {
            head++;
        } else if (!Character.isLetterOrDigit(cTail)) {
            tail--;
        } else {
            if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                return false;
            }
            head++;
            tail--;
        }
    }
    return true;
}