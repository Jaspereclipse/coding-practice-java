import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

/**
 * Created by juanyan.li on 2/21/17.
 */
public class ThirdMaximumNumber {
    /* O(n) time, O(n) space */
    public int thirdMax(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int alpha = removeMax(set);
        int cnt = 1; // num of max found
        int beta = -1;
        while (set.size() > 0 && cnt < 3) {
            beta = removeMax(set);
            cnt += 1;
        }
        if (cnt < 3) {
            return alpha;
        } else {
            return beta;
        }
    }

    public int removeMax(Set<Integer> set){
        int max = Collections.max(set);
        set.remove(max);
        return max;
    }

    /* O(n) time; O(1) space */
    public int betterThirdMax(int[] nums) {
        Integer[] max3 = new Integer[]{null, null, null}; // small-middle-large
        for (Integer num: nums){
            if (num.equals(max3[0]) || num.equals(max3[1]) || num.equals(max3[2])) continue;
            if (max3[2] == null || max3[2] < num){
                max3[1] = max3[2];
                max3[0] = max3[1];
                max3[2] = num;
            } else if (max3[1] == null || max3[1] < num){
                max3[0] = max3[1];
                max3[1] = num;
            } else if (max3[0] == null || max3[0] < num){
                max3[0] = num;
            }
        }
        return max3[0] == null ? max3[2] : max3[0];
    }


    public void printRes(int num){
        System.out.println(num);
    }

    public static void main(String[] args){
        ThirdMaximumNumber tmn = new ThirdMaximumNumber();
        int[] inputs = new int[]{3,3,3,3,1,0};
        int res = tmn.thirdMax(inputs);
        tmn.printRes(res);
        res = tmn.betterThirdMax(inputs);
        tmn.printRes(res);
    }
}
