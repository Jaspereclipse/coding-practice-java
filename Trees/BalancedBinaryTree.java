/**
 * Created by juanyan.li on 4/2/17.
 */
import static java.lang.Math.abs;
import static java.lang.Math.max;
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            root.val = 0;
            return true;
        }
        int maxLeft = 0;
        int maxRight = 0;
        if (root.left != null) {
            if (!isBalanced(root.left)) return false;
            maxLeft = 1 + root.left.val;
        }
        if (root.right != null) {
            if (!isBalanced(root.right)) return false;
            maxRight = 1 + root.right.val;
        }
        root.val = max(maxLeft, maxRight);
        return abs(maxLeft - maxRight) < 2;
    }
}
