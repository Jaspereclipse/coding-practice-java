/**
 * Created by juanyan.li on 4/7/17.
 */
public class KthSmallestBST {
    int kthSmallest;
    int count;
    int kCount;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        kCount = k;
        count = 0;
        findKthSmallest(root);
        return kthSmallest;
    }

    public void findKthSmallest(TreeNode root) {
        if (root.left != null) findKthSmallest(root.left);
        count += 1;
        if (count == kCount) {
            kthSmallest = root.val;
            return;
        }
        if (root.right != null) findKthSmallest(root.right);
    }
}
