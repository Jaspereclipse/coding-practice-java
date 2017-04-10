/**
 * Created by juanyan.li on 4/8/17.
 */
import static java.lang.Math.max;
public class HouseRobber {
    public int robI(int[] nums) {
        if (nums.length < 1) return 0;
        int crtNotEnd = 0;
        int crtEnd = nums[0];
        for (int i=1; i<nums.length; i+=1) {
            int tmp = crtEnd;
            crtEnd = crtNotEnd + nums[i];
            crtNotEnd = max(tmp, crtNotEnd);
        }
        return max(crtEnd, crtNotEnd);
    }

    public int robII(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int crtEnd = Integer.MIN_VALUE;
        int crtNotEnd = 0; // don't rob 0
        for (int i=1; i<nums.length; i+=1) {
            int tmp = crtEnd;
            crtEnd = crtNotEnd + nums[i];
            crtNotEnd = max(tmp, crtNotEnd);
        }
        int res = max(crtEnd, crtNotEnd);
        crtEnd = nums[0];
        crtNotEnd = Integer.MIN_VALUE; // rob 0
        for (int i=1; i<nums.length; i+=1) {
            int tmp = crtEnd;
            crtEnd = crtNotEnd + nums[i];
            crtNotEnd = max(tmp, crtNotEnd);
        }
        res = max(res, crtNotEnd);
        return res;
    }
}
