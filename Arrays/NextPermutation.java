import static java.util.Arrays.sort;
/**
 * Created by juanyan.li on 3/26/17.
 */
public class NextPermutation {
    // sort can be replace with modifications to achieve O(n) time
    public void nextPermutation(int[] nums) {
        int maxIndex = nums.length - 1;
        int nextIndex = nums.length - 1;
        while (nextIndex >= 0) {
            if (nums[maxIndex] > nums[nextIndex]) {
                sort(nums, nextIndex + 1, nums.length);
                for (int i=nextIndex + 1; i<nums.length; i+=1) {
                    if (nums[i] > nums[nextIndex]) {
                        swap(i, nextIndex, nums);
                        break;
                    }
                }
                return;
            }
            if (nums[nextIndex] > nums[maxIndex]) maxIndex = nextIndex;
            nextIndex -= 1;
        }
        sort(nums);
    }

    public void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
