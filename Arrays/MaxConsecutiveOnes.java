import static java.lang.Math.max;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int start = -1;
        int length = 0;
        for (int i=0; i<nums.length; i+=1){
            if (nums[i] == 0){
                length = max(i - start - 1, length);
                start = i;
            }
        }
        length = max(nums.length - start - 1, length);
        return length;
    }

    public void printRes(int num){
        System.out.println(num);
    }

    public static void main(String[] args){
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int[] inputs = new int[]{1,0,0,1,1,1};
        int res = mco.findMaxConsecutiveOnes(inputs);
        mco.printRes(res);
    }
}
