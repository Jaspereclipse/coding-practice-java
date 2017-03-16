import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * Created by juanyan.li on 3/15/17.
 */
public class MinimumAbsDiffBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<>(2);
        res.add(null);
        res.add(null);
        inOrder(root, res);
        return res.get(1);
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            if (res.get(0) != null && res.get(1) != null) res.set(1, min(res.get(1), abs(root.val - res.get(0))));
            else if (res.get(0) != null && res.get(1) == null) res.set(1, abs(root.val - res.get(0)));
            res.set(0, root.val);
            inOrder(root.right, res);
        }
    }
}
