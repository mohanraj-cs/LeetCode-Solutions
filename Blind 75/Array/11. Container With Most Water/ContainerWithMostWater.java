//O(N*2) Brute force
class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        }
        return maxarea;
    }
}

//O(N) two pointer algorithm || optimized one
public int maxArea(int[] height) {
    int i = 0, j = height.length - 1;
    int maxWater = 0;
    while (i < j) {
        int min = Math.min(height[i], height[j]);
        maxWater = Math.max(maxWater, min * (j - i));
        if (height[i] < height[j])
            i++;
        else
            j--;
    }
    return maxWater;
}