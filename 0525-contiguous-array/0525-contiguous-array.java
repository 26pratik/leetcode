//Running Sum
class Solution {
    public int findMaxLength(int[] nums) {
        
        int max = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0)   
                sum--;
            else
                sum ++;
            
            if(map.containsKey(sum))
                max = Math.max(max, i-map.get(sum));
            else
                map.put(sum, i);
        }
        
        return max;
    }
}