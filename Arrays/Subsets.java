import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.sort;

/**
 * Created by juanyan.li on 3/6/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<=nums.length; i+=1) {
            backtrack(res, new ArrayList<>(), nums, i, 0);
        }
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int len, int start) {
        if (len == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i=start; i<nums.length; i+=1) {
            tempRes.add(nums[i]);
            backtrack(res, tempRes, nums, len-1, i+1);
            tempRes.remove(tempRes.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        sort(nums);
        forwardtrack(res, new ArrayList<>(), nums, -1);
        return res;
    }

    public void forwardtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        Integer prev = null;
        for (int i=start+1; i<nums.length; i+=1) {
            if (prev != null && prev.equals(nums[i])) continue;
            temp.add(nums[i]);
            prev = nums[i];
            forwardtrack(res, temp, nums, i);
            temp.remove(temp.size() - 1);
        }
    }
}
