import java.util.*;

class Solution {
    
    static int[] mbti_point = new int[8];
    static char[] match = new char[]{'R','T','C','F','J','M','A','N'};
    
    public String solution(String[] survey, int[] choices) {
        // 점수 저장 배열
        // 0 - R, 1 - T, 2 - C, 3 - F, 4 - J, 5 - M, 6 - A, 7 - N

        for(int i=0; i<survey.length; i++){
            int choice = choices[i];
            String temp = survey[i];
            if(choice == 4) continue;
            // 비동의 쪽이면
            else if(choice >= 1 && choice <= 3){
                checkPoint(choice, temp.charAt(0));
            }else if(choice >= 5 && choice <= 7){
                checkPoint(choice, temp.charAt(1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i+=2){
            if(mbti_point[i] > mbti_point[i+1]){
                sb.append(match[i]);
            }else if(mbti_point[i] < mbti_point[i+1]){
                sb.append(match[i+1]);
            }else{
                sb.append(match[i]);
            }
        }
        
        return sb.toString();
    }
    
    static void checkPoint(int target, char c){
        if(target == 5) target = 1;
        else if(target == 6) target = 2;
        else if(target == 7) target = 3;
        else if(target == 1) target = 3;
        else if(target == 2) target = 2;
        else if(target == 3) target = 1;
        if(c == 'R') mbti_point[0] += target;
        else if(c == 'T') mbti_point[1] += target;
        else if(c == 'C') mbti_point[2] += target;
        else if(c == 'F') mbti_point[3] += target;
        else if(c == 'J') mbti_point[4] += target;
        else if(c == 'M') mbti_point[5] += target;
        else if(c == 'A') mbti_point[6] += target;
        else if(c == 'N') mbti_point[7] += target;
    }
}