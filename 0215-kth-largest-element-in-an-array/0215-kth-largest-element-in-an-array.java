class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> numsList, int k){
        Random random = new Random();
        int pivot = numsList.get(random.nextInt(numsList.size()));

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 0; i < numsList.size(); i++){
            int num = numsList.get(i);
            if(num > pivot) left.add(num);
            else if(num < pivot) right.add(num);
            else mid.add(num);
        }

        if(left.size() >= k){
            return quickSelect(left, k);
        }

        if(left.size() + mid.size() < k){
            return quickSelect(right, k - (left.size() + mid.size()));
        }

        return pivot;
    }
}