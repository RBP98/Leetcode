class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            int value = 1;
            temp.add(1);
            for(int j = 0; j < i; j++){
                value = value * (i - j)/(j + 1);
                temp.add(value);
            }
            result.add(temp);
        }
        return result;
    }
}