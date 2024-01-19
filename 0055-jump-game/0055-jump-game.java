class Solution {
    
    int[] arr;
    public boolean canJump(int[] nums) {
        
        if(nums.length <= 1) return true;
        this.arr = new int[nums.length];  //0:unexplored, 1:explored and true, -1: explored nad false 
        int result = dfs(nums, 0);
        if(result == 1) return true;
        return false;
    }
    
    private int dfs(int[] nums, int idx) {
        
        //base
        if(idx >= nums.length-1) return 1;
        if(arr[idx] != 0) return arr[idx];
        
        //logic
        for(int i=1; i<=nums[idx]; i++) {
            int newIdx = idx+i;
            if(arr[newIdx] == 0) {
                arr[newIdx] = dfs(nums, newIdx);
            }
            if(arr[newIdx] == 1) return 1;
        }
        arr[idx] = -1;
        return -1;
    }
}