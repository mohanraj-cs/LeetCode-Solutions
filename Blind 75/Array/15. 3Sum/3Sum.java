// written in methods
class Solution {
    public List < List < Integer >> threeSum(int[] nums) {
        Arrays.sort(nums);
        List < List < Integer >> res = new LinkedList < > ();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { //skip same elements to avoid duplicates
                if (nums[i] > 0) {
                    break;
                }
                searchPair(nums, res, i);
            }
        }
        return res;
    }

    private void searchPair(int[] nums, List < List < Integer >> res, int begin) {
        int l = begin + 1, r = nums.length - 1, target = 0 - nums[begin];
        while (l < r) {
            if (nums[l] + nums[r] == target) { // found the match
                res.add(Arrays.asList(nums[begin], nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++; //skip same element to avoud duplicates
                while (l < r && nums[r] == nums[r + 1])
                    r--; //skip same element to avoud duplicates
            } else if (nums[l] + nums[r] < target) {
                l++;  //we need a pair with bigger element so move left
            } else {
                r--; //we need a pair with smaller element so move right
            }
        }
    }
}

// O(N*2) faster than 98% optimised
public List < List < Integer >> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List < List < Integer >> res = new LinkedList < > ();
    for (int i = 0; i < n - 2; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            if (nums[i] > 0)
                break;
            int lo = i + 1, hi = n - 1, sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < sum)
                    lo++;
                else
                    hi--;
            }
        }
    }
    return res;
}


// O(N*3) Brute force
class Solution {
    public List < List < Integer >> threeSum(int[] nums) {
        Arrays.sort(nums);
        List < List < Integer >> res = new LinkedList < > ();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList < Integer > list = new ArrayList < Integer > ();
                        Collections.addAll(list, nums[i], nums[j], nums[k]);
                        if (!res.contains(list))
                            res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
