import java.util.Stack;

/**
 * Created by juanyan.li on 4/9/17.
 */
public class BSTIterator {
    Stack<TreeNode> branch;

    public BSTIterator(TreeNode root) {
        branch = new Stack<>();
        if (root == null) return;
        TreeNode pointer = root;
        branch.push(pointer);
        while (pointer.left != null) {
            pointer = pointer.left;
            branch.push(pointer);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !branch.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode crt = branch.pop();
        int smallest = crt.val;
        if (crt.right != null) {
            crt = crt.right;
            branch.push(crt);
            while (crt.left != null) {
                crt = crt.left;
                branch.push(crt);
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BSTIterator bsti = new BSTIterator(root);
        while (bsti.hasNext()) System.out.print(bsti.next() + " ");
    }
}
