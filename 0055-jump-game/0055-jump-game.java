class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length <= 1) return true;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        
        while(!q.isEmpty()) {
            int idx = q.poll();
            for(int i=1; i<=nums[idx]; i++) {
                int newIdx = i + idx;
                if(newIdx >= nums.length-1) return true;
                if(!set.contains(newIdx)) {
                    q.add(newIdx);
                    set.add(newIdx);
                }
                    
            }
        }
        
        return false;
    }
}