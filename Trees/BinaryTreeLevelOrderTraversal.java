import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by juanyan.li on 4/3/17.
 */
import static java.util.Collections.reverse;
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int nextCount = 0;
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextCount += 1;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextCount += 1;
            }
            count -= 1;
            if (count == 0) {
                res.add(new ArrayList<>(temp));
                temp.clear();
                count = nextCount;
                nextCount = 0;
            }
        }
        return res;
    }

}
