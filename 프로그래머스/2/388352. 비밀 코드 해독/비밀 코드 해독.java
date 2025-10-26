import java.util.*;

class Solution {
    
    static int[] password = new int[5];
    static int answer = 0;
    static int[][] qa;
    static int[] ansa;
    
    public int solution(int n, int[][] q, int[] ans) {
        qa = q;
        ansa = ans;
        
        combi(0, 1, n);
        
        return answer;
    }
    
    public static void combi(int index, int num, int n){
        if(index == 5){
            // 비밀번호 맞는지 검증
            if(check()){
                answer++;
            }
            return;
        }
        // 비밀번호가 n을 넘으면 불가능.
        if(num > n) return;
        
        for(int i=num; i<=n; i++){
            password[index] = i;
            combi(index + 1, i + 1, n);
        }

        
        
    }
    
    public static boolean check(){
        for(int i=0; i<qa.length; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                int passNum = password[j];
                for(int k=0; k<5; k++){
                    if(qa[i][k] == passNum){
                        count++;
                        break;
                    }
                }
                if(count > ansa[i]) return false;
            }
            if(count < ansa[i]) return false;
        }
        
        return true;
    }
}