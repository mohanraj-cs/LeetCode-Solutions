// Have to solve again this generic Solution
public List < List < Integer >> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, 4, target);
}
private List < List < Integer >> kSum(int[] nums, int start, int k, int target) {
    int len = nums.length;
    List < List < Integer >> res = new ArrayList < List < Integer >> ();
    if (k == 2) { //two pointers from left and right
        int left = start, right = len - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List < Integer > path = new ArrayList < Integer > ();
                path.add(nums[left]);
                path.add(nums[right]);
                res.add(path);
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < target) { //move left
                left++;
            } else { //move right
                right--;
            }
        }
    } else {
        for (int i = start; i < len - (k - 1); i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            List < List < Integer >> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
            for (List < Integer > t: temp) {
                t.add(0, nums[i]);
            }
            res.addAll(temp);
        }
    }
    return res;
}

// O(N^3) static solution
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i - 1] == nums[i]){   //avoid duplicated
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){   //avoid duplicated
                    continue;
                }
                searchPair(res, nums, i, j, target);
            }
        }
        return res;
    }

    private void searchPair(List<List<Integer>> res, int[] nums, int i, int j, int target) {
        int l = j + 1, r = nums.length - 1;
        while(l < r) {
            int currSum = nums[i] + nums[j] + nums[l] + nums[r];
            if(currSum == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                l++;
                r--;
                while(l < r && nums[l] == nums[l - 1])
                    l++;
                while(l < r && nums[r] == nums[r + 1])
                    r--;
            } else if(currSum > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
