import java.util.Stack;

/**
 * Created by juanyan.li on 4/3/17.
 */
public class SymmetricTree {
    // recursive
    public boolean isSymmetricI(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return mirror(left.left, right.right)
                & mirror(left.right, right.left);
    }

    // iterative - explicitly showing the recursive stack
    public boolean isSymmetricII(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        if (!helper(root.left, root.right, stack)) return false;
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (!helper(left.left, right.right, stack)) return false;
            if (!helper(left.right, right.left, stack)) return false;
        }
        return true;
    }

    public boolean helper(TreeNode left, TreeNode right, Stack<TreeNode> stack) {
        if (left != null) {
            if (right == null) return false;
            if (left.val != right.val) return false;
            stack.push(left);
            stack.push(right);
        } else if (right != null) return false;
        return true;
    }
}
