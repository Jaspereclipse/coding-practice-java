/**
 * Created by juanyan.li on 4/2/17.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        recursiveInvert(root);
        return root;
    }

    public void recursiveInvert(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        swap(root);
        recursiveInvert(root.left);
        recursiveInvert(root.right);
    }

    public void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
