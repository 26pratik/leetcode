class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character c: s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        StringBuilder sb = new StringBuilder();
        
        for(Character c: order.toCharArray()) {
            if(map.containsKey(c)) {
                int freq = map.get(c);
                
                for(int i=0; i<freq; i++)
                    sb.append(c);
                
                map.remove(c);
            }
        }
        
        for(char key: map.keySet()) {
            int freq = map.get(key);

            for(int i=0; i<freq; i++)
                sb.append(key);            
        }
        
        return sb.toString();
    }
}