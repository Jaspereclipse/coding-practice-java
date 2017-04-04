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
}
