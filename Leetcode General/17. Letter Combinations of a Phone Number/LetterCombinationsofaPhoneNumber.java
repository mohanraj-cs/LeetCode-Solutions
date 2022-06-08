// O(n*n) brute force
class Solution {
    
  public List<String> mergeTwoList(List<String> l1, List<String> l2) {
      List<String> res = new ArrayList<>();
      if(l2.size() == 0) return l1;
      for(String a: l1)
          for(String b: l2)
              res.add(b+a);
      return res;
  }
  
  public List<String> letterCombinations(String digits) {
      HashMap<Integer, List<String>> hm = new HashMap<>();
      List<String> res = new ArrayList<>();
      
      hm.put(1, new ArrayList<>());
      hm.put(2, new ArrayList<>(List.of("a","b","c")));
      hm.put(3, new ArrayList<>(List.of("d","e","f")));
      hm.put(4, new ArrayList<>(List.of("g","h","i")));
      hm.put(5, new ArrayList<>(List.of("j","k","l")));
      hm.put(6, new ArrayList<>(List.of("m","n","o")));
      hm.put(7, new ArrayList<>(List.of("p","q","r","s")));
      hm.put(8, new ArrayList<>(List.of("t","u","v")));
      hm.put(9, new ArrayList<>(List.of("w","x","y","z")));
      
      for(char ch: digits.toCharArray()){
          int curr = Integer.parseInt(ch+"");
          res = mergeTwoList(hm.get(curr), res);
      }
      
      return res;
  }
}

// Optimized using BFS algotithm in single queue
class Solution {
  public List<String> letterCombinations(String digits) {
      LinkedList<String> res = new LinkedList<String>();
      if(digits.isEmpty()) return res;
      String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      res.add("");
      for(int i=0; i<digits.length(); i++) {
          int x = Character.getNumericValue(digits.charAt(i));
          while(res.peek().length() == i) {
              String t = res.remove();
              for(char c: mapping[x].toCharArray())
                  res.add(t+c);
          }
      }
      return res;
  }
}