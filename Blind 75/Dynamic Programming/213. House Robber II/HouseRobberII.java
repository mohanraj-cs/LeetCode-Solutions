class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int l, int r){
      int preMax = 0, curMax = 0;
      for(int i = l; i <= r; i++){
        int temp = curMax;
        curMax = Math.max(preMax + nums[i], curMax);
        preMax = temp;  
      }  
      return curMax;
    }
    
}

//Long version
public int rob(int[] nums) {
	if (nums.length == 1) return nums[0];  
	return Math.max(rob0(nums), rob1(nums));
  }
  
  public int rob0(int[] nums){
	int preMax = 0, curMax = 0;
	for(int i = 0; i < nums.length - 1; i++){
	  int t = curMax;
	  curMax = Math.max(preMax + nums[i], curMax);
	  preMax = t;  
	}  
	return curMax;
  }
  
  public int rob1(int[] nums){
	int preMax = 0, curMax = 0;
	for(int i = 1; i < nums.length; i++){
	  int t = curMax;
	  curMax = Math.max(preMax + nums[i], curMax);
	  preMax = t;  
	}  
	return curMax;  
  }