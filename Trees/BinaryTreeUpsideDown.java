/**
 * Created by juanyan.li on 4/9/17.
 */
public class BinaryTreeUpsideDown {
    TreeNode newRoot;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        flip(root);
        return newRoot;
    }

    public TreeNode flip(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            newRoot = new TreeNode(root.val);
            return newRoot;
        }
        TreeNode tmp = flip(root.left);
        tmp.left = root.right == null ? null : new TreeNode(root.right.val);
        tmp.right = new TreeNode(root.val);
        return tmp.right;
    }
}
