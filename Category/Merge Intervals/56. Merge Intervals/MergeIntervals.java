class Solution {
    public int[][] merge(int[][] intervals) {
        List < int[] > result = new ArrayList < > ();
				// Sort by ascending starting point
        if (intervals.length == 0 || intervals == null)
            return result.toArray(new int[0][]);

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) { // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else { // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
