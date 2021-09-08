// 5 ms
public boolean containsDuplicate(int[] nums) {
    HashSet < Integer > set = new HashSet < Integer > ();
    for (int num: nums) {
        if (set.contains(num))
            return true;
        set.add(num);
    }
    return false;
}

// 3 ms 
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i - 1]) {
            return true;
        }
    }
    return false;
}