import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by juanyan.li on 4/9/17.
 */
public class PopulateNextPointer {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connectI(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int nextCount = 0;
        TreeLinkNode prev = null;
        while (!queue.isEmpty()) {
            TreeLinkNode crt = queue.poll();
            if (prev != null) prev.next = crt;
            prev = crt;
            count -= 1;
            if (crt.left != null) {
                queue.offer(crt.left);
                nextCount += 1;
            }
            if (crt.right != null) {
                queue.offer(crt.right);
                nextCount += 1;
            }
            if (count < 1) {
                count = nextCount;
                nextCount = 0;
                prev = null;
            }
        }
    }

    // constant space, perfect binary tree
    public void connectII(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connectII(root.left);
            connectII(root.right);
        }
    }

    // constant space, any binary tree
    public void connectIII(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode curr = root;
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) prev.next = curr.left;
                    else head = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) prev.next = curr.right;
                    else head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = prev = null;
        }
    }
}
