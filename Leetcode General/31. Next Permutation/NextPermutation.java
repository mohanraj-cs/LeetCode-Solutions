// O(n) Optimized Solution
class Solution {
  public void nextPermutation(int[] nums) {
      int len = nums.length - 1, p = -1, pv = 0;
      for(int i = len - 1; i >= 0; i--) {
          if(nums[i] < nums[i + 1]) {
              p = i;
              pv = nums[i];
              break;
          }
      }
      if(p == -1) {
          reverse(nums, 0, len);
          return;
      }
      for(int i = len; i >= 0; i--) {
          if(nums[i] > pv) {
              swap(nums, p, i);
              break;
          }
      }
      reverse(nums, p + 1, len);
  }
  
  void reverse(int[] nums, int start, int end) {
      while(start < end) {
          swap(nums, start, end);
          start++;
          end--;
      }
     
  }
  
  void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}
// Tradeoff Reading with Space
class Solution {
  public void nextPermutation(int[] nums) {
      int len = nums.length, k, l;
      for(k = len - 2; k >= 0; k--) {
          if(nums[k] < nums[k + 1]) 
              break;
      }
      if(k < 0) {
          reverse(nums, 0, len - 1);
      } else {
          for(l = len - 1; l > k; l--) {
              if(nums[l] > nums[k])
                  break;
          }
          swap(nums, k, l);
          reverse(nums, k + 1, len - 1);    
      }    
  }
  
  void reverse(int[] nums, int start, int end) {
      while(start < end) {
          swap(nums, start, end);
          start++;
          end--;
      }
  }
  
  void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}