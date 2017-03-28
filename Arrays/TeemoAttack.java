/**
 * Created by juanyan.li on 3/26/17.
 */
public class TeemoAttack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i=0; i<timeSeries.length; i+=1) {
            int start = timeSeries[i];
            while (i<timeSeries.length-1 && (timeSeries[i+1]-timeSeries[i]<=duration)) {
                i+=1;
            }
            total += timeSeries[i] - start + duration;
        }
        return total;
    }
}
