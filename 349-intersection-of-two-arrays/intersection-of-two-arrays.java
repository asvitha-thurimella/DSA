class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    int n=nums1.length;
    int m=nums2.length;
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    ArrayList<Integer> arr=new ArrayList<>();
    int i=0;
    int j=0;
    while(i<n && j<m)
    {
        if(nums1[i]==nums2[j])
        {    if (arr.isEmpty() || arr.get(arr.size() - 1) != nums1[i]) {
                    arr.add(nums1[i]);
                }
               i++;
               j++;
        }
        else if(nums1[i]>nums2[j])
        {
            j++;
        }
        else
        {
            i++;
        }
    }
        int[] result = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            result[k] = arr.get(k);
        }

        return result;
    

    }
}