/**
 * Created by juanyan.li on 4/2/17.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true; // both null or same node
        if (p == null || q == null || (p.val != q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
