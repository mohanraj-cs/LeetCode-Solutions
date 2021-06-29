// O(n + m)
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
      int n1 = nums1.length, n2 = nums2.length;
      int[] nums3 = new int[n1 + n2];
      mergeArray(nums1, nums2, n1, n2, nums3);
      return findMedian(nums3, n1 + n2);
  }
  
  public void mergeArray(int[] nums1,int[] nums2, int n1, int n2, int[] nums3) {
      int i=0, j=0, k=0;
      while(i<n1 && j<n2) {
          if(nums1[i] < nums2[j]) 
              nums3[k++] = nums1[i++];
          else
              nums3[k++] = nums2[j++];
      }
      while(i < n1) 
          nums3[k++] = nums1[i++];
      while(j < n2)
          nums3[k++] = nums2[j++];
  }
  
  public double findMedian(int[] nums, int n) {
      int m = n/2;
      if(n == 1) return nums[0];
      if(n % 2 ==0)
          return (double)(nums[m-1] + nums[m]) / 2.0;
      else
          return (double)(nums[m]);
  }
}