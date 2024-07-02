import java.util.*;

class Solution {
    // 현재 선택된 할인 비율
    static int[] salesPer;
    static int[] sales = {0, 10, 20, 30, 40};
    static int N;
    // 플러스 구매 인원
    static int plusBuy = 0;
    // 총 금액
    static int totalBuy = 0;
    // 구매가격 저장
    static int[][] savedBuy;
    
    public int[] solution(int[][] users, int[] emoticons) {
        salesPer = new int[emoticons.length];
        N = emoticons.length;
        savedBuy = new int[N][5];
        salesCal(emoticons);
        
        dfs(0, users, emoticons);
        
        int[] answer = {plusBuy, totalBuy};
        return answer;
    }
    
    private static void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == N){
            calculator(users, emoticons);
            return;
        }
        
        for(int i=1; i <= 4; i++){
            salesPer[depth] = i;
            dfs(depth + 1, users, emoticons);
            salesPer[depth] = 0;
        }
    }
    
    // 구매 금액 계산
    private static void calculator(int[][] users, int[] emoticons){
        int plus = 0;
        int totalPrice = 0;
        for(int i=0; i<users.length; i++){
            int total = 0;
            for(int j=0; j<N; j++){
                // 할인 금액에 충족하는 것만 계산
                if(users[i][0] <= sales[salesPer[j]]) total += savedBuy[j][salesPer[j]];
            }
            // 구매 취소
            if(total >= users[i][1]){
                plus++;
                continue;
            }
            totalPrice += total;
        }
        
        if(plusBuy < plus){
            plusBuy = plus;
            totalBuy = totalPrice;
        }else if(plusBuy == plus){
            if(totalBuy < totalPrice) totalBuy = totalPrice;
        }
    }
    
    // 할인 금액 미리 계산
    private static void salesCal(int[] emoticons){
        for(int i=0; i<N; i++){
            for(int j=1; j<5; j++){
                savedBuy[i][j] = emoticons[i] - (int) (emoticons[i] * (0.1 * j));
            }
        }
    }
}