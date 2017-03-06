/**
 * Created by juanyan.li on 3/2/17.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0; // become slow
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
