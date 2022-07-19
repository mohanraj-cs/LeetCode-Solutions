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
