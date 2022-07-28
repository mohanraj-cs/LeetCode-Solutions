// https://leetcode.com/problems/interval-list-intersections/discuss/647482/Python-Two-Pointer-Approach-%2B-Thinking-Process-Diagrams
public int[][] intervalIntersection(int[][] A, int[][] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0)
        return new int[][] {};
    List < int[] > res = new ArrayList();
    for (int i = 0, j = 0; i < A.length && j < B.length;) {
        int start = Math.max(A[i][0], B[j][0]);
        int end = Math.min(A[i][1], B[j][1]);
        if (start <= end)
            res.add(new int[] { start, end });
        if (A[i][1] < B[j][1])
            ++i;
        else
            ++j;
    }
    return res.toArray(new int[0][]);
}

// different version

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List < int[] > res = new LinkedList < > ();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                res.add(new int[] {
                    start,
                    end
                });
            }
            if (end == firstList[i][1])
                i++;
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
