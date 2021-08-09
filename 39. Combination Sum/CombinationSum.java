// O(N*target) | Backtracking | Recursion | Java

class Solution {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
      List<List<Integer>> list = new ArrayList<>();
      backtrack(list, new ArrayList<>(), nums, target, 0);
      return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
      if(remain < 0) 
          return;
      if(remain == 0) 
          list.add(new ArrayList<>(tempList));
      else { 
          for(int i = start; i < nums.length; i++) {
              tempList.add(nums[i]);
              backtrack(list, tempList, nums, remain - nums[i], i); 
              tempList.remove(tempList.size() - 1);
          }
      }
  }
}


// Sort and Optimized with 98% by removing the unwanted stack if the current number is less than the remain target
class Solution {
  public List<List<Integer>> combinationSum(int[] nums, int target) {
      List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(list, new ArrayList<>(), nums, target, 0);
      return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
      if(remain == 0) 
          list.add(new ArrayList<>(tempList));
      else { 
          for(int i = start; i < nums.length && nums[i] <= remain; i++) {
              tempList.add(nums[i]);
              backtrack(list, tempList, nums, remain - nums[i], i); 
              tempList.remove(tempList.size() - 1);
          }
      }
  }
}

//Time complexity is O(N^target) where N is a length of candidates array.
//Space complexity is O(target).
// This is worst case and without any optimization, like moving position forward and sorting to stop early.
// Just assuming that each recursive step we go over all existing candidates, so base N.
// And go as deep as target in our recursive calls (if candidates are close to 1), so power of target.
// You can mention that this is worst case and optimizations can make time complexity a little better, for interview I think this should be enough.


/*
(1) Why use sort() & (2) Why pass start arugument & (3) what is tempList.remove(tempList.size() - 1) used for?
(1)sort() method is to check duplicates for convinence.
Like [2,2,3], target 5. Step by step like below:
2,2,2 -1 return -> 2,2,2 -1 return -> 2,2,3...
Clearly, it calls 2,2,2 twice.
In this case (without duplicates), not using it is better.

(2)passing argument 'start' will make sure each combination of num run once.
I think combined with sort() method to explain it will be easy to understand.
e.g. Like [3,2,4], after sorted, turn to [2,3,4]. (ignore target, just look for what's going on)
First reached list will be 2,2,2 return --> 2,2,3 return--> 2,2,4 return--> 2,3,3 ...
After 2,2,4 return, it should go to 2,3,3 (due to arg start) instead of 2,3,2. Because 2,2,3 we already reached.

(3)tempList.remove(tempList.size() - 1) do like a pop()
Imagine a recursion tree.
Node1 adds num1 to tempList, and calls backtrack() to go into its child Node2. Once this child return to its parent Node1, tempList.remove() will pop out the num1 it added before, and adds num2 to tempList and call backtrack() again.
*/
