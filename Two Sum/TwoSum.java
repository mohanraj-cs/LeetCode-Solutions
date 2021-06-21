//Brute force approach O(n*2)
class Solution {
  public int[] twoSum(int[] numbers, int target) {
      for(int i=0; i < numbers.length; i++) {
          for(int j=0; j < numbers.length; j++) {
              if(numbers[i] + numbers[j] == target) {
                  return new int[] {i,j};
              }
          }
      }
      return new int[] {0,0};
  }
}

// O(n)
public int[] twoSum(int[] numbers, int target) {
  int[] result = new int[2];
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
          result[1] = i;
          result[0] = map.get(target - numbers[i]);
          return result;
      }
      map.put(numbers[i], i);
  }
  return result;
}
