class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.size() == 3){
                if(set.contains(nums[i])){
                    continue;
                }
                if(nums[i] > set.first()){
                    set.pollFirst();
                    set.add(nums[i]);
                }


            }else{
                set.add(nums[i]);
            }
        }

        if(set.size() == 3) return set.first();
        else return set.last();
    }
}