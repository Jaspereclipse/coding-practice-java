import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * Created by juanyan.li on 3/4/17.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pivot;
        double median;
        if (nums1.length > nums2.length) {
            pivot = findPivot(nums2, nums1, 0, nums2.length);
            median = findMedian(nums2, nums1, pivot);
        } else {
            pivot = findPivot(nums1, nums2, 0, nums1.length);
            median = findMedian(nums1, nums2, pivot);
        }
        return median;
    }

    public int findPivot(int[] s, int[] l, int low, int high) {
        if (low == high) return low;
        int i = (low + high) / 2;
        int j = (s.length + l.length + 1) / 2 - i;
        if (j > 0 && l[j-1] > s[i]) return findPivot(s, l, i+1, high);
        else if (i > 0 && s[i-1] > l[j]) return findPivot(s, l, low, i-1);
        else return i;
    }

    public double findMedian(int[] s, int[] l, int pivot) {
        int i = pivot;
        int j = (s.length + l.length + 1) / 2 - i;
        double maxLeft;
        double minRight;
        if (i == 0) maxLeft = l[j-1];
        else if(j == 0) maxLeft = s[i-1];
        else maxLeft = max(l[j-1], s[i-1]);

        if (2 * (i + j) == s.length + l.length + 1) return maxLeft;

        if (i == s.length) minRight = l[j];
        else if (j == l.length) minRight = s[i];
        else minRight = min(l[j], s[i]);
        return (minRight + maxLeft) / 2;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays mta = new MedianOfTwoSortedArrays();
        double median = mta.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(median);
    }
}
