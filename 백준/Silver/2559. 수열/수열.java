import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] arr = new int[N+1];
        sa = bf.readLine().split(" ");
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        int[] pSum = new int[N+1];
        for(int i=1; i<N+1; i++){
            pSum[i] = pSum[i-1] + arr[i];
        }

        int answer = Integer.MIN_VALUE;
        for(int i=K; i<N+1; i++){
            int value = pSum[i] - pSum[i-K];
            if(value > answer) answer = value;
        }

        System.out.println(answer);
    }

}

