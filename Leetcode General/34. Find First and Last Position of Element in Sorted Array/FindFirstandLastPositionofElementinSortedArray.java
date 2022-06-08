// O(log n) - two binary search - lower and upper bound
class Solution {
  int findBound(int[] nums, int target) {
      int left = 0, right = nums.length;
      while(left < right) {
          int mid = left + (right - left) / 2;
          if(nums[mid] < target) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      return left;
  }
  
  public int[] searchRange(int[] nums, int target) {
      int start = findBound(nums, target);
      if(start == nums.length || nums[start] != target) {
          return new int[]{-1, -1};
      }
      return new int[]{start, findBound(nums, target + 1) - 1};
  }
}

//Solution with annotation
class Solution {
	//find the first number that is greater than or equal to target.
	//could return nums.length if target is greater than nums[nums.length-1].
	int findBound(int[] nums, int target) {
			int left = 0, right = nums.length;
			while(left < right) {
					int mid = left + (right - left) / 2;
			//low <= mid < high
					if(nums[mid] < target) {
							left = mid + 1;
					} else {
			//should not be mid-1 when nums[mid]==target.
			//could be mid even if nums[mid]>target because mid<high.
							right = mid;
					}
			}
			return left;
	}
	
	public int[] searchRange(int[] nums, int target) {
			int start = findBound(nums, target);
			if(start == nums.length || nums[start] != target) {
					return new int[]{-1, -1};
			}
			return new int[]{start, findBound(nums, target + 1) - 1};
	}
	}