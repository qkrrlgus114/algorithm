import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] memo = new int[N + 1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            String[] sa = bf.readLine().split(" ");
            T[i] = Integer.parseInt(sa[0]);
            P[i] = Integer.parseInt(sa[1]);
        }

        for (int i = 1; i <= N; i++) {
            memo[i] = Math.max(memo[i], memo[i-1]);
            if(i + T[i] - 1 > N) continue;
            memo[i + T[i] - 1] = Math.max(memo[i + T[i] - 1], memo[i - 1] + P[i]);
        }
        
        for(int i=1; i<=N; i++){
            result = Math.max(result, memo[i]);
        }

        System.out.println(result);


    }
}


