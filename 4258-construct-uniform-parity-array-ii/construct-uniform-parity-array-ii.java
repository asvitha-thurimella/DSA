class Solution {
    public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int x : nums1) {
            if (x % 2 == 0) {
                minEven = Math.min(minEven, x);
            } else {
                minOdd = Math.min(minOdd, x);
            }
        }

        // Try making everything odd
        boolean odd = true;

        for (int x : nums1) {
            if (x % 2 == 0) {
                // Need a smaller odd number
                if (minOdd >= x) {
                    odd = false;
                    break;
                }
            }
        }

        if (odd) {
            return true;
        }

        // Try making everything even
        boolean even = true;

        for (int x : nums1) {
            if (x % 2 == 1) {
                // Need a smaller odd number
                if (minOdd >= x) {
                    even = false;
                    break;
                }
            }
        }

        return even;
    }
}