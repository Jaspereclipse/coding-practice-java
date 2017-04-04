/**
 * Created by juanyan.li on 4/2/17.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) sum += helper(root.left, true);
        if (root.right != null) sum += helper(root.right, false);
        return sum;
    }

    public int helper(TreeNode root, boolean leftChild) {
        if (root.left == null && root.right == null) {
            if (leftChild) return root.val;
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null) leftSum = helper(root.left, true);
        if (root.right != null) rightSum = helper(root.right, false);
        return leftSum + rightSum;
    }
}
