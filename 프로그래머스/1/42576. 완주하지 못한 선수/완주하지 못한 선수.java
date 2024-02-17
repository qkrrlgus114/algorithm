import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> runner = new HashMap<>();
        String result = "";
        for(int i=0; i<participant.length; i++){
            if(runner.containsKey(participant[i])){
                Integer temp = runner.get(participant[i]);
                runner.replace(participant[i], temp + 1);
            }else{
                runner.put(participant[i], 1);
            }
        }
        
        
        for(int i=0; i<completion.length; i++){
            if(runner.get(completion[i]) > 1){
                runner.replace(completion[i], runner.get(completion[i]) - 1);
            }else{
                runner.remove(completion[i]);
            }
        }
        for(String key : runner.keySet()){
            result = key;
            break;
        }
        
        return result;
    }
}