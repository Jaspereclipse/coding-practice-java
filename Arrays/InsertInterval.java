import java.util.List;

import static java.lang.Math.incrementExact;
import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/29/17.
 */

public class InsertInterval {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // null, empty, head
        if (intervals.size() < 1) {
            intervals.add(newInterval);
            return intervals;
        }
        int startIndex = -1;
        int endIndex = -1;
        for (int i=0; i<intervals.size(); i+=1) {
            if (intervals.get(i).start > newInterval.start) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) startIndex = intervals.size();
        for (int j=startIndex; j<intervals.size(); j+=1) {
            if (intervals.get(j).start > newInterval.end) {
                endIndex = j;
                break;
            }
        }
        if (endIndex == -1) endIndex = intervals.size();
        if (startIndex == endIndex) {
            if (startIndex < 1) {
                intervals.add(startIndex, newInterval);
            } else if (newInterval.start > intervals.get(startIndex - 1).end) {
                intervals.add(startIndex, newInterval);
            } else {
                intervals.get(startIndex-1).end = max(intervals.get(startIndex-1).end, newInterval.end);
            }
        } else {
            newInterval.end = max(newInterval.end, intervals.get(endIndex-1).end);
            for (int i=endIndex-1; i>=startIndex; i-=1) intervals.remove(i);
            if (startIndex < 1 || newInterval.start > intervals.get(startIndex - 1).end) {
                intervals.add(startIndex, newInterval);
            } else {
                intervals.get(startIndex-1).end = newInterval.end;
            }
        }
        return intervals;
    }
}
