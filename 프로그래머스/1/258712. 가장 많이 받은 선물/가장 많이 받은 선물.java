import java.util.*;

class Solution {
    
    static Map<String, Integer> result;
    
    public int solution(String[] friends, String[] gifts) {
        // 최종 받을 선물의 개수 리스트
        result = new HashMap<>();
        
        Map<String, String[][]> map = new HashMap<>();
        
        // 선물 기록 저장
        for(int i=0; i<gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            String[][] target = map.get(temp[0]);
            if(target == null){
                target = new String[friends.length][2];
                target[0][0] = temp[1];
                target[0][1] = "1";
            }else{
                boolean check = false;
                int null_idx = 0;
                for(int j=0; j<target.length; j++){
                    if(target[j][0] == null){
                        null_idx = j;
                        break;
                    }else if(target[j][0].equals(temp[1])){
                        int pre_count = Integer.parseInt(target[j][1]);
                        target[j][1] = String.valueOf(pre_count + 1);
                        check = true;
                        break;
                    }
                }
                if(!check){
                    target[null_idx][0] = temp[1];
                    target[null_idx][1] = "1";
                }
            }
            map.put(temp[0], target);
        }
        
        // 준 선물, 받은 선물 리스트
        Map<String, Integer> pre_list = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            String name = friends[i];
            pre_list.put(name, 0);
        }
        
        for(int i=0; i<friends.length; i++){
            String name = friends[i];
            String[][] temp = map.get(name);
            if(temp == null) continue;
            else{
                for(int j=0; j<temp.length; j++){
                    if(temp[j][0] != null){
                        String target = temp[j][0];
                        int pre_count = Integer.parseInt(temp[j][1]);
                        int temp_count = pre_list.get(target);
                        pre_list.put(target, temp_count - pre_count);
                        temp_count = pre_list.get(name);
                        pre_list.put(name, temp_count + pre_count);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(map.get("ryan")));
        
        // 이제 서로 선물을 받았는지 확인.
        for(int i=0; i<friends.length; i++){
            String name = friends[i];
            for(int j=i+1; j<friends.length; j++){
                // name이 보낸 횟수
                int pre_count = 0;
                // target이 보낸 횟수
                int pred_count = 0;
                String target = friends[j];
                if(name.equals(target)) continue;
                String[][] list = map.get(name);
                if(list != null){
                    for(int k=0; k<list.length; k++){
                        if(list[k][0] != null && list[k][0].equals(target)){
                            pre_count = Integer.parseInt(list[k][1]);
                            break;
                        }
                    }
                }
                list = map.get(target);
                if(list != null){
                    for(int k=0; k<list.length; k++){
                        if(list[k][0] != null && list[k][0].equals(name)){
                            pred_count = Integer.parseInt(list[k][1]);
                            break;
                        }
                    }
                }
                // name이 더 크다면
                if(pre_count > pred_count){
                    change(name);
                }
                // target이 더 크다면
                else if(pre_count < pred_count){
                    change(target);
                }
                // 같다면
                else{
                    // name의 선물지수
                    int name_point = pre_list.get(name);
                    // target의 선물지수
                    int target_point = pre_list.get(target);
                    if(name_point > target_point){
                        change(name);
                    }else if(name_point < target_point){
                        change(target);
                    }
                }
            }
        }
        
        // 결과중에 제일 큰 수 출력
        int max = 0;
        for(int i=0; i<friends.length; i++){
            if(result.get(friends[i]) != null){
                int temp = result.get(friends[i]);
                if(max < temp) max = temp;
            }
        }
        
        return max;
    }
    
    public static void change(String name){
        Integer count = result.get(name);
        if(count == null){
            result.put(name, 1);
        }else{
            result.put(name, count + 1);
        }
    }
}