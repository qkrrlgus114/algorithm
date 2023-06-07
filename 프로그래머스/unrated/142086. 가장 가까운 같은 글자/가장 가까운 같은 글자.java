import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] arr = new int[26]; // a는 97
        int[] result = new int[s.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
        for(int i=0; i<s.length(); i++){
            if(arr[(int)s.charAt(i)-97] == -1){
                result[i] = -1;
                arr[(int)s.charAt(i)-97] = i;
            }else{
                result[i] = i-arr[(int)s.charAt(i)-97];
                arr[(int)s.charAt(i)-97] = i;
            }
        }
        return result;
    }
}