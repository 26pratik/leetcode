class Solution {
    
    List<List<String>> result;
    List<String> path;
    
    public List<List<String>> partition(String s) {
        
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path) {
        
        //base
        if(pivot == s.length())
            result.add(new ArrayList<>(path));
        //logic
        
        for(int i=pivot; i<s.length(); i++) {
            
            String sub = s.substring(pivot, i+1);
            
            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        
        int start = 0, end = s.length()-1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}