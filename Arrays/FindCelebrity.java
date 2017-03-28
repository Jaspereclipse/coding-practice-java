/**
 * Created by juanyan.li on 3/24/17.
 */
public class FindCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i=1; i<n; i+=1) {
            if (!knows(i, candidate)) candidate = i;
        }
        for (int i=0; i<candidate; i+=1) {
            if (!knows(i, candidate)) return -1;
            if (knows(candidate, i)) return -1;
        }
        for (int i=candidate+1; i<n; i+=1) {
            if (!knows(i, candidate)) return -1;
            if (knows(candidate, i)) return -1;
        }
        return candidate;
    }

    public boolean knows(int a, int b) {
        return  false;
    }
}
