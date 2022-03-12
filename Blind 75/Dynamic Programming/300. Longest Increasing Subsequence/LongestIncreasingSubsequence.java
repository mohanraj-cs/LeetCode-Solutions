//DP Solution | O(n*2)
public int lengthOfLIS(int[] nums) {
    // Base case
    if (nums == null || nums.length == 0)
        return 0;

    // This will be our array to track longest sequence length
    int[] dp = new int[nums.length];
    // Fill each position with value 1 in the array
    Arrays.fill(dp, 1);
    int result = 1;

    // Mark one pointer at i. For each i, start from j=0.
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            // It means next number contributes to increasing sequence.
            if (nums[i] > nums[j]) {
                // But increase the value only if it results in a larger value of the sequence than dp[i]
                // It is possible that dp[i] already has larger value from some previous j'th iteration
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        // Track the maximum length from the array that we just generated
        result = Math.max(result, dp[i]);
    }
    return result;
}

// O(n*logn) Binary search and Patience sort
// https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
// https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308/C%2B%2BPython-DP-Binary-Search-BIT-Solutions-Picture-explain-O(NlogN)
  public int lengthOfLIS(int[] nums) {
      int[] tails = new int[nums.length];
      int size = 0;
      for (int x: nums) {
          int i = 0, j = size;
          while (i < j) {
              int mid = i + ((j - i) / 2);
              if (tails[mid] < x)
                  i = mid + 1;
              else
                  j = mid;
          }
          tails[i] = x;
          if (i == size)
              size++;
      }
      return size;
  }
