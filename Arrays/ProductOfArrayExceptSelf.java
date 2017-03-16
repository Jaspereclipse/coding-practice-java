/**
 * Created by juanyan.li on 3/8/17.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i+=1) {
            res[i] = res[i-1] * nums[i-1];
        }
        int cum = 1;
        for (int j=nums.length-1; j>=0; j-=1) {
            res[j] *= cum;
            cum *= nums[j];
        }
        return res;
    }
}
