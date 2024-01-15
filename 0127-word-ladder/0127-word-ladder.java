class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for(String word: beginSet) {
                List<String> neighbours = neighbour(word);
                for(String neigh: neighbours) {
                    if(endSet.contains(neigh)) return length+1;
                    if(words.contains(neigh)) {
                        newBeginSet.add(neigh);
                        words.remove(neigh);
                    }
                }
            }
            beginSet = newBeginSet;
            length++;
        }
        
        return 0;
    }
    
    private List<String> neighbour(String currWord) {
        char[] word = currWord.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i=0; i<word.length; i++) {
            char temp = word[i];
            for(char j='a'; j<='z'; j++) {
                word[i] = j;
                String neigh = new String(word);
                result.add(neigh);
            }
            word[i] = temp;
        }
        return result;
    }
}