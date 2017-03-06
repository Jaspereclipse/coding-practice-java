import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/2/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxA = (right - left) * min(height[left], height[right]);
        while (left < right){
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
            maxA = max(maxA, (right-left) * min(height[left], height[right]));
        }
        return maxA;
    }
}
