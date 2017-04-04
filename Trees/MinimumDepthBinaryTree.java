/**
 * Created by juanyan.li on 4/2/17.
 */
import static java.lang.Math.min;
public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        if (root.left != null) minLeft = minDepth(root.left);
        if (root.right != null) minRight = minDepth(root.right);
        return min(minLeft, minRight) + 1;
    }
}
