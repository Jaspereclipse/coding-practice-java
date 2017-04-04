/**
 * Created by juanyan.li on 4/2/17.
 */
import static java.lang.Math.max;
public class MaximumDepthBinaryTree {


   public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return track(root, 1);
   }

   public int track(TreeNode root, int max) {
        if (root == null) return max;
        int leftMax = max;
        int rightMax = max;
        if (root.left != null) leftMax = track(root.left, leftMax+1);
        if (root.right != null) rightMax = track(root.right, rightMax+1);
        return max(leftMax, rightMax);
   }
}
