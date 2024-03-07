import java.util.*;

class Solution {
    static int result = 0;
    static Integer[] arr;
    
    public int solution(int[] people, int limit) {
        arr = new Integer[people.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = people[i];
        }
        Arrays.sort(arr);
        
        binarySearch(0, arr.length - 1, limit); 
        
        return result;
    }
    
    public static void binarySearch(int low, int high, int limit){
        if(low >= high){
            if(low == high) result++;
            return;
        } 
        
        int sum = arr[low] + arr[high];
        result++;
        if(sum > limit){
            binarySearch(low,high-1,limit);
        }else if(sum <= limit){
            binarySearch(low+1,high-1,limit);
        }
        
    }
}