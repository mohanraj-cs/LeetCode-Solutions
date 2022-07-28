public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0; i < intervals.length - 1; i++) {
        if (intervals[i][1] > intervals[i + 1][0]) { // = not used here, bcs meeting can start right after the one edns
            return false;
        }
    }
    return true;
}

// in separate method
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (isOverlapping(intervals[i], intervals[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapping(int[] interval1, int[] interval2) {
        return (Math.max(interval1[0], interval2[0]) < Math.min(interval1[1], interval2[1]));
    }
}
