class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int n = nums.length;
        for(int i=n-1; i>=0; i--) {
            if(set.contains(nums[i]+k)) {
                count++;
                while(i-1 >= 0 && nums[i] == nums[i-1])
                    i--;
            }
                
            set.add(nums[i]);
        }
        
        return count;
    }
}