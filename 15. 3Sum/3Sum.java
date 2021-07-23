// O(N*3) Brute force 
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new LinkedList<>();
      int n = nums.length;
      for(int i=0; i<n-2; i++) {
          for(int j=i+1; j<n-1; j++) {
              for(int k=j+1; k<n; k++) {
                  if(nums[i] + nums[j] + nums[k] == 0) {
                      ArrayList<Integer> list = new ArrayList<Integer>();
                      Collections.addAll(list, nums[i], nums[j], nums[k]);
                      if(!res.contains(list)) 
                          res.add(list);
                  }
              }
          }
      }
      return res;
  }
}
// O(N*2) faster than 98% optimised
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      List<List<Integer>> res = new LinkedList<>();
      for(int i=0; i<n-2; i++){
          if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
              if(nums[i] > 0)
                  break;
              int lo = i+1, hi = n-1, sum = 0 - nums[i];
              while(lo < hi) {
                  if(nums[lo] + nums[hi] == sum) {
                      res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                      while(lo < hi && nums[lo] == nums[lo+1])
                          lo++;
                      while(lo < hi && nums[hi] == nums[hi-1])
                          hi--;
                      lo++;
                      hi--;
                  }
                  else if(nums[lo] + nums[hi] < sum)
                      lo++;
                  else
                      hi--;
              }
          }
      }
      return res;
  }
}