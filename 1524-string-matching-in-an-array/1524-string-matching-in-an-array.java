class Solution {
    private boolean subInMain(String sub, String main){
        return main.contains(sub);
    }

    public List<String> stringMatching(String[] words) {
        Set<String> output = new HashSet<>();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j){
                    if(words[i].length() < words[j].length()){
                        if(subInMain(words[i], words[j])){
                            output.add(words[i]);
                        }
                    }else{
                        if(subInMain(words[j], words[i])){
                            output.add(words[j]);
                        }
                    }
                    
                }
            }
        }
        return new ArrayList<>(output);
    }
}