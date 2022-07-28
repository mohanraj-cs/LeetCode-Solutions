// Simplied version
public List < Interval > employeeFreeTime(List < List < Interval >> schedule) {
    List < Interval > result = new ArrayList < > ();
    PriorityQueue < Interval > pq = new PriorityQueue < > ((a, b) -> a.start - b.start);
    schedule.forEach(e -> pq.addAll(e));

    int prev = pq.poll().end;
    while (!pq.isEmpty()) {
        if (prev < pq.peek().start) { // no intersect
            result.add(new Interval(prev, pq.peek().start));
            prev = pq.poll().end; // becomes the prev interval
        } else { // intersect or sub merged - take big end time
            prev = Math.max(prev, pq.peek().end);
            pq.poll();
        }
    }
    return result;
}

// The time complexity of the sort algorithm is O(nlogn) where n is the total number of intervals.
// Because each person's time schedule is already sorted, we can use that info and optimize the algorithm by introducing a PriorityQueue storing a pointer to the person's schedule. Then the overall time complexity can be reduced to min(O(n log K), where K is the total number of people.


// Using prority queue
public List < Interval > employeeFreeTime(List < List < Interval >> avails) {

    List < Interval > result = new ArrayList < > ();

    PriorityQueue < Interval > pq = new PriorityQueue < > ((a, b) -> a.start - b.start);
    avails.forEach(e -> pq.addAll(e));

    Interval temp = pq.poll();
    while (!pq.isEmpty()) {
        if (temp.end < pq.peek().start) { // no intersect
            result.add(new Interval(temp.end, pq.peek().start));
            temp = pq.poll(); // becomes the next temp interval
        } else { // intersect or sub merged
            temp = temp.end < pq.peek().end ? pq.peek() : temp;
            pq.poll();
        }
    }
    return result;
}

// Instead of PriorityQueue here ArrayList

public List < Interval > employeeFreeTime(List < List < Interval >> avails) {
    List < Interval > result = new ArrayList < > ();
    List < Interval > timeLine = new ArrayList < > ();
    avails.forEach(e -> timeLine.addAll(e));
    Collections.sort(timeLine, ((a, b) -> a.start - b.start));

    Interval temp = timeLine.get(0);
    for (Interval each: timeLine) {
        if (temp.end < each.start) {
            result.add(new Interval(temp.end, each.start));
            temp = each;
        } else {
            temp = temp.end < each.end ? each : temp;
        }
    }
    return result;
}
