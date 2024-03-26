import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        memo = new int[N+1];

        for(int i=2; i<=N; i++){
            if(i % 6 == 0){
                memo[i] = Math.min(Math.min(memo[i/3], memo[i/2]), memo[i-1]) + 1;
            }
            else if(i % 3 == 0){
                memo[i] = Math.min(memo[i/3], memo[i-1]) + 1;
            }else if(i % 2 == 0){
                memo[i] = Math.min(memo[i/2], memo[i-1]) + 1;
            }else{
                memo[i] = memo[i-1] + 1;
            }
        }

        System.out.println(memo[N]);
    }
}

