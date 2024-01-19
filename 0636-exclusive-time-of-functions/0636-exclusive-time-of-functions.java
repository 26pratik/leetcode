class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prevTime = 0;
        
        for(String log: logs) {
            String[] str = log.split(":");
            int id = Integer.parseInt(str[0]);
            int currTime = Integer.parseInt(str[2]);
            if(str[1].equals("start")) {
                if(!st.isEmpty())
                    result[st.peek()] += currTime - prevTime;
                st.push(id);
            }
            else {
                currTime = currTime + 1;
                result[st.pop()] += currTime - prevTime;
            }
            prevTime = currTime;
        }
        
        return result;
    }
}