/**
 * Created by juanyan.li on 4/6/17.
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode root = new TreeNode(val);
        if (firstParen == -1) return root;
        int start = firstParen, count = 0;
        for (int i=start; i<s.length(); i+=1) {
            if (s.charAt(i) == '(') count += 1;
            else if (s.charAt(i) == ')') count -= 1;
            if (count == 0 && root.left == null) {
                root.left = str2tree(s.substring(start+1, i));
                start = i+1;
            } else if (count == 0) {
                root.right = str2tree(s.substring(start+1, i));
            }
        }
        return root;
    }

    public int ch2int(char ch) {
        return Character.getNumericValue(ch);
    }
}
