// Mark Visited Elements in the Input Array itself

// when find a number i, flip the number at position i-1 to negative.
// if the number at position i-1 is already negative, i is the number that occurs twice.

public List < Integer > findDuplicates(int[] nums) {
    List < Integer > res = new ArrayList < > ();
    for (int i = 0; i < nums.length; ++i) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0)
            res.add(Math.abs(index + 1));
        nums[index] = -nums[index];
    }
    return res;
}

// approach 2 with Mark Visited Elements in the Input Array itself
public List < Integer > findDuplicates(int[] nums) {
    List < Integer > res = new ArrayList < > ();
    for (int i = 0; i < nums.length; i++) {
        int idx = Math.abs(nums[i]) - 1;
        if (nums[idx] < 0) {
            res.add(idx + 1);
        }
        nums[idx] = nums[idx] * -1;
    }
    return res;
}
