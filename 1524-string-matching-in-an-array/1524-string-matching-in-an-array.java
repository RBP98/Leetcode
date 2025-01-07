class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> output = new HashSet<>();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j){
                    if(words[i].length() > words[j].length()){
                        if(words[i].contains(words[j])){
                            output.add(words[j]);
                        }
                    }else{
                        if(words[j].contains(words[i])){
                            output.add(words[i]);
                        }
                    }
                    
                }
            }
        }
        return new ArrayList<>(output);
    }
}