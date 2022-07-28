// The problem follows the Merge Intervals pattern and can easily be converted to Minimum Meeting Rooms. Similar to ‘Minimum Meeting Rooms’ where we were trying to find the maximum number of meetings happening at any time, for ‘Maximum CPU Load’ we need to find the maximum number of jobs running at any time. We will need to keep a running count of the maximum CPU load at any time to find the overall maximum load.

public int findMaxCPULoad(List<Job> jobs) {
  //Sort the jobs by start time
  Collections.sort(jobs, (i1, i2) -> Integer.compare(i1.start, i2.start));
  int maxCPULoad = 0;
  int currentCPULoad = 0;
  PriorityQueue<Job> queue = new PriorityQueue<>(jobs.size(), (i1, i2) -> (Integer.compare(i1.end, i2.end)));

  for(Job job: jobs) {
    // remove the jobs that have ended
    while(!queue.isEmpty() && job.start > queue.peek().end) {
      currentCPULoad = queue.poll().cpuLoad;
    }

    // add the current job into the minHeap
    queue.offer(job);
    currentCPULoad += job.cpuLoad;
    maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
  }
  return maxCPULoad;
}
