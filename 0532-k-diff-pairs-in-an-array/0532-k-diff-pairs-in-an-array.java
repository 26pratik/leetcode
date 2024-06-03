class Solution {
    public int findPairs(int[] nums, int k) {
     
        HashSet<Integer> num = new HashSet<>();
        HashSet<Pair<Integer, Integer>> result = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            int val = nums[i]+k;
            if(num.contains(val))
                result.add(new Pair<>(nums[i],val));
            val = nums[i]-k;
            if(num.contains(val))
                result.add(new Pair<>(val,nums[i]));
            num.add(nums[i]);
        }
        
        return result.size();
    }
}