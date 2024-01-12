class Solution {
    public int arrayPairSum(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        boolean flag = false;
        
        for(int i=min; i<=max; i++) {
            if(map.containsKey(i)) {
                if(flag)
                    map.put(i, map.get(i)-1);
                
                int count = map.get(i);
                
                result += count/2*i;
                if(count%2 == 0) {
                    flag = false;
                }
                else {
                    flag = true;
                    result += i;
                }
            }
        }
        
        return result;
    }
}