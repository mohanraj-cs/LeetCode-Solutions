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
class Solution {
  public int[] twoSum(int[] numArray, int target) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for( int i=0; i<numArray.length ; i++) {
          if(map.containsKey(target - numArray[i])) {
              return new int[] {map.get(target - numArray[i]), i};
          }
          map.put(numArray[i], i);
      }
      return new int[] {0,0};
  }
}