/**
 * Created by juanyan.li on 3/2/17.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        while (m > 0 && n > 0){
            if (nums1[m-1] < nums2[n-1]) {
                nums1[n+m-1] = nums2[n-1];
                n -= 1;
            } else {
                nums1[n+m-1] = nums1[m-1];
                m -= 1;
            }
        }
        if (n > 0) {
            for (int i=n; i>0; i-=1){
                nums1[i+m-1] = nums2[i-1];
            }
        }
        return;
    }
}
