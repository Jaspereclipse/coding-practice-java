/**
 * Created by juanyan.li on 3/24/17.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[]{-1,-1};
        double lb = target - 0.5;
        double ub = target + 0.5;
        int start = binarySearch(lb, nums);
        int end = binarySearch(ub, nums);
        if (nums[start] < target) start += 1;
        if (nums[end] > target) end -= 1;
        if (start > end) return new int[]{-1, -1};
        return new int[]{start, end};
    }

    public int binarySearch(double val, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < val) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
