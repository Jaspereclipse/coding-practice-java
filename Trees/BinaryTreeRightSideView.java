import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by juanyan.li on 4/7/17.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            TreeNode crt = queue.poll();
            count -= 1;
            if (crt.left != null) {
                queue.offer(crt.left);
                nextCount += 1;
            }
            if (crt.right != null) {
                queue.offer(crt.right);
                nextCount += 1;
            }
            if (count == 0) {
                res.add(crt.val);
                count = nextCount;
                nextCount = 0;
            }
        }
        return res;
    }
}
