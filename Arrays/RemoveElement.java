
/**
 * Created by juanyan.li on 2/26/17.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val){
        int p = nums.length - 1;
        int cnt = 0;
        for (int i=nums.length-1; i>=0; i-=1){
            if (nums[i] == val) {
                nums[i] = nums[p];
                nums[p] = val;
                p -= 1;
                cnt += 1;
            }
        }
        for (int num: nums){
            System.out.print(num);
            System.out.print(" ");
        }
        return nums.length - cnt;
    }

    public void printRes(int len){
        System.out.println("Length: " + len);
    }

    public static void main(String[] args){
        RemoveElement re = new RemoveElement();
        int[] inputs = new int[]{2,3,2,2,3,2};
        int res = re.removeElement(inputs, 3);
        re.printRes(res);
    }
}
