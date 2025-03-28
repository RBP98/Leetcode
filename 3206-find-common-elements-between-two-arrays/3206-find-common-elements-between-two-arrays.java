class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i: nums1){
            set1.add(i);
        }
        for(int i: nums2){
            set2.add(i);
        }
        int count1 = 0;
        int count2 = 0;

        for(int i: nums1){
            if(set2.contains(i)){
                count1++;
            }
        }

        for(int i: nums2){
            if(set1.contains(i)){
                count2++;
            }
        }

        return new int[]{count1, count2};
    }
}