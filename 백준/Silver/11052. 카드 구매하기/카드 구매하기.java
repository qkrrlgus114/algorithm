import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        String[] sa = bf.readLine().split(" ");
        int[] cardPrice = new int[N+1];
        int[] memo = new int[N+1];

        for(int i=1; i<=N; i++){
            cardPrice[i] = Integer.parseInt(sa[i-1]);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                memo[i] = Math.max(memo[i], memo[i-j] + cardPrice[j]);
            }
        }

        System.out.println(memo[N]);

    }


}


