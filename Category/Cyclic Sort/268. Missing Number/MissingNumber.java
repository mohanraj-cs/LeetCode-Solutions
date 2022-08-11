// Approach #3 Bit Manipulation
// Algorithm
//
// Because we know that nums contains nn numbers and that it is missing exactly one number on the range [0..n-1][0..n−1], we know that nn definitely replaces the missing number in nums. Therefore, if we initialize an integer to nn and XOR it with every index and value, we will be left with the missing number. Consider the following example (the values have been sorted for intuitive convenience, but need not be):
//
// Index	0	1	2	3
// Value	0	1	3	4
// \begin{aligned} missing &= 4 \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (2 \wedge 3) \wedge (3 \wedge 4) \\ &= (4 \wedge 4) \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (3 \wedge 3) \wedge 2 \\ &= 0 \wedge 0 \wedge 0 \wedge 0 \wedge 2 \\ &= 2 \end{aligned}
// missing
// ​
//
// =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
// =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
// =0∧0∧0∧0∧2
// =2
// ​
public int missingNumber(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
        missing ^= i ^ nums[i];
    }
    return missing;
}



// 1.XOR
public int missingNumber(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++)
        res = res ^ i ^ nums[i]; // a^b^b = a
    return res;
}
// 1.XOR
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
        res ^= i;
        res ^= nums[i];
    }
    return res;
}

// 2.SUM
public int missingNumber(int[] nums) {
    int len = nums.length;
    int sum = ((len) * (len + 1)) / 2;
    for(int i = 0; i < len; i++) {
        sum = sum - nums[i];
    }
    return sum;
}
//Method 2
// Sum of n number: n(n+1)/2.
// n*(n+1)/2 - sum of array elements
public int missingNumber(int[] nums) {
    int sum = 0;
    int len = nums.length + 1;
    for (int n: nums)
        sum += n;
    return ((len * (len - 1)) / 2 - sum);
}

// 3.Binary Search
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid = (left + right) / 2;
    while (left < right) {
        mid = (left + right) / 2;
        if (nums[mid] > mid) right = mid;
        else left = mid + 1;
    }
    return left;
}

// Sorting Mnaual
public int missingNumber(int[] nums) {
    Arrays.sort(nums);

    // Ensure that n is at the last index
    if (nums[nums.length-1] != nums.length) {
        return nums.length;
    }
    // Ensure that 0 is at the first index
    else if (nums[0] != 0) {
        return 0;
    }

    // If we get here, then the missing number is on the range (0, n)
    for (int i = 1; i < nums.length; i++) {
        int expectedNum = nums[i-1] + 1;
        if (nums[i] != expectedNum) {
            return expectedNum;
        }
    }

    // Array was not missing any numbers
    return -1;
}

// Approach #2 HashSet
// Intuition
//
// A brute force method for solving this problem would be to simply check for the presence of each number that we expect to be present. The naive implementation might use a linear scan of the array to check for containment, but we can use a HashSet to get constant time containment queries and overall linear runtime.

public int missingNumber(int[] nums) {
    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums) numSet.add(num);

    int expectedNumCount = nums.length + 1;
    for (int number = 0; number < expectedNumCount; number++) {
        if (!numSet.contains(number)) {
            return number;
        }
    }
    return -1;
}
