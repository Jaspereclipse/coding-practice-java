
import java.util.ArrayList;
import static java.util.Arrays.sort;
import java.util.List;

/**
 * Created by juanyan.li on 3/4/17.
 */
public class CombinationSum {
    // no duplicates, positive numbers, allow repetition
    public List<List<Integer>> combinationSumI(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackI(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backtrackI(List<List<Integer>> res, int[] candidates, int weight, int start, List<Integer> tempRes) {
        if (weight < 0) return;
        else if (weight == 0) res.add(new ArrayList<>(tempRes));
        else {
            for (int i=start; i<candidates.length; i+=1) {
                tempRes.add(candidates[i]);
                backtrackI(res, candidates, weight-candidates[i], i, tempRes);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }

    // allow duplicates, positive numbers, allow repetition
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrackII(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backtrackII(List<List<Integer>> res, int[] candidates, int weight, int start, List<Integer> tempRes) {
        if (weight < 0) return;
        else if (weight == 0) {
            res.add(new ArrayList(tempRes));
        }
        else {
            for (int i=start; i<candidates.length; i+=1) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                tempRes.add(candidates[i]);
                backtrackII(res, candidates, weight-candidates[i],i+1, tempRes);
                tempRes.remove(tempRes.size()-1);
            }
        }
    }

    // [1, 9] k-sum, no duplicates
    public List<List<Integer>> combinationSumIII(int k, int target) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        backtrackIII(res, candidates, target, k, 0, new ArrayList<>());
        return res;
    }

    public void backtrackIII(List<List<Integer>> res, int[] candidates, int weight, int k, int start, List<Integer> tempRes) {
        if (weight < 0 || tempRes.size() > k) return;
        else if (weight == 0 && tempRes.size() == k) {
            res.add(new ArrayList(tempRes));
        }
        else {
            for (int i=start; i<candidates.length; i+=1) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                tempRes.add(candidates[i]);
                backtrackIII(res, candidates, weight-candidates[i], k,i+1, tempRes);
                tempRes.remove(tempRes.size()-1);
            }
        }
    }

    // no duplicates, positive numbers, allow repetition, allow permutation
    public int combinationSumIV(int[] candidates, int target) {
        int res = 0;
        int[] tbl = new int[target + 1];
        tbl[0] = 1;
        for (int i=1; i<tbl.length; i+=1) {
            for (int j=0; j<candidates.length; j+=1) {
                if (candidates[j] <= i) {
                    tbl[i] += tbl[i-candidates[j]];
                }
            }
        }
        return tbl[target];
    }
}
