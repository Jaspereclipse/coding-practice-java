/**
 * Created by juanyan.li on 4/9/17.
 */
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return count;
        postOrder(root);
        return count;
    }

    public boolean postOrder(TreeNode root) {
        boolean leftUni = true;
        boolean rightUni = true;
        if (root.left != null) {
            leftUni = postOrder(root.left);
            leftUni &= root.left.val == root.val;
        }
        if (root.right != null) {
            rightUni = postOrder(root.right);
            rightUni &= root.right.val == root.val;
        }
        boolean crtUni = leftUni & rightUni;
        if (crtUni) count += 1;
        return crtUni;
    }
}
