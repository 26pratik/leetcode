/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    HashMap<Integer, Employee> map;
    int result;    
    public int getImportance(List<Employee> employees, int id) {
        
        this.map = new HashMap<>();
        this.result = 0;
        
        for(Employee e: employees) 
            map.put(e.id, e);
        
        dfs(id);
        
        return result;
    }
    
    private void dfs(int id) {
        
        Employee e = map.get(id);
        result += e.importance;
        
        for(int i: e.subordinates)
            dfs(i);
    }
}