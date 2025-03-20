class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int len = m + n - 1;

        while(n1 >= 0 || n2 >= 0){
            if(n2 < 0){
                break;
            }

            if(n1 >= 0 && nums1[n1] > nums2[n2]){
                nums1[len] = nums1[n1];
                n1--;
                len--;
            }else{
                nums1[len] = nums2[n2];
                n2--;
                len--;
            }
        }
    }
}