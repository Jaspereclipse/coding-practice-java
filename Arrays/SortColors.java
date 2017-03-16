/**
 * Created by juanyan.li on 3/6/17.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i=0; i<nums.length; i+=1) {
            int temp = nums[i];
            nums[i] = 2;
            if (temp < 2) {
                nums[second] = 1;
                second += 1;
            }
            if (temp < 1) {
                nums[first] = 0;
                first += 1;
            }
        }
    }
}
