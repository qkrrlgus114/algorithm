import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list 목록을 맵으로 저장
        Map<String, Integer> count = new HashMap<>();
        for(String s : id_list){
            count.put(s, 0);
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<report.length; i++){
            String[] temp = report[i].split(" ");
            List<String> arr = map.get(temp[1]);
            if(arr == null){
                List<String> list = new ArrayList<>();
                list.add(temp[0]);
                map.put(temp[1], list);
            }else{
                arr.add(temp[0]);
                map.put(temp[1], arr);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            List<String> temp = map.get(id_list[i]);
            List<String> new_temp = null;
            if(temp != null){
                Set<String> temp_set = new HashSet<String>(temp);
                new_temp = new ArrayList<String>(temp_set);
            }else continue;
            // k번 이상 신고됐으면
            if(temp != null && new_temp.size() >= k){
                for(int j=0; j<new_temp.size(); j++){
                    int report_count = count.get(new_temp.get(j));
                    count.put(new_temp.get(j), report_count + 1);
                }
            }
        }
        
        int[] result = new int[id_list.length];
        
        for(int i=0; i<count.size(); i++){
            result[i] = count.get(id_list[i]);
        }
        
        return result;
    }
}