class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    private boolean isValid(String s){
        if (s == null || s.isEmpty()) return false;
        char first = Character.toLowerCase(s.charAt(0));
        char last = Character.toLowerCase(s.charAt(s.length() - 1));
        return VOWELS.contains(first) && VOWELS.contains(last);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + (isValid(words[i]) ? 1 : 0);
        }

        int[] output = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            left = Math.max(0, left);
            right = Math.min(n - 1, right);
            output[i] = prefixSum[right + 1] - prefixSum[left];
        }

        return output;
    }
}
