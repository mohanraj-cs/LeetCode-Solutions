// O(n)
public int[] twoSum(int[] nums, int target) {
    Map < Integer, Integer > map = new HashMap < Integer, Integer > ();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            return new int[] { map.get(nums[i]), i };
        }
        map.put(target - nums[i], i);
    }
    return new int[] { 0, 0 };
}

//Brute force approach O(n*2)
public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length - 1; i++)
        for (int j = i + 1; j < numbers.length; j++)
            if (numbers[i] + numbers[j] == target){
                return new int[] {i, j};
            }
    return new int[] {0, 0};
}
