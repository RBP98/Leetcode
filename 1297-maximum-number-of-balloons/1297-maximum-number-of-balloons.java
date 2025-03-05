class Solution {
    public int maxNumberOfBalloons(String text) {
    
        int[] first = {1,1,2,2,1};
        int[] second = balloonMap(text);

        int minMod = Integer.MAX_VALUE;
        
        for(int i = 0; i < 5; i++){
            minMod = Math.min(minMod, second[i] / first[i]);
        }
      return minMod;
    }

    private int[] balloonMap(String text){
        int[] res = new int[5];
        for(char c: text.toCharArray()){
            if(c == 'a'){
                res[0]++;
            }else if(c == 'b'){
                res[1]++;
            }else if(c == 'l'){
                res[2]++;
            }else if(c == 'o'){
                res[3]++;
            }else if(c == 'n'){
                res[4]++;
            }
        }
        
    return res;
    }
}