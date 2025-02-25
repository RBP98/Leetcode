class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr = m + n - 1;
        int n1 = m - 1;
        int n2 = n - 1;

        while(n2 >= 0 && n1 >= 0){
            if(nums1[n1] < nums2[n2]){
                nums1[ptr] = nums2[n2];
                n2--;
            }else{
                nums1[ptr] = nums1[n1];
                n1--;
            }
            ptr--;

        }

        while(n2 >= 0){
            nums1[ptr] = nums2[n2];
            ptr--;
            n2--;
        }
    }
}