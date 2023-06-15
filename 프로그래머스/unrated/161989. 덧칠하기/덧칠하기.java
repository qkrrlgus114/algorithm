import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int temp = 0;
        for(int i=temp+1; i<section.length; i++){
            if(section[i]-section[temp] < m){ // 범위 내에 색칠 가능함.
                if(i==section.length-1) break; 
            }else if(section[i]-section[temp] >= m){ // 범위 내에 색칠이 불가능함.
                count++;
                temp = i;
            }
        }
        return count;
    }
}