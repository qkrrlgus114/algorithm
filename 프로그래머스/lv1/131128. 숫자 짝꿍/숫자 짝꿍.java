import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 카운트 배열 이용
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        char[] a = X.toCharArray();
        char[] b = Y.toCharArray();
        for(int i=0; i<a.length; i++){
            count1[(int)a[i]-'0']++;
        }
        for(int i=0; i<b.length; i++){
            count2[(int)b[i]-'0']++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count1.length; i++){
            if(count1[i] > 0 && count1[i] > 0){
                for(int j=0; j<Math.min(count1[i], count2[i]); j++){
                    list.add(i);
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            if(list.get(i)!=0) flag = false;
            sb.append(list.get(i));
        }
        if(list.size() == 0) return "-1";
        if(flag == true) return "0";
        return sb.toString();
    }
}