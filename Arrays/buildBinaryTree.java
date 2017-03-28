
/**
 * Created by juanyan.li on 3/24/17.
 */
public class buildBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTreeI(int[] inorder, int[] postorder) {
        TreeNode root = recursiveBuildI(0, inorder.length-1,
                0, postorder.length-1,inorder, postorder);
        return root;
    }

    public TreeNode recursiveBuildI(int istart, int iend,
                                    int pstart, int pend,
                                    int[] inorder, int[] postorder) {
        if (istart > iend) return null;
        // find the root
        TreeNode root = new TreeNode(postorder[pend]);
        int delta = -1;
        for (int i=istart; i<=iend; i+=1) { // find the left tree
           if (inorder[i] == postorder[pend]) {
               delta = i-istart;
               break;
           }
        }
        root.left = recursiveBuildI(istart, istart+delta-1,
                pstart, pstart+delta-1, inorder, postorder);
        root.right = recursiveBuildI(istart+delta+1, iend,
                pstart+delta, pend-1, inorder, postorder);
        return root;
    }

    public TreeNode buildTreeII(int[] preorder, int[] inorder) {
        TreeNode root = recursiveBuildII(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
        return root;
    }

    public TreeNode recursiveBuildII(int pstart, int pend,
                                     int istart, int iend,
                                     int[] preorder, int[] inorder) {
        if (pstart > pend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int delta = -1;
        for (int i=istart; i<=iend; i+=1) {
            if (inorder[i] == preorder[pstart]) { // find left tree
                delta = i - istart;
                break;
            }
        }
        root.left = recursiveBuildII(pstart+1, pstart+delta,
                istart, istart+delta-1, preorder, inorder);
        root.right = recursiveBuildII(pstart+delta+1, pend,
                istart+delta+1, iend, preorder, inorder);
        return root;
    }


}
