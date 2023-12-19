class Solution {
    
    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        
        this.result = new ArrayList<>();
        
        helper(num, target, 0, 0, "", 0);
        
        return result;
    }
    
    private void helper(String num, int target, long calc, long tail, String path, int pivot) {
        
        if(pivot == num.length() && calc == target)
            result.add(new String(path));
        
        for(int i=pivot; i<num.length(); i++) {
            
            if(i != pivot && num.charAt(pivot) == '0') continue;
            
            long curr = Long.parseLong(num.substring(pivot, i+1));
            
            if(pivot == 0) {
                helper(num, target, curr, curr, path+curr, i+1);
            }
            else {
                //+
                helper(num, target, calc+curr, curr, path+"+"+curr, i+1);
                
                //-
                helper(num, target, calc-curr, -curr, path+"-"+curr, i+1);
                
                //*
                helper(num, target, (calc-tail)+(tail*curr), tail*curr, path+"*"+curr,i+1);
            }
            
        }
    }
}