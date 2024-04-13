import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        Integer[] arr = new Integer[numbers.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = numbers[i];
        }
        
        Arrays.sort(arr, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                String a = String.valueOf(o1) + String.valueOf(o2);
                String b = String.valueOf(o2) + String.valueOf(o1);
                
                return b.compareTo(a);
            }
        });
        
        if(arr[0] == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}