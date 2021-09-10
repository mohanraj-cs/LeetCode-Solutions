class Solution {
    public int maxProduct(int nums[]) {
        // store the result that is the max we have found so far
        int res = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number nums[i]
        for (int i = 1, imax = res, imin = res; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            res = Math.max(res, imax);
        }
        return res;
    }
}