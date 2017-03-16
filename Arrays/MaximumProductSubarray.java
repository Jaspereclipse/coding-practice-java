import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by juanyan.li on 3/14/17.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        if (nums.length == 1) return maxProduct;
        int maxPos = 0;
        int minNeg = 0;
        for (int i=0; i<nums.length; i+=1) {
            if (nums[i] >= 0) {
                maxPos= max(nums[i], nums[i] * maxPos);
                minNeg = min(nums[i], nums[i] * minNeg);
            } else {
                int tmp = maxPos;
                maxPos = max(nums[i], nums[i] * minNeg);
                minNeg = min(nums[i], nums[i] * tmp);
            }
            maxProduct = max(maxProduct, max(maxPos, minNeg));
        }
        return maxProduct;
    }
}
