import static java.lang.Math.max;

/**
 * Created by juanyan.li on 2/26/17.
 */
public class MaximumSubarray {
    public int maxSubarray(int[] nums){
        if (nums.length < 1) return Integer.MIN_VALUE;
        int oldMax = nums[0];
        int sum = 0;
        int newMax = sum;
        for (int i=0; i<nums.length; i+=1){
            oldMax = max(oldMax, nums[i]);
            nums[i] = max(0, nums[i] + sum);
            sum = nums[i];
            newMax = max(newMax, sum);
        }
        if (newMax <= 0) {
            return oldMax;
        } else {
            return newMax;
        }
    }

    public void printRes(int num){
        System.out.println(num);
    }

    public static void main(String args[]){
        MaximumSubarray ms = new MaximumSubarray();
        int[] inputs = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = ms.maxSubarray(inputs);
        ms.printRes(res);
    }
}
