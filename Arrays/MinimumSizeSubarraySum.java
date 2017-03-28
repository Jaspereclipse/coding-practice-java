/**
 * Created by juanyan.li on 3/22/17.
 */
import static java.lang.Math.min;
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int remove = 0;
        int crtSum = 0;
        int crtCnt = 0;
        int minLen = 0;
        for (int i=0; i<nums.length; i+=1) {
            crtSum += nums[i];
            crtCnt += 1;
            while (crtSum >= s) {
                minLen = minLen == 0 ? crtCnt : min(minLen, crtCnt);
                crtCnt -= 1;
                crtSum -= nums[remove];
                remove += 1;
            }
        }
        return minLen;
    }
}
