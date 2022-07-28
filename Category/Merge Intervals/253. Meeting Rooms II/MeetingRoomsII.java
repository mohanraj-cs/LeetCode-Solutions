// Approach 1: min heap

public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
    // sort the meetings by start time
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    int minRooms = 0;
    PriorityQueue < int[] > minHeap = new PriorityQueue < > (intervals.length, (a, b) -> (a[1] - b[1]));
    for (int i = 0; i < intervals.length; i++) {
        // remove all meetings into the minHeap
        while (!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()[1]) {
            minHeap.poll();
        }
        // add the current meeting into the minHeap
        minHeap.offer(intervals[i]);
        // all active meeting are in the minHeap, so we need rooms for all of them.
        minRooms = Math.max(minRooms, minHeap.size());
    }
    return minRooms;
}

// Approach 2: Chronological Ordering

/**
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
 * end = 0; } Interval(int s, int e) { start = s; end = e; } }
 */

 // Simple version
 class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }
        return rooms;
    }
}

// Detailed
class Solution {

  public int minMeetingRooms(Interval[] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    Integer[] start = new Integer[intervals.length];
    Integer[] end = new Integer[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i].start;
      end[i] = intervals[i].end;
    }

    // Sort the intervals by end time
    Arrays.sort(
        end,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    // Sort the intervals by start time
    Arrays.sort(
        start,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    // The two pointers in the algorithm: e_ptr and s_ptr.
    int startPointer = 0, endPointer = 0;

    // Variables to keep track of maximum number of rooms used.
    int usedRooms = 0;

    // Iterate over intervals.
    while (startPointer < intervals.length) {

      // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
      if (start[startPointer] >= end[endPointer]) {
        usedRooms -= 1;
        endPointer += 1;
      }

      // We do this irrespective of whether a room frees up or not.
      // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
      // remain the same in that case. If no room was free, then this would increase used_rooms
      usedRooms += 1;
      startPointer += 1;

    }

    return usedRooms;
  }
}
