import java.util.*;

class Solution {
  public int[] solution(long n) {
      String str = String.valueOf(n);
      int[] arr = new int[str.length()];
      int cnt = 0;
      for(int i=str.length()-1; i>=0; i--){
          if(i == str.length()-1) arr[cnt++] = Integer.parseInt(str.substring(i));
          else arr[cnt++] = Integer.parseInt(str.substring(i,i+1));
          System.out.println(Arrays.toString(arr));
      }
      
      return arr;
  }
}