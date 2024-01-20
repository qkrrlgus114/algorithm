import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N;
    static int[][] arr;
    static int[] memo;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);
        arr = new int[N][2];
        memo = new int[N];
        Arrays.fill(memo, -1);
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
        }

        int dp = dp(0);
        System.out.println(dp);

    }

    public static int dp(int i){
        if(i >= N){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        int take = 0;
        if(i + arr[i][0] <= N){
            take = dp(i + arr[i][0]) + arr[i][1];
        }
        int non_take = dp(i + 1);

        return Math.max(take, non_take);
    }


}