// Method 1: instead of sorting here hashing the chars - O(n)
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

// Method 1: annotationa and modification -  Used the getOrDefault Method to add in the list 
public List < List < String >> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0)
        return Collections.emptyList();
    Map < String, List < String >> map = new HashMap < > ();
    for (String s: strs) {
        //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
        //char array to String is really fast, thanks @legendaryengineer
        //You should use other data type when length of string is longer.
        //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
        //int. -2,147,483,648 to 2,147,483,647
        char[] frequencyArr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            frequencyArr[s.charAt(i) - 'a']++;
        }
        //6 ms use char(0~127) array and new String(frequencyArr) method.
        //17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
        //29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
        String key = new String(frequencyArr);
        List < String > tempList = map.getOrDefault(key, new LinkedList < String > ());
        tempList.add(s);
        map.put(key, tempList);
    }
    return new LinkedList < > (map.values());
}

// Method 2: using sort O(n log (n))
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