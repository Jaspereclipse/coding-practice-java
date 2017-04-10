import java.util.*;

/**
 * Created by juanyan.li on 4/8/17.
 */
public class BinaryTreePosteorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>(); // node life cycle
        stack.push(root);
        TreeNode crt = root;
        while (!stack.isEmpty()) {
            if (crt.left != null && (!map.containsKey(crt) || map.get(crt) < 1)) {
                map.put(crt, 1);
                stack.push(crt.left);
                crt = crt.left;
                continue;
            }
            if (crt.right != null && (!map.containsKey(crt) || map.get(crt) < 2)) {
                map.put(crt, 2);
                stack.push(crt.right);
                crt = crt.right;
                continue;
            }
            res.add(stack.pop().val);
            if (!stack.isEmpty()) crt = stack.peek();
        }
        return res;
    }
}
