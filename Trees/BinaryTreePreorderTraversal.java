import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanyan.li on 4/3/17.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}

