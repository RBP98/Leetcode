class Solution {
    private boolean isArrValid(char[] arr){
        Set<Character> set = new HashSet<>();
        for(char c: arr){
            if(!set.contains(c)){
                if(c != '.'){
                    set.add(c);
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        char[][] temp = new char[n][m];

        for(int i = 0; i < m; i++){
            if(!isArrValid(board[i])){
                return false;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = board[j][i];
            }
        }

        for(int i = 0; i < n; i++){
            if(!isArrValid(temp[i])){
                return false;
            }
        }

        for(int i = 0; i < m; i = i + 3){
            for(int j = 0; j < n; j = j + 3){
                Set<Character> set = new HashSet<>();
      
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        if(!set.contains(board[k][l])){
                            if(board[k][l] != '.'){
                                set.add(board[k][l]);
                            }
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}