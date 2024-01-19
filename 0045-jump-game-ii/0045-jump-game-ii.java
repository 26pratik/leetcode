class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        if(n <= 1) return 0;
        
        int curr = nums[0];
        int next = nums[0];
        int jump = 1;
        
        for(int i=1; i<n; i++) {
            if(curr >= n-1) return jump;
            next = Math.max(next, i+nums[i]);
            if(curr == i) {
                curr = next;
                jump++;
            }
        }
        
        return jump;
    }
}