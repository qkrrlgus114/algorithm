import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int[] memo = new int[46];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        memo[1] = 1;
        memo[2] = 1;

        System.out.println(fibo(N));
    }

    public static int fibo(int n){
        if(memo[n] != 0) return memo[n];

        return memo[n] = fibo(n-1) + fibo(n-2);
    }
}