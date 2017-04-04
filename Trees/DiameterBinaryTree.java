/**
 * Created by juanyan.li on 4/2/17.
 */
import static java.lang.Math.max;
public class DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        findLongestPath(root);
        return root.val;
    }

    public int findLongestPath(TreeNode root) {
        if (root.left == null && root.right == null) {
            root.val = 0;
            return 1;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        if (root.left != null) {
            maxLeft = findLongestPath(root.left);
            tmp1 = root.left.val;
        }
        if (root.right != null) {
            maxRight = findLongestPath(root.right);
            tmp2 = root.right.val;
        }
        root.val = max(maxLeft + maxRight, max(tmp1, tmp2));
        return 1 + max(maxLeft, maxRight);
    }
}
