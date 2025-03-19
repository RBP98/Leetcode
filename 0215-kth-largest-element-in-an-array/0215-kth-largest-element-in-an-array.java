class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }

        return quickSelect(list, k);

    }

    private int quickSelect(List<Integer> list, int k){
        Random rand = new Random();
        int pivotIndex = rand.nextInt(list.size());
        int pivot = list.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i: list){
            if(i == pivot){
                mid.add(i);
            }else if(i > pivot){
                left.add(i);
            }else{
                right.add(i);
            }
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