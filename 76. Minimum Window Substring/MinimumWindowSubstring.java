public String minWindow(String s, String t) {
    int[] map = new int[128];
    for (char ch: t.toCharArray()) {
        map[ch]++;
    }
    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    while (end < s.length()) {
        if (map[s.charAt(end)] > 0)
            counter--;
        map[s.charAt(end)]--;
        end++;
        while (counter == 0) {
            if (minLen > end - start) {
                minLen = end - start;
                minStart = start;
            }
            map[s.charAt(start)]++;
            if (map[s.charAt(start)] > 0)
                counter++;
            start++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}

//My Comment
public String minWindow(String s, String t) {
    int[] map = new int[128];
    for (char ch: t.toCharArray())
        map[ch]++; // Fill with 1's later it will become 0's other chars will become negative to maintain window
    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    while (end < s.length()) {
        if (map[s.charAt(end)] > 0)
            counter--;
        map[s.charAt(end)]--;
        end++;
        while (counter == 0) {
            if (minLen > end - start) { // Min Len
                minLen = end - start;
                minStart = start;
            }
            map[s.charAt(start)]++; // Negatives become 0's and 0's (the 't' string will become 1) 
            if (map[s.charAt(start)] > 0) // Now we found the start of the window, exit the loop and extend the window
                counter++;
            start++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}

// Here comes the template.

// For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.

int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }
