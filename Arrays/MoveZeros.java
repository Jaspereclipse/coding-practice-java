/**
 * Created by juanyan.li on 2/21/17.
 */
public class MoveZeros {
    public void moveZeros(int[] nums){
        int count = 0;
        for (int i=0; i<nums.length; i+=1){
            if (nums[i] == 0) {
                count += 1;
            } else {
                nums[i - count] = nums[i];
            }
        }
        while (count > 0){
            nums[nums.length - count] = 0;
            count -= 1;
        }
    }

    public void printRes(int[] nums){
        System.out.print("[");
        for (int num : nums){
            System.out.print(num + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args){
        MoveZeros mz = new MoveZeros();
        int[] inputs = new int[]{0,1,0,3,12};
        mz.moveZeros(inputs);
        mz.printRes(inputs);
    }
}
