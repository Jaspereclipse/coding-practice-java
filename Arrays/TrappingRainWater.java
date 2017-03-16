
/**
 * Created by juanyan.li on 3/8/17.
 */
public class TrappingRainWater {
    public int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] >= maxLeft) maxLeft = heights[left];
                else res += maxLeft - heights[left];
                left += 1;
            } else {
                if (heights[right] >= maxRight) maxRight = heights[right];
                else res += maxRight - heights[right];
                right -= 1;
            }
        }
        return res;
    }

}
