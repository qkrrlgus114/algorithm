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
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] A = new int[N];
        int[] B = new int[M];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(sa[i]);
        }
        sa = bf.readLine().split(" ");
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(sa[i]);
        }

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;

        while(left < N || right < M){
            if(left >= N){
                sb.append(B[right++]).append(" ");
            }else if(right >= M){
                sb.append(A[left++]).append(" ");
            }else{
                if(A[left] >= B[right]){
                    sb.append(B[right++]).append(" ");
                }else{
                    sb.append(A[left++]).append(" ");
                }
            }
        }

        System.out.println(sb);

    }
}

