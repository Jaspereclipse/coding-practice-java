import java.util.ArrayList;
import java.util.List;

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
}
