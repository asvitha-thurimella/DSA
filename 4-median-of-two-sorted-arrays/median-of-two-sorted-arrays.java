

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        List<Integer> num3 = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                num3.add(nums1[i++]);
            } else {
                num3.add(nums2[j++]);
            }
        }

        
        int size = num3.size();
        if (size % 2 == 1) {
            return num3.get(size / 2);  
        } else {
            return (num3.get(size / 2 - 1) + num3.get(size / 2)) / 2.0;
        }
    }

}
