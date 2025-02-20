class Solution {
    public int openLock(String[] deadends, String target) {
         Map<Character, Character> next = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        Map<Character, Character> prev = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        for(String s: deadends){
            visited.add(s);
        }
        
        if(visited.contains("0000")){
            return -1;
        }
        queue.add("0000");
        visited.add("0000");

        
        
        int turns = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int j = 0; j < size; j++){
                String temp = queue.poll();

                if(temp.equals(target)){
                    return turns;
                }

                for(int i = 0; i < 4; i++){
                    StringBuilder newCombo = new StringBuilder(temp);
                    newCombo.setCharAt(i, next.get(newCombo.charAt(i)));

                    if(!visited.contains(newCombo.toString())){
                        visited.add(newCombo.toString());
                        queue.add(newCombo.toString());
                    }

                    newCombo = new StringBuilder(temp);
                    newCombo.setCharAt(i, prev.get(newCombo.charAt(i)));

                    if(!visited.contains(newCombo.toString())){
                        visited.add(newCombo.toString());
                        queue.add(newCombo.toString());
                    }
                }
            }
            turns++;
            
        }
    return -1;
    }

}