import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 0);
        
        // 현재 말하는 사람의 번호
        int index = 2;
        // 현재 돌은 횟수
        int around = 1;
        for(int i=1; i<words.length; i++){
            if(index == n + 1){
                index = 1;
                around++;
            }
            // 한 글자인지 파악
            // 앞 사람의 마지막 단어와 시작 첫 단어가 일치하는지 파악
            // 중복 단어인지 파악
            if(words[i].length() == 1
              || words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)
              || map.get(words[i]) != null){
                answer[0] = index;
                answer[1] = around;
                break;
            }
            
            map.put(words[i], 0);
            index++;
        }

        return answer;
    }
}