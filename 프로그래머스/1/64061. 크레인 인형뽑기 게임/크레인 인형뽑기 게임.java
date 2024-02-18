import java.util.*;

class Solution {
    
    static int[][] graph;
    
    public int solution(int[][] board, int[] moves) {
        graph = board;
        int result = 0;
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int teddy = teddyCatch(moves[i] - 1);
            if(teddy == 0) continue;
            if(!s.isEmpty()){
                int temp = s.peek();
                // 보관함 위의 인형과 현재 뽑을 인형이 같으면 터트림
                if(temp == teddy){
                    s.pop();
                    result += 2;
                }else{
                    s.push(teddy);
                }
            }else{
                s.push(teddy);
            }
        }
        
        return result;
    }
    
    // 인형 뽑는 메서드
    public int teddyCatch(int x){
        for(int i=0; i<graph.length; i++){
            if(graph[i][x] != 0){
                int result = graph[i][x];
                graph[i][x] = 0;
                return result;
            } 
        }
        return 0;
    }
}