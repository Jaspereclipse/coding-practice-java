/**
 * Created by juanyan.li on 2/27/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums){
        int sum = (1 + nums.length) * nums.length / 2;
        for (int num: nums){
            sum -= num;
        }
        return sum;
    }
}
