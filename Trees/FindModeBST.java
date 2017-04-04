/**
 * Created by juanyan.li on 4/2/17.
 */

import static java.lang.Math.max;
public class FindModeBST {
    private Integer prev = null;
    private int count = 0;
    private int max = 0;
    private int nModes = 0;
    private int[] modes = null;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        inorder(root);
        modes = new int[nModes];
        nModes = count = 0;
        inorder(root);
        return modes;
    }

    public void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left);
        if (prev == null || root.val == prev) count += 1;
        else count = 1;
        prev = root.val;
        if (count > max) {
            max = count;
            nModes = 1;
        } else if (count == max){
            if (modes != null) modes[nModes] = prev;
            nModes += 1;
        }
        if (root.right != null) inorder(root.right);
    }

    public static void main(String[] args) {
        FindModeBST fmb = new FindModeBST();
        TreeNode root = new TreeNode(2147483647);
        fmb.findMode(root);
    }
}
