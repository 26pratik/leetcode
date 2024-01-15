class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> words = new HashSet<>(wordList);
        queue.add(beginWord);
        words.remove(beginWord);
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++) {
                String currWord = queue.poll();
                if(currWord.equals(endWord)) return level;
                List<String> neighbours = neighbour(currWord);
                for(String neigh: neighbours) {
                    if(words.contains(neigh)) {
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
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