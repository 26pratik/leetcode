class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        int n = s.length();
        for(int i=0; i<n; i++) {
            map.put(s.charAt(i), i);
        }
        
        int min = 0, max = 0;
        
        for(int i=0; i<n; i++) {
            int freq = map.get(s.charAt(i));
            if(freq > max)
                max = freq;
            
            if(max == i) {
                result.add(max-min+1);
                min = i + 1;
            }
        }
        
        return result;
    }
}