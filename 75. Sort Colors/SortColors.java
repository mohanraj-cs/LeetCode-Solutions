public void sortColors(int[] nums) {
    int lo = 0, mid = 0, hi = nums.length - 1, temp;
    while (mid <= hi) {
        if (nums[mid] == 0) {
            temp = nums[lo];
            nums[lo] = nums[mid];
            nums[mid] = temp;
            lo++;
            mid++;
        } else if (nums[mid] == 1)
            mid++;
        else if (nums[mid] == 2) {
            temp = nums[mid];
            nums[mid] = nums[hi];
            nums[hi] = temp;
            hi--;
        }
    }
}