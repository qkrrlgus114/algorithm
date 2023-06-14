import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        // k=최상, 1점 최하
        int result = 0; // 전체 사과 박스의 가격
        int boxCount = score.length/m;
        Arrays.sort(score);
        if(score.length-m > 0){
            for(int i=score.length-m; i>=0; i-=m){
                result += score[i] * m;
            }
        }
        return result;
    }
}