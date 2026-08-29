class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
       int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n && arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            int len = end - start + 1;

            int[] values = new int[len];
            int[] indices = new int[len];

            for (int i = 0; i < len; i++) {
                values[i] = arr[start + i][0];
                indices[i] = arr[start + i][1];
            }

            Arrays.sort(indices);

            for (int i = 0; i < len; i++) {
                nums[indices[i]] = values[i];
            }

            start = end + 1;
        }

        return nums;   
    }
}