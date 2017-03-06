import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by juanyan.li on 2/26/17.
 */
public class MajorityElement {
    public int majorityElementI(int[] nums){
        int thres = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)) {
                map.put(num, 1 + map.get(num));
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > thres) return num;
        }
        throw new IllegalArgumentException("None found.");
    }

    public List<Integer> majorityElementII(int[] nums){
        int thres = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 1;
        for (int num: nums){
            if (num == candidate1) {
                count1 += 1;
            } else if (num == candidate2) {
                count2 += 1;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        if (count(nums, candidate1) > thres) list.add(candidate1);
        if (count(nums, candidate2) > thres) list.add(candidate2);
        return list;
    }

    public int count(int[] nums, int candidate){
        int cnt = 0;
        for (int num: nums){
            if (num == candidate) cnt += 1;
        }
        return cnt;
    }

    public void printRes(int num){
        System.out.println(num);
    }

    public void printRes(List<Integer> list){
        for (int num: list){
            System.out.print(num);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String args[]){
        MajorityElement me = new MajorityElement();
        int[] inputs = new int[]{1,1,2,2,2};
        int res = me.majorityElementI(inputs);
        me.printRes(res);
        inputs = new int[]{1,1,1,2,2,2,3,3};
        List<Integer> reslist = me.majorityElementII(inputs);
        me.printRes(reslist);
        inputs = new int[]{1,1,2,2,2,3,3};
        reslist = me.majorityElementII(inputs);
        me.printRes(reslist);
    }
}
