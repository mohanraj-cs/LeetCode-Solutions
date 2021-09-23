// Method 1: using sort O(n log (n))
public List < List < String >> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0)
        return new ArrayList < > ();
    Map < String, List < String >> map = new HashMap < > ();
    for (String s: strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        if (!map.containsKey(keyStr))
            map.put(keyStr, new ArrayList < > ());
        map.get(keyStr).add(s);
    }
    return new ArrayList < > (map.values());
}



// Other solution~with same logic and imporved readability
class Solution {
    public List < List < String >> groupAnagrams(String[] strs) {
        Map < String, List < String >> anas = new HashMap < > ();
        for (String str: strs) {
            String key = sortChars(str);
            anas.putIfAbsent(key, new ArrayList < > ());
            anas.get(key).add(str);
        }
        return new ArrayList < > (anas.values());
    }

    private String sortChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

// Method 2: instead of sorting here hashing the chars - O(n)
public List < List < String >> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) 
        return Collections.emptyList();
    Map < String, List < String >> map = new HashMap < > ();
    for (String s: strs) {
        char[] frequencyArr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            frequencyArr[s.charAt(i) - 'a']++;
        }
        String keyStr = new String(frequencyArr);
        if (!map.containsKey(keyStr))
            map.put(keyStr, new ArrayList < > ());
        map.get(keyStr).add(s);
    }
    return new ArrayList < > (map.values());
}

// Method 2: modification -  Used the getOrDefault Method to add in the list
public List < List < String >> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) 
        return Collections.emptyList();
    Map < String, List < String >> map = new HashMap < > ();
    for (String s: strs) {
        char[] frequencyArr = new char[26];
        for (int i = 0; i < s.length(); i++)
            frequencyArr[s.charAt(i) - 'a']++;
        String key = new String(frequencyArr);
        List < String > tempList = map.getOrDefault(key, new LinkedList < String > ());
        tempList.add(s);
        map.put(key, tempList);
        // if (!map.containsKey(keyStr))
        //     map.put(keyStr, new ArrayList < > ());
        // map.get(keyStr).add(s);
    }
    return new ArrayList < > (map.values());
}
