import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/6/17.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i=0; i<nums.length && i<=maxReach; i+=1) {
            maxReach = max(maxReach, i + nums[i]);
        }
        return (maxReach >= nums.length - 1);
    }
}
