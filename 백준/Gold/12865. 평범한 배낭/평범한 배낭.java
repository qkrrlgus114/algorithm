import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] memo;
    static int[][] item;
    static int K;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        memo = new int[K + 1][N + 1];
        item = new int[N + 1][2];

        for(int i=1; i<=N; i++){
            sa = bf.readLine().split(" ");
            item[i][0] = Integer.parseInt(sa[0]);
            item[i][1] = Integer.parseInt(sa[1]);
        }

        for(int i=0; i<=K; i++){
            for(int j=1; j<=N; j++){
                if(i - item[j][0] >= 0){
                    memo[i][j] = Math.max(memo[i - item[j][0]][j-1] + item[j][1], memo[i][j-1]);
                }else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }

        System.out.println(memo[K][N]);
    }
}