import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long fac = 1l;
        for(int i=1; i<=n; i++){
            fac *= i;
            list.add(i);
        }
        
        // k는 0부터 시작하기때문에
        k--;
        
        // 다 뽑을때까지 돌림
        int index = 0;
        while(n > 0){
            // 자리에서 가능한 경우의 수 뽑음
            fac /= n;
            int value = (int) (k/fac);
            answer[index++] = list.get(value);
            list.remove(value);
            
            k %= fac;
            n--;
        }
        
        return answer;

    }
}