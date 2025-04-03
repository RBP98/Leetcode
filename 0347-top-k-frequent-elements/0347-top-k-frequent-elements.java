class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i: nums){
            minVal = Math.min(i, minVal);
            maxVal = Math.max(i, maxVal);
        }

        int[] freqArr = new int[maxVal - minVal + 1];
        int maxFreq = 0;
        for(int i: nums){
            freqArr[i - minVal]++;
            maxFreq = Math.max(maxFreq, freqArr[i - minVal]);
        }
        List<Integer>[] arr = new ArrayList[maxFreq + 1];

        for(int i = 0; i < freqArr.length; i++){
            int freq = freqArr[i];

            if(freq > 0){
                if(arr[freq] == null){
                    arr[freq] = new ArrayList<>();
                }
                arr[freq].add(i + minVal);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = maxFreq; i >= 0 && index < k; i--) {
            if (arr[i] != null) {
                for (int num : arr[i]) {
                    res[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}