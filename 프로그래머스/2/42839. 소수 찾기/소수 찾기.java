import java.util.*;

class Solution {
    
    static boolean[] sosu = new boolean[10000000];
    static boolean[] check = new boolean[10000000];
    static boolean[] visited; 
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        Arrays.fill(sosu, true);
        checkSosu();
        
        combi(0, numbers);
        
        return count;
    }
    
    private static void checkSosu(){
        sosu[0] = sosu[1] = false;
        
        for(int i=2; i <= Math.sqrt(sosu.length); i++){
            if(sosu[i]){
                for(int j = i * i; j < sosu.length; j += i){
                    sosu[j] = false;
                }
            }
        }
    }
    
    private static void combi(int depth, String numbers){
        // 종료
        if(depth == numbers.length()){
            if(sb.length() == 0) return;
            
            int num = Integer.parseInt(sb.toString());
            if(check[num]) return;
            if(sosu[num]){
                count++;
            } 
            check[num] = true;       
            return;
        }
        
        // 재귀
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            if(sb.length() == 0 && numbers.charAt(i) == '0') continue;
            sb.append(numbers.charAt(i));
            visited[i] = true;
            
            // 선택한 경우
            combi(depth + 1, numbers);
            sb.delete(sb.length() - 1, sb.length());
            
            // 선택하지 않은 경우
            combi(depth + 1, numbers);
            visited[i] = false;
        }
        
    }
}