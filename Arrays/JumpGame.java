import java.util.*;

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

    // shortest jump
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int i = 0;
        int maxReach = 0;
        int jump = 0;
        int tempMax = 0;
        while (maxReach > i - 1) {
            jump += 1;
            for (; i<=maxReach; i+=1) {
                tempMax = max(tempMax, nums[i] + i);
                if (tempMax >= nums.length - 1) return jump;
            }
            maxReach = tempMax;
        }
        return -1;
    }
}
