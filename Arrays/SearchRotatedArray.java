/**
 * Created by juanyan.li on 3/3/17.
 */
public class SearchRotatedArray {
    // no duplicates allowed
    public int searchI(int[] nums, int target){
        // find the smallest
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = (low + high) / 2; // always less than high
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        // high is the smallest
        int shift = high;
        low = 0;
        high = nums.length - 1;
        // binary search on rotated array
        while (low <= high) {
            int mid = (low + high) / 2;
            int mappedMid = (mid + shift) % nums.length;
            if (nums[mappedMid] == target) return mappedMid;
            else if (nums[mappedMid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // duplicates allowed
    public boolean searchII(int[] nums, int target){
        // find the smallest
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = (low + high) / 2; // always less than high
            if (nums[mid] > nums[high]) low = mid + 1;
            else if (nums[mid] < nums[high]) high = mid;
            else { // mid == high
                int p = high;
                boolean leftSide = true;
                while (mid <= p) {
                    if (nums[mid] == nums[p]) p -= 1;
                    else {
                        leftSide = false;
                        break;
                    }
                }
                if (leftSide) high = mid;
                else low = mid + 1;
            }
        }
        // high is the smallest
        int shift = high;
        low = 0;
        high = nums.length - 1;
        // binary search on rotated array
        while (low <= high) {
            int mid = (low + high) / 2;
            int mappedMid = (mid + shift) % nums.length;
            if (nums[mappedMid] == target) return true;
            else if (nums[mappedMid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public void printRes(int res){
        System.out.println(res);
    }

    public void printRes(boolean res){
        System.out.println(res);
    }

    public static void main(String[] args){
        SearchRotatedArray srp = new SearchRotatedArray();
        int[] inputs = new int[]{4,5,6,7,1,2,3};
        srp.printRes(srp.searchI(inputs, 2));
        inputs = new int[]{1,1,3,3,1,1,1};
        srp.printRes(srp.searchII(inputs, 3));
        inputs = new int[]{3,1,1,1,1};
        srp.printRes(srp.searchII(inputs, 3));
        inputs = new int[]{4,5,3,3,3,3,3,3};
        srp.printRes(srp.searchII(inputs, 4));
    }
}
