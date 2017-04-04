/**
 * Created by juanyan.li on 4/1/17.
 */
import static java.lang.Math.abs;
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int min_pos = n+2;
        int next_min_pos = n+2;
        for (int i=0; i<n; i+=1) {
            if (nums[i] > 0) {
                if (nums[i] < min_pos) {
                    next_min_pos = min_pos;
                    min_pos = nums[i];
                } else if (nums[i] > min_pos && nums[i] < next_min_pos) {
                    next_min_pos = nums[i];
                }
            } else nums[i] = 1;
        }
        if (min_pos > 1) return 1; // early termination
        if (next_min_pos - min_pos > 1) return min_pos + 1; // early termination
        for (int i=0; i<n; i+=1) {
            int absVal = abs(nums[i]);
            if (absVal > 0 && absVal <= n) nums[absVal-1] = -abs(nums[absVal-1]);
        }
        for (int i=3; i<=n; i+=1) {
            if (nums[i-1] > 0) return i;
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] inputs = new int[]{1,2,3};
        int res = fmp.firstMissingPositive(inputs);
    }
}
