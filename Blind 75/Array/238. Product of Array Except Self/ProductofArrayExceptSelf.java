// https://www.youtube.com/watch?v=bNvIQI2wAjk&ab_channel=NeetCode
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Calculate prefix and store in res.
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefix = prefix * nums[i - 1];
            }

            res[i] = prefix;
        }

        // Calculate postfix and the product from the end of the array.
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                postfix = postfix * nums[i + 1];
            }

            res[i] = res[i] * postfix;
        }

        return res;
    }
}

// Naive apporach with left and right arrays
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // Left is an array containing the left products
        // i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int[] left = new int[n];

        // Right is an array containing the array products
        //i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[n];
        int[] res = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
