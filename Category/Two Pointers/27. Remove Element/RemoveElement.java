// Using begin counter - fastest
public int removeElement(int[] nums, int val) {
    int n = nums.length, begin = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] != val) {
            nums[begin] = nums[i];
            begin++;
        }
    }
    return begin;
}

// Remove the element
public int removeElement(int[] nums, int val) {
    int n = nums.length, k = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] != val) {
            nums[i - k] = nums[i];
        } else {
            k++;
        }
    }
    return n - k;
}
