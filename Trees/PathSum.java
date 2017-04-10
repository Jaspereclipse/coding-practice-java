import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by juanyan.li on 4/2/17.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        boolean left = false;
        boolean right = false;
        boolean mid = false;
        int remain = sum - root.val;
        if (root.left != null) left = hasPathSum(root.left, remain);
        if (root.right != null) right = hasPathSum(root.right, remain);
        if (root.left == null && root.right == null) mid = remain==0;
        return left || right || mid;
    }

    // find all paths
    public List<List<Integer>> pathSumPaths(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        backTrack(root, res, new ArrayList<>(), sum);
        return res;
    }

    public void backTrack(TreeNode root, List<List<Integer>> res, List<Integer> temp, int remain) {
        int newRemain = remain - root.val;
        if (root.left == null && root.right == null) {
            if (newRemain == 0) {
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        if (root.left != null) backTrack(root.left, res, temp, newRemain);
        if (root.right != null) backTrack(root.right, res, temp, newRemain);
        temp.remove(temp.size()-1);
    }

    // The path does not need to start or end at the root or a leaf, but it must go downwards
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }

    public int dfs(TreeNode root, int preSum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        preSum += root.val;
        int count = map.getOrDefault(preSum - target, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        count += dfs(root.left, preSum, target, map) + dfs(root.right, preSum, target, map);
        map.put(preSum, map.get(preSum) - 1);
        return count;
    }
}
