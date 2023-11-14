//Time Complexity : O(nk)
class Solution {
    
    int[] primeArr;
    public List<List<String>> groupAnagrams(String[] strs) {
        
        primeArr = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        Map<Double, List<String>> map = new HashMap<>();
        
        for(String s : strs) { //O(n)

            double key = getHash(s); //O(k)
            
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private double getHash(String s) {
        
        double hash = 1d;
        
        for(char ch : s.toCharArray())
            hash *= primeArr[ch - 'a'];
        
        return hash;
    }
}