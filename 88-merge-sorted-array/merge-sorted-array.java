class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int len=m+n;
    int k=0;
    int[] arr=new int[len];
    for(int i=0;i<m;i++)
    {
     arr[k]=nums1[i];
       k++;
    }
    for(int j=0;j<n;j++)
    {
     arr[k]=nums2[j];
       k++;
    }
    Arrays.sort(arr);
   for (int z = 0; z < len; z++) {
    nums1[z] = arr[z];
}

    }
}