// https://www.youtube.com/watch?v=awxaRgUB4Kw&ab_channel=TECHDOSE
// With shifing the values pattern 
// An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; i++)
        result[i] = result[i >> 1] + (i & 1);
    return result;
}

// https://www.youtube.com/watch?v=RyBM56RIWrM&ab_channel=NeetCode
// https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
// With Offset the bit
public int[] countBits(int num) {
    int[] result = new int[num + 1];
    int offset = 1;
    for (int index = 1; index < num + 1; index++){
        if (offset * 2 == index)
            offset *= 2;
        result[index] = result[index - offset] + 1;
    }
    return result;
}
 