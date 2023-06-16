import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int count = 0; // 맞은 개수
        int zero = 0; // 0의 개수
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]!=0){
                for(int j=0; j<win_nums.length; j++){
                    if(lottos[i] == win_nums[j]) count++;
                }
            }else zero++;
        }
        int[] result = new int[2];
        if(count == 0 || count == 1){
            result[1] = 6;
            if(count == 0){
                if(zero <=1) result[0] = 6; 
                else result[0] = 7 - zero;
            }else{
                if(zero <=0) result[0] = 6; 
                else result[0] = result[1] - zero;
            }
        }else{
            result[1] = 7 - count;
            result[0] = result[1] - zero;
        }
        return result;
    }
}