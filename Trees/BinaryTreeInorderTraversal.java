import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by juanyan.li on 4/7/17.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) return inorder;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode crt = root;
        while (!stack.empty()) {
            if (crt.left != null) {
                stack.push(crt.left);
                crt = crt.left;
                continue;
            }
            TreeNode tmp = stack.pop();
            inorder.add(tmp.val);
            if (tmp.right != null) {
                crt = tmp;
                stack.push(crt.right);
                crt = crt.right;
            }
        }
        return inorder;
    }
}
