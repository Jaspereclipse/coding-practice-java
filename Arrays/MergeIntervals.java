import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/22/17.
 */
public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        public Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() < 1) return res;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        res.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i+=1) {
            int e1 = res.get(res.size() - 1).end;
            int s2 = intervals.get(i).start;
            if (s2 <= e1) { // merge
                res.get(res.size() - 1).end = max(e1, intervals.get(i).end);
            } else res.add(intervals.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> inputs = new ArrayList<>();
        inputs.add(mi.new Interval(1,3));
        inputs.add(mi.new Interval(2,6));
        inputs.add(mi.new Interval(8,10));
        inputs.add(mi.new Interval(15,18));
        List<Interval> res = mi.merge(inputs);
    }
}
