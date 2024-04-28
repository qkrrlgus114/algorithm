import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i=1; i<N; i++){
            int leftSum = arr[i-1];
            int rightSum = arr[i];
            int l = i-1;
            int r = i;

            while(true){
                int temp = Math.abs(rightSum - leftSum);

                if(temp == minValue){
                    answer = Math.max(answer, leftSum + rightSum);
                }else if(minValue > temp){
                    minValue = temp;
                    answer = leftSum + rightSum;
                }

                if(leftSum > rightSum){
                    if(r == N-1) break;
                    r++;
                    rightSum += arr[r];
                }else if(leftSum < rightSum){
                    if(l == 0) break;
                    l--;
                    leftSum += arr[l];
                }else{
                    if(l == 0 || r == N-1) break;
                    r++;
                    l--;
                    rightSum += arr[r];
                    leftSum += arr[l];
                }
            }
        }

        System.out.println(answer);

    }
}

