public List < Integer > findAnagrams(String s, String p) {
    List < Integer > res = new LinkedList < > ();
    if (p.length() > s.length()) {
        return res;
    }

    Map < Character, Integer > map = new HashMap < > ();
    for (char ch: p.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    int begin = 0, end = 0, counter = map.size();

    while (end < s.length()) {
        char endch = s.charAt(end);
        if (map.containsKey(endch)) {
            map.put(endch, map.get(endch) - 1);
            if (map.get(endch) == 0) {
                counter--;
            }
        }
        end++;
        while (counter == 0) {
            char beginch = s.charAt(begin);
            if (map.containsKey(beginch)) {
                map.put(beginch, map.get(beginch) + 1);
                if (map.get(beginch) > 0) {
                    counter++;
                }
            }
            if (end - begin == p.length()) {
                res.add(begin);
            }
            begin++;
        }
    }
    return res;
}
