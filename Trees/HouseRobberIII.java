/**
 * Created by juanyan.li on 4/9/17.
 */
import static java.lang.Math.max;
public class HouseRobberIII {
    public int rob(TreeNode root) {
        return max(helper(root, false), helper(root, true));
    }

    public int helper(TreeNode root, boolean rob) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (rob) return root.val;
            return 0;
        }
        int left;
        int right;
        if (rob) {
            left = helper(root.left, false);
            right = helper(root.right, false);
            return left + right + root.val;
        } else {
            left = max(helper(root.left, false), helper(root.left, true));
            right = max(helper(root.right, false), helper(root.right, true));
            return left + right;
        }
    }
}
