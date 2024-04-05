import java.util.*;
class Solution {
    

    public int[] solution(String msg) {
        int index = 0;
        // 사전 초기화 진행
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            char a = (char)(i + 'A');
            map.put(String.valueOf(a), i+1);
            index = i+1;
        }
        List<Integer> list = new ArrayList<>();
    

        StringBuilder temp = new StringBuilder();
        int pre_value = 0;
        boolean check = false;
        for(int i=0; i<msg.length(); i++){
            temp.append(msg.charAt(i));
            if(map.containsKey(temp.toString())){
                    pre_value = map.get(temp.toString());
            }else{
                map.put(temp.toString(), ++index);
                list.add(pre_value);
                temp.setLength(0);
                i--;
            }
            
            if(i == msg.length() - 1){
                list.add(pre_value);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}