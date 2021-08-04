// Solution 1: Binary Search O(logn)
public int search(int[] nums, int target) {
  if (nums == null || nums.length == 0) {
      return -1;
  }
  int left = 0, right = nums.length - 1;
  while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
          return mid;
      }
      if (nums[left] <= nums[mid]) {
          if (nums[left] <= target && target < nums[mid]) {
              right = mid - 1;
          }
          else {
              left = mid + 1;
          }
      }

      else {
          if (nums[mid] < target && target <= nums[right]) {
              left = mid + 1;
          }
          else {
              right = mid - 1;
          }
      }
  }
  return -1;
}

//Solution 1: with Annotation
public int search(int[] nums, int target) {
  if (nums == null || nums.length == 0) {
      return -1;
  }
  
  /*.*/
  int left = 0, right = nums.length - 1;
  //when we use the condition "left <= right", we do not need to determine if nums[left] == target
  //in outside of loop, because the jumping condition is left > right, we will have the determination
  //condition if(target == nums[mid]) inside of loop
  while (left <= right) {
      //left bias
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
          return mid;
      }
      //if left part is monotonically increasing, or the pivot point is on the right part
      if (nums[left] <= nums[mid]) {
          //must use "<=" at here since we need to make sure target is in the left part,
          //then safely drop the right part
          if (nums[left] <= target && target < nums[mid]) {
              right = mid - 1;
          }
          else {
              //right bias
              left = mid + 1;
          }
      }

      //if right part is monotonically increasing, or the pivot point is on the left part
      else {
          //must use "<=" at here since we need to make sure target is in the right part,
          //then safely drop the left part
          if (nums[mid] < target && target <= nums[right]) {
              left = mid + 1;
          }
          else {
              right = mid - 1;
          }
      }
  }
  return -1;
}

//Solution 2: 
public int search(int[] nums, int target) {
  if(nums==null||nums.length==0) return -1;
  int lo = 0;
  int hi = nums.length - 1;
  while(lo<hi)
  {
      int mid = lo + (hi-lo)/2;
      //target and mid are on the same side
      if((nums[mid]-nums[nums.length-1])*(target-nums[nums.length-1])>0)
      {
          if(nums[mid]<target)
              lo = mid + 1;
          else
              hi = mid;
      }else if(target>nums[nums.length-1])
          hi = mid; // target on the left side
      else
          lo = mid + 1; // target on the right side
  }
  // now hi == lo
  if(nums[lo]==target) 
      return lo;
  else
      return -1;        
}
