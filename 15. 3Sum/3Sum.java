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
