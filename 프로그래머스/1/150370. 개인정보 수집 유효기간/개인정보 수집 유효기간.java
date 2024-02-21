// 월 + terms >= 12 면 년도는 그대로, 월만 더함
// 월 + terms < 12 면 여기서 (월 + terms) % 12만큼 년도 더하고, 나머지 월 더함.
// 년도, 월, 일 순으로 비교
import java.util.*;

class Solution {
    
    static int cur_year;
    static int cur_month;
    static int cur_day;
    static List<Integer> result = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] today_str = today.split("\\.");
        cur_year = Integer.parseInt(today_str[0]);
        cur_month = Integer.parseInt(today_str[1]);
        cur_day = Integer.parseInt(today_str[2]);
        
        Map<String, Integer> term = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            String[] temp = terms[i].split(" ");
            term.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] first_temp = privacies[i].split(" ");
            String[] second_temp = first_temp[0].split("\\.");
            
            // 현재 검사할 약관 파악
            int condition = term.get(first_temp[1]);
            // 현재 파악할 년, 월, 일
            int year = Integer.parseInt(second_temp[0]);
            int month = Integer.parseInt(second_temp[1]);
            int day = Integer.parseInt(second_temp[2]);
            if(month + condition <= 12){
                month += condition;
            }else{
                year += (month + condition - 1) / 12;
                month = (month + condition) % 12;
                if(month == 0) month = 12;
            }
            check_condition(i+1, year, month, day);
        }
        
        int[] result_a = new int[result.size()];
        for(int i=0; i<result_a.length; i++){
            result_a[i] = result.get(i);
        }
        
        return result_a;
    }
    
    public static void check_condition(int index, int year, int month, int day){
        if(cur_year > year){
            result.add(index);
            return;
        }else if(cur_year == year){
            if(cur_month > month){
                result.add(index);
                return;
            }else if(cur_month == month){
                if(cur_day >= day){
                    result.add(index);
                    return;
                }
            }
        }
    }
}