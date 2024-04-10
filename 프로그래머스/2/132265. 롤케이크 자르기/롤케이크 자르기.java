import java.util.*;

// 슬라이딩 윈도우 느낌?

class Solution {
    public int solution(int[] topping) {
        // 토핑을 골랐는지 안 골랐는지 체크
        int[] piece1 = new int[10001];
        int[] piece2 = new int[10001];
        // 토핑 종류의 개수
        int count1 = 0;
        int count2 = 0;
        // 정답
        int result = 0;
        
        // 왼쪽 조각
        piece1[topping[0]]++;
        count1++;
        // 오른쪽 조각 
        for(int i=1; i<topping.length; i++){
            piece2[topping[i]]++;
            if(piece2[topping[i]] == 1) count2++;
        }
        if(count1 == count2) result++;
        
        for(int i=1; i<topping.length; i++){
            piece1[topping[i]]++;
            if(piece1[topping[i]] == 1) count1++;
            piece2[topping[i]]--;
            if(piece2[topping[i]] == 0) count2--;
            if(count1 == count2) result++;
        }

        return result;
    }
}