class Solution {
    public int maxSubArray(int[] nums) {
        int maxCurr = nums[0], maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurr = Math.max(nums[i], nums[i] + maxCurr);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }
        return maxSoFar;
    }
}
