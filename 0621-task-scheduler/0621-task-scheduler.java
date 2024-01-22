class Solution {
    public int leastInterval(char[] tasks, int n) {
        
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
        
        int partitions = maxFreq - 1;
        int availableSlots = (n - (maxCount-1)) * partitions;
        int pendingSlots = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingSlots);
        
        return tasks.length + idleSlots;
    }
}