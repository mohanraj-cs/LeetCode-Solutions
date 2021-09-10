public int minSubArrayLen(int s, int[] nums) {
    int windowSum = 0, windowStart = 0, minLength = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        windowSum += nums[i];
        while (windowSum >= s) {
            minLength = Math.min(minLength, i - windowStart + 1);
            windowSum -= nums[windowStart++];
        }
    }
    return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
}