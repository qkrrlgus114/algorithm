import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String> command = new ArrayList<>();
        Map<String, String> uid = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] splits = record[i].split(" ");
            if("Enter".equals(splits[0])){
                command.add(splits[1] + ",님이 들어왔습니다.");
                uid.put(splits[1], splits[2]);
            }else if("Leave".equals(splits[0])){
                command.add(splits[1] + ",님이 나갔습니다.");
            }else if("Change".equals(splits[0])){
                uid.put(splits[1], splits[2]);
            }
        }
        
        String[] answer = new String[command.size()];
        int index = 0;
        
        for(int i=0; i<command.size(); i++){
            String[] oriCommand = command.get(i).split(",");
            String name = uid.get(oriCommand[0]);
            
            answer[index++] = name + oriCommand[1];
        }

        return answer;
    }
}