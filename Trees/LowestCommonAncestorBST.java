/**
 * Created by juanyan.li on 4/2/17.
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val == p.val || root.val == q.val) return root;
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST lca = new LowestCommonAncestorBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        TreeNode res = lca.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1));
        System.out.print(res.val);
    }
}
