//Time Complexity : O(nk log(k))
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) { //log(n)
            
            char[] c = s.toCharArray();
            Arrays.sort(c); //(k log(k))
            String sorted = String.valueOf(c);
            
            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());
            
            map.get(sorted).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}