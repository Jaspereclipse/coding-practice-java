import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanyan.li on 4/9/17.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n < 2) return 1; // 0, 1
        int sum = 0;
        int crt = n - 1;
        int mid = n / 2;
        // assume even for now
        while (crt >= mid) {
            sum += 2 * numTrees(crt) * numTrees(n-crt-1);
            crt -= 1;
        }
        if (n % 2 != 0) sum -= numTrees(mid) * numTrees(mid);
        return sum;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        } else if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        int crt = start;
        while (crt <= end) {
            for (TreeNode leftSubTree: helper(start, crt-1)) {
                for (TreeNode rightSubTree: helper(crt+1, end)) {
                    TreeNode root = new TreeNode(crt);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    res.add(root);
                }
            }
            crt += 1;
        }
        return res;
    }
}