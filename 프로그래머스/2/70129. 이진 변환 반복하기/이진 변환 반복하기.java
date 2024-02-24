import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // 이진 변환의 총 횟수
        int count = 0;
        // 이진 변환에서 제거된 0의 개수
        int remove_zero_count = 0;
        
        while(true){
            // s가 1이면 종료
            if(s.equals("1")){
                answer[0] = count;
                answer[1] = remove_zero_count;
                break;
            }
            
            // 0을 전부 제거
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0') remove_zero_count++;
            }
            s = s.replaceAll("0", "");
            int length = s.length();
            
            s = binaryChange(length);
            count++;
        }
        
        return answer;
    }
    
    // 이진 변환 
    public static String binaryChange(int num){
        sb.setLength(0);
        while(true){
            if(num == 1){
                sb.append(1);
                break;
            }
            sb.append(num % 2);
            num /= 2;
        }
        sb.reverse();
        return sb.toString();
    }
}