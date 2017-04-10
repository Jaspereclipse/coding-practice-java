/**
 * Created by juanyan.li on 4/7/17.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        recursiveFlatten(root);
    }

    public TreeNode recursiveFlatten(TreeNode root) { // return the node to attach right tree to
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        if (root.left != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode end = recursiveFlatten(root.right);
            if (tmp == null) return end;
            end.right = tmp;
            return recursiveFlatten(end.right);
        }
        return recursiveFlatten(root.right);
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fbt = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        fbt.flatten(root);
    }
}
