class Solution {
    static int count = 0;
    static int N = 0;
    static int[] number;
    
    public int solution(int[] numbers, int target) {
        
        number = numbers;
        N = numbers.length;
        dfs(0, 0, target);
        
        return count;
    }
    
    public static void dfs(int depth, int sum, int target){
        if(depth == N){
            if(sum == target){
                count++;
            }
            return;
        }
        
        dfs(depth + 1, sum + number[depth], target);
        dfs(depth + 1, sum - number[depth], target);
    }
}