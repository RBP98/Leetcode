class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[s.length()];
        for(int[] shift: shifts){
            if(shift[2] == 1){
                arr[shift[0]]++;
                if(shift[1] + 1 < s.length()){
                    arr[shift[1] + 1]--;
                }
            }else{
                arr[shift[0]]--;
                if(shift[1] + 1 < s.length()){
                    arr[shift[1] + 1]++;
                }
            }
        }
        char[] result = new char[s.length()];
        int shiftValue = 0;
        for(int i = 0; i < s.length(); i++){
            char originalChar = s.charAt(i);
            shiftValue = (shiftValue + arr[i]) % 26;
            if(shiftValue < 0){
                shiftValue = shiftValue + 26;
            }

            result[i] = (char) ('a' +
                ((originalChar - 'a' + shiftValue) % 26));

                
        }

        return new String(result);
    }
}