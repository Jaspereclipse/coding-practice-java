/**
 * Created by juanyan.li on 4/4/17.
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;
        return recursiveBuild(nums, 0, nums.length-1);
    }

    public TreeNode recursiveBuild(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursiveBuild(nums, start, mid-1);
        root.right = recursiveBuild(nums, mid + 1, end);
        return root;
    }
}
