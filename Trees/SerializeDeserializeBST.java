/**
 * Created by juanyan.li on 4/9/17.
 */
public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) return res;
        res += root.val;
        res += "(" + serialize(root.left) + ")";
        res += "(" + serialize(root.right) + ")";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 1) return null;
        int leftPar = data.indexOf('(');
        if (leftPar == -1) return new TreeNode(Integer.parseInt(data)); // single node
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, leftPar)));
        int leftCount = 0;
        int start = leftPar;
        for (int i=start; i<data.length(); i+=1) {
            if (data.charAt(i) == '(') leftCount += 1;
            else if (data.charAt(i) == ')') {
                leftCount -= 1;
                if (leftCount == 0) {
                    root.left = start + 1 == i ? null : deserialize(data.substring(start+1, i));
                    start = i+1;
                    root.right = start + 1 == data.length()-1 ? null : deserialize(data.substring(start+1, data.length()-1));
                    break;
                }
            }
        }
        return root;
    }
}
