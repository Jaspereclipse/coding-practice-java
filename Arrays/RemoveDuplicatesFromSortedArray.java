/**
 * Created by juanyan.li on 3/2/17.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicatesI(int[] nums){
        if (nums.length == 0) return 0;
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p2] == nums[p1]) {
                p2 += 1;
            } else {
                nums[p1+1] = nums[p2];
                p1 += 1;
            }
        }
        return p1 + 1;
    }

    public int removeDuplicatesII(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || nums[i-2] < num) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
