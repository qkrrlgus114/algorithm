import java.util.*;

class Solution
{
    public int solution(int []A, int []B){
        
        // A 정방향 정렬
        Arrays.sort(A);
        
        // B 역방향 정렬
        Arrays.sort(B);
        int[] n_B = new int[B.length];
        int index = 0;
        for(int i=B.length - 1; i >= 0; i--){
            n_B[index++] = B[i];
        }
        
        int result = 0;
        
        for(int i=0; i<A.length; i++){
            result += A[i] * n_B[i];
        }
        
        return result;
    }
}