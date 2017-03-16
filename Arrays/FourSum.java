import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by juanyan.li on 3/5/17.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Integer prev = null;
        List<Integer> tempRes = new ArrayList<>();
        for (int i=0; i<nums.length; i+=1) {
            if (prev != null && prev.equals(nums[i])) continue;
            tempRes.add(nums[i]);
            findThreeSum(res, tempRes, nums, target - nums[i], i+1, nums.length-1);
            tempRes.remove(tempRes.size()-1);
            prev = nums[i];
        }
        return res;
    }

    public void findThreeSum(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int target, int start, int end) {
        Integer prev = null;
        for (int i=start; i<=end; i+=1) {
            if (prev != null && prev.equals(nums[i])) continue;
            tempRes.add(nums[i]);
            findTwoSum(res, tempRes, nums, target - nums[i], i+1, end);
            tempRes.remove(tempRes.size()-1);
            prev = nums[i];
        }
    }

    public void findTwoSum(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int target, int start, int end) {
        while (start < end) {
            int remain = target - nums[start] - nums[end];
            if (remain == 0) { // found
                tempRes.add(nums[start]);
                tempRes.add(nums[end]);
                res.add(new ArrayList<>(tempRes));
                tempRes.remove(tempRes.size() - 1);
                tempRes.remove(tempRes.size() - 1);
                start = shiftOne(start, nums, 1);
                end = shiftOne(end, nums, -1);
            } else if (remain > 0) {
                start = shiftOne(start, nums, 1); // too small
            }
            else end = shiftOne(end, nums, -1); // too large
        }
    }

    public int shiftOne(int index, int[] nums, int delta) {
        int value = nums[index];
        while (index >= 0 && index < nums.length && nums[index] == value) index += delta;
        return index;
    }

    public void printRes(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        fs.printRes(fs.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
