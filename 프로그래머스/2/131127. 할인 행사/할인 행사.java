import java.util.*;

class Solution {
    static int[][] sliding;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int day = 0;
        sliding = new int[want.length][1];
        // 초기 슬라이딩 윈도우 설정
        for(int i=0; i<10; i++){
            for(int j=0; j<want.length; j++){
                if(discount[i].equals(want[j])){
                    sliding[j][0] += 1;
                    break;
                }
            }
        }
        if(check(number)) day++;
        
        // 이제 discount 돌아야함.
        for(int i=1; i<=discount.length - 10; i++){
            // 이전 날짜 삭제
            int temp = -1;
            String target = discount[i-1];
            for(int j=0; j<want.length; j++){
                if(target.equals(want[j])){
                    temp = j;
                    break;
                }
            }
            if(temp != -1) sliding[temp][0]--;
            // 이후 날짜 추가
            target = discount[i+9];
            temp = -1;
            for(int j=0; j<want.length; j++){
                if(target.equals(want[j])){
                    temp = j;
                    break;
                }
            }
            if(temp != -1) sliding[temp][0]++;
            if(check(number)) day++;
        }
        
        return day;
    }
    
    // 할인 날짜에 적합한지 확인
    public static boolean check(int[] number){
        for(int i=0; i<number.length; i++){
            if(number[i] > sliding[i][0]){
                return false;
            } 
        }
        return true;
    }
}