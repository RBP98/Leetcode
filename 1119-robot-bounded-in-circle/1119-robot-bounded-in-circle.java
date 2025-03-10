class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'L'){
                index = (index + 3) % 4;
            }else if(c == 'R'){
                index = (index + 1) % 4;
            }else{
                x = x + directions[index][0];
                y = y + directions[index][1];
            }
        }
        return (x == 0 && y == 0) || index != 0;  
    }
}