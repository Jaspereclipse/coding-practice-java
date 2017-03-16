/**
 * Created by juanyan.li on 3/7/17.
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update: updates) {
            res[update[0]] += update[2];
            if (update[1] < length - 1) res[update[1] + 1] -= update[2];
        }
        int inc = 0;
        for (int i=0; i<length; i+=1) {
            res[i] += inc;
            inc = res[i];
        }
        return res;
    }
}
