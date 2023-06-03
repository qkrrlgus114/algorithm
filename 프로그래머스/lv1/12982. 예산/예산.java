import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt = 0; // 지원할 부서 카운트
        for(int i=0; i<d.length; i++){
            if(budget - d[i] >= 0){
                budget -= d[i];
                cnt++;
            }
        }
        return cnt;
    }
}