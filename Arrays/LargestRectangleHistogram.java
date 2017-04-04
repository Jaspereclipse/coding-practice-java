import java.util.Stack;
import static java.lang.Math.max;
/**
 * Created by juanyan.li on 3/28/17.
 */
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1); // corner case for i = 1
        for (int i=0; i<heights.length; i+=1) {
            int top = stack.peek();
            while (top > -1 && heights[top] > heights[i]) {
                stack.pop();
                maxArea = max(maxArea, heights[top]*(i-stack.peek()-1));
                top = stack.peek();
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int top = stack.pop();
            maxArea = max(maxArea, heights[top]*(heights.length-1-stack.peek()));
        }
        return maxArea;
    }
}
