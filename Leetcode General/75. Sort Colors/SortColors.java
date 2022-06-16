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

class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, h = nums.length - 1;
        while (m <= h) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, h);
                h--;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time complexity #
// The time complexity of the above algorithm will be O(N)O(N) as we are iterating the input array only once.
//
// Space complexity #
// The algorithm runs in constant space O(1)O(1).
