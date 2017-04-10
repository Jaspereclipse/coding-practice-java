import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by juanyan.li on 4/4/17.
 */
import static java.lang.Math.max;
public class FindLeavesBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // find longer path (number of nodes) to leave for each node
        Map<Integer, List<Integer>> map = new HashMap<>();
        int longestPath = findLongerPath(root, map);

        // add to list
        for (int i=1; i<=longestPath; i+=1) {
            res.add(new ArrayList<>(map.get(i)));
        }
        return res;
    }

    public int findLongerPath(TreeNode root, Map<Integer, List<Integer>> map) {
        int maxLeft = 1;
        int maxRight = 1;
        if (root.left != null) maxLeft += findLongerPath(root.left, map);
        if (root.right != null) maxRight += findLongerPath(root.right, map);
        int longerPath = max(maxLeft, maxRight);
        if (!map.containsKey(longerPath)) map.put(longerPath, new ArrayList<>());
        map.get(longerPath).add(root.val);
        return longerPath;
    }
}
