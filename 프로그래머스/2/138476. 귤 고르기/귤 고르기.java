import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int max = 0;
        for(int i : tangerine){
            max = Math.max(max, i);
        }
        
        Integer[] arr = new Integer[max+1];
        Arrays.fill(arr, 0);
        for(int i : tangerine){
            arr[i]++;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        int result = 0;
        for(Integer i : arr){
            if(k - i > 0){
                result++;
                k -= i;
            }else{
                result++;
                break;
            }
        }
        return result;
    }
}