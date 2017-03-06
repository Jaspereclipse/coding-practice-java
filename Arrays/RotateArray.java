/**
 * Created by juanyan.li on 2/27/17.
 */
public class RotateArray {
    public void rotate(int[] nums, int k){
        k %= nums.length;
        if (k == 0) return;
        int from = 0;
        int to = (from + k) % nums.length;
        int cnt = 0;
        while (cnt < nums.length) {
            while (from != to) {
                int tmp = nums[to];
                nums[to] = nums[from];
                nums[from] = tmp;
                to = (to + k) % nums.length;
                cnt += 1;
            }
            cnt += 1;
            from += 1;
            to = (from + k) % nums.length;
        }
    }

    public void printRes(int[] nums){
        for (int num: nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        RotateArray ra = new RotateArray();
        int[] inputs = new int[]{1,2,3,4,5,6};
        ra.rotate(inputs, 2);
        ra.printRes(inputs);
    }
}
