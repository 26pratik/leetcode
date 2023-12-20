class Solution {
    
    List<List<String>> result;
    List<String> path;
    
    public List<List<String>> partition(String s) {
        
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(s, 0, 0, 0);
        return result;
    }
    
    private void helper(String s, int pivot, int i, int sum) {
        
        //base
        if(i == s.length()) {
            if(sum == s.length())
                result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //don't choose
        helper(s, pivot, i+1, sum);
        
        //choose
        String sub = s.substring(pivot, i+1);

        if(isPalindrome(sub)) {
            //action
            path.add(sub);
            //recurse
            helper(s, i+1, i+1, sum+sub.length());
            //backtrack
            path.remove(path.size()-1);
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