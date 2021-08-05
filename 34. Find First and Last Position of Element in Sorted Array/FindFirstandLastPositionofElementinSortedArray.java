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
public class Solution {
	public int[] searchRange(int[] A, int target) {
		int start = Solution.firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target.
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			//low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}
}
