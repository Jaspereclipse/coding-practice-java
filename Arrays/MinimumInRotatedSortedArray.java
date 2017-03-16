/**
 * Created by juanyan.li on 3/13/17.
 */
public class MinimumInRotatedSortedArray {
    public int findMinI(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[left] <= nums[mid] && nums[mid] < nums[right]) return nums[left];
            if (nums[right] <= nums[left] && nums[left] <= nums[mid])  left = mid + 1;
            if (nums[mid] < nums[right] && nums[right] < nums[left]) right = mid;
        }
        return nums[left];
    }

    public int findMinII(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        boolean found;
        while (left < right) {
            int mid = (right + left) / 2;
            while (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                found = false;
                for (int i=mid+1; i<right;i+=1) {
                    if (nums[i] != nums[left]) {
                        left = i;
                        mid = (left + right) / 2;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    right = mid;
                    if (left < right) mid = (left + right) / 2;
                    else break;
                }
            }
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) return nums[left];
            if (nums[right] <= nums[left] && nums[left] <= nums[mid])  left = mid + 1;
            if (nums[mid] <= nums[right] && nums[right] <= nums[left]) right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray mrsa = new MinimumInRotatedSortedArray();
        int[] inputs = new int[]{5,6,1,2,3,4};
        int res = mrsa.findMinI(inputs);
    }
}
