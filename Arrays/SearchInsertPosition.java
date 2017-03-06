import static java.lang.Math.max;

/**
 * Created by juanyan.li on 2/27/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target){
        if (nums.length < 1) return 0;
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        boolean same = (end == start);
        int mid = (end + start) / 2; // mid or left mid
        if (nums[mid] == target){
            return mid; // found
        } else if (target < nums[mid]){
            if (same) return max(0, mid);
            return binarySearch(nums, start, max(start, mid-1), target);
        } else {
            if (same) return mid + 1;
            return binarySearch(nums, mid + 1, end, target);
        }
    }

    public void printRes(int num){
        System.out.println(num);
    }

    public static void main(String[] args){
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] inputs = new int[]{1,3,5,6};
        int res = sip.searchInsert(inputs, 5);
        sip.printRes(res);
        res = sip.searchInsert(inputs, 2);
        sip.printRes(res);
        res = sip.searchInsert(inputs, 7);
        sip.printRes(res);
        res = sip.searchInsert(inputs, 0);
        sip.printRes(res);
        inputs = new int[]{1,3};
        res = sip.searchInsert(inputs, 0);
        sip.printRes(res);
        inputs = new int[]{1};
        res = sip.searchInsert(inputs, 1);
        sip.printRes(res);
        inputs = new int[]{1,3};
        res = sip.searchInsert(inputs, 2);
        sip.printRes(res);
        inputs = new int[]{3,5,7,9,10};
        res = sip.searchInsert(inputs, 8);
        sip.printRes(res);
    }
}
