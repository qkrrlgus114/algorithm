import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        long[] memo = new long[N+1];
        memo[1] = 1;

        for(int i=2; i<=N; i++){
            memo[i] = memo[i-2] + memo[i-1];
        }

        System.out.println(memo[N]);


    }

}


