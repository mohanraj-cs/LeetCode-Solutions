// Explanation:
// The crux over here is that the array is already sorted.
// We are comparing the first and last elements because after square these have the possibility of being the highest element.
// Both the extremes contain the max element (after square ofc), so we are inserting these elements to the last of the new array to make it sorted.
public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int left = 0, right = n - 1, highestIndex = n - 1;
    int[] res = new int[n];
    while (left <= right) {
        int leftSq = nums[left] * nums[left];
        int rightSq = nums[right] * nums[right];
        if (leftSq > rightSq) {
            res[highestIndex] = leftSq;
            left++;
        } else {
            res[highestIndex] = rightSq;
            right--;
        }
        highestIndex--;
    }
    return res;
}

// With Absolute value comparison
public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int left = 0, right = n - 1, highestIndex = n - 1;
    int[] res = new int[n];
    while (left <= right) {
        if (Math.abs(nums[left]) > Math.abs(nums[right])) {
            res[highestIndex] = nums[left] * nums[left];
            left++;
        } else {
            res[highestIndex] = nums[right] * nums[right];
            right--;
        }
        highestIndex--;
    }
    return res;
}
