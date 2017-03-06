import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by juanyan.li on 2/27/17.
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i+=1){
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int j=0; j<nums.length; j+=1){
            if (nums[j] > 0){
                list.add(j+1);
            }
        }
        return list;
    }

    public void printRes(List<Integer> list){
        for (int elem: list){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        FindDisappearedNumbers fdn = new FindDisappearedNumbers();
        int[] inputs = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = fdn.findDisappearedNumbers(inputs);
        fdn.printRes(res);
    }
}
