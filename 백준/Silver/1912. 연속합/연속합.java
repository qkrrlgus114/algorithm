import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);
        arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        dp = new int[N];
        for(int i=0; i<N; i++){
            if(i == 0){
                dp[i] = arr[i];
            }else if(dp[i-1] < 0 && dp[i-1] < arr[i]){
                dp[i] = arr[i];
            }else{
                dp[i] = dp[i - 1] + arr[i];
            }
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }

}