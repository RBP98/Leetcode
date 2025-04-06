class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;

        int index = 0;

        for(int j = 0; j < 4; j++){
            for(int i = 0; i < instructions.length(); i++){
                char c = instructions.charAt(i);

                if(c == 'R'){
                    index = (index + 1) % 4;
                }else if(c == 'L'){
                    index = (index + 3) % 4;
                }else{
                    x = x + directions[index][0];
                    y = y + directions[index][1];
                }
            }
            if(x == 0 && y == 0) return true;
        }
        


        return (x == 0 && y == 0);
    }
}