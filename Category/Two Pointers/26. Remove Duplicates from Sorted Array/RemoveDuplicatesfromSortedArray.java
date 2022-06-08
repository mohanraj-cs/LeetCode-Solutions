// Ordering by non duplicate count pointer
public int removeDuplicates(int[] nums) {
    int nonDuplicate = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[nonDuplicate] = nums[i];
            nonDuplicate++;
        }
    }
    return nonDuplicate;
}

// Ordering by duplicate count pointer
public int removeDuplicates(int[] nums) {
    int duplicate = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[i - duplicate] = nums[i];
        } else {
            duplicate++;
        }
    }
    return nums.length - duplicate;
}
