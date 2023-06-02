import java.util.*;
import java.util.ArrayList;

public class Solution {
    public List solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                result.add(arr[i]);
            }
        }
        return result;
    }
}