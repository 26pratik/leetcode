class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        StringBuilder result = new StringBuilder("");
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<indices.length; i++) {
            int sLen = sources[i].length();
            int index = indices[i];
            if(index+sLen <= n && sources[i].equals(s.substring(index, index+sLen))) {
                map.put(index, i);
            }              
        }
        
        for(int i=0; i<n; i++) {
            if(map.containsKey(i)) {
                int value = map.get(i);
                result.append(targets[value]);
                i = i + sources[value].length() - 1;
            }
            else {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}