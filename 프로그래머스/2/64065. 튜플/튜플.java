import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] arr = new int[100001];
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                // 건너뛴 인덱스
                int count = 0;
                // 여기서 리스트에 담아야함.
                int num = 0;
                List<Integer> tempList = new ArrayList<>();
                for(int j=i+1; j<s.length(); j++){
                    count++;
                    if(s.charAt(j) == '}'){
                        tempList.add(num);
                        list.add(tempList);
                        i += count + 1;
                        break;
                    }else if(s.charAt(j) == ','){
                        tempList.add(num);
                        num = 0;
                        continue;
                    } 
                    else{
                        if(num == 0) num += s.charAt(j) - '0';
                        else{
                            num *= 10;
                            num += s.charAt(j) - '0';
                        }
                        
                    }
                }
            }
        }
        // 리스트 순서대로 정렬
        Collections.sort(list, new Comparator<List<Integer>>(){
            public int compare(List<Integer> o1, List<Integer> o2){
                return o1.size() - o2.size();
            }
        });
    
        
        int[] result = new int[list.get(list.size() - 1).size()];
        int index = 0;
        for(int i=0; i<list.size(); i++){
            List<Integer> temp = list.get(i);
            for(int j=0; j<temp.size(); j++){
                if(arr[temp.get(j)] == 0){
                    arr[temp.get(j)]++;
                    result[index++] = temp.get(j);
                    break;
                }
            }
        }
        
        
        return result;
    }
}