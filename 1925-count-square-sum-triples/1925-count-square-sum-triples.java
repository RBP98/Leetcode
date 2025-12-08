class Solution {
    public int countTriples(int n) {
        int sqArr[] = new int[n];
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            sqArr[i] = (i + 1) * (i + 1);
            set.add(sqArr[i]);
        }
        int count = 0;
        for(int i = 0; i < sqArr.length; i++){
            for(int j = i; j < sqArr.length; j++){
                if(set.contains(sqArr[i] + sqArr[j])){
                    count= count + 2;
                }
            }
        }

        return count;
    }
}