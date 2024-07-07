class Pair{
    String word;
    int step;
    public Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int step = p.step;
            if(word.equals(endWord)){
                return step;
            }
            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] arr = word.toCharArray();
                    arr[i] = c;
                    String temp = new String(arr);
                    if(set.contains(temp)){
                        queue.add(new Pair(temp, step + 1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}