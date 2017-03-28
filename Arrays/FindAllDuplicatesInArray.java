import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

/**
 * Created by juanyan.li on 3/24/17.
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            int absVal = abs(num);
            if (nums[absVal - 1] < 0) duplicates.add(absVal);
            else nums[absVal - 1] = -nums[absVal - 1];
        }
        return duplicates;
    }
}
