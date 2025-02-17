class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];    
        helper(nums, list, ans, arr);
        return ans;
    }

    public void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] arr){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!arr[i]){
                list.add(nums[i]);
                arr[i] = true;
                helper(nums, list, ans, arr);
                list.remove(list.size() - 1);
                arr[i] = false;
            }
        }
    }
}