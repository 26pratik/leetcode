class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n == 0) return tasks.length;
        
        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(char c: tasks) {
            if(!map.containsKey(c))
                map.put(c, 0);
            int freq = map.get(c) + 1;
            map.put(c, freq);
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        int result = ((n+1)*(maxFreq-1) + maxCount);
        return tasks.length < result ? result : tasks.length;
    }
}