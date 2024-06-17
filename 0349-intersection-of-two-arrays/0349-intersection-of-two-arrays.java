class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }    
        set = new HashSet<Integer>();
        for(int i : list){
           set.add(i);
        }
        int[] arr = set.stream().mapToInt(Number::intValue).toArray();
        return arr;
    }
}