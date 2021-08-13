class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       if (strs == null || strs.length == 0) 
           return new ArrayList<>();
       Map<String, List<String>> map = new HashMap<>();
       for (String s : strs) {
           char[] ca = s.toCharArray();
           Arrays.sort(ca);
           String keyStr = String.valueOf(ca);
           if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
           map.get(keyStr).add(s);
       }
       return new ArrayList<>(map.values());
   }
}


// Other solution
class Solution {
    public  List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anas = new HashMap<>();
        for (String str : strs) {
            String key = sortChars(str);
            anas.putIfAbsent(key, new ArrayList<>());
            anas.get(key).add(str);
        }
        return new ArrayList<>(anas.values());
    }

    private  String sortChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}