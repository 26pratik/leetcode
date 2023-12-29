class Solution {
    
    TrieNode root;
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String longestWord(String[] words) {
        
        this.root = new TrieNode();
        
        for(String word: words)
            insert(word);
        
        String path = "";
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();
        
        q.add(root);
        strQ.add("");
        
        while(!q.isEmpty()) {
            TrieNode curr = q.poll();
            path = strQ.poll();
            
            for(int i=25; i>=0; i--) {
                if(curr.children[i] != null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                    strQ.add(path + (char)(i + 'a'));
                }
            }
        }
        
        return path;
    }
}