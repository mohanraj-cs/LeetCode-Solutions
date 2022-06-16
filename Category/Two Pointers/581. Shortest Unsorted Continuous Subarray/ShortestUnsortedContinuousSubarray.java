// 2 passes of the array
public int findUnsortedSubarray(int[] nums) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int begin = -1, end = -2; // if the array is sorted then none of the values of begin or end will be modiified, hence return value will be -2 - (-1) + 1 = 0

    //iterate from beginning of array find the last element which is smaller than the last seen max from  its left side and mark it as end
    for (int i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
        if (nums[i] < max) {
            end = i;
        }
    }

    //iterate from end of array find the last element which is bigger than the last seen min from its right side and mark it as begin
    for (int j = nums.length - 1; j >= 0; j--) {
        min = Math.min(min, nums[j]);
        if (nums[j] > min) {
            begin = j;
        }
    }

    return end - begin + 1;
}
// Without Using Extra Space
public int findUnsortedSubarray(int[] nums) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    boolean slope = false; // find unsorted slope
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]) {
            slope = true;
        }
        if (slope) {
            min = Math.min(min, nums[i]);
        }
    }

    slope = false; // find unsorted slope
    for (int j = nums.length - 2; j >= 0; j--) {
        if (nums[j] > nums[j + 1]) {
            slope = true;
        }
        if (slope) {
            max = Math.max(max, nums[j]);
        }
    }

    int l, r;
    for (l = 0; l < nums.length; l++) {
        if (min < nums[l]) {
            break;
        }
    }

    for (r = nums.length - 1; r >= 0; r--) {
        if (max > nums[r]) {
            break;
        }
    }

    return r - l < 0 ? 0 : r - l + 1;
}
// Complexity Analysis
//
// Time complexity : O(n)O(n). Four O(n)O(n) loops are used.
//
// Space complexity : O(1)O(1). Constant space is used.
