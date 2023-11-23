class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int x: nums)
            set.add(x);
        
        for(int i=1; i<=n; i++) {
            if(!set.contains(i))
                result.add(i);
        }
        
        return result; 
    }
}