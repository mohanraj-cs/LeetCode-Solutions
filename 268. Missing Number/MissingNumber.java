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