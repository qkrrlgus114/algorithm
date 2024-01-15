import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        int[][] tri = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < sa.length; j++) {
                tri[i][j] = Integer.parseInt(sa[j]);
            }
        }

        int[][] memo = new int[N][N];
        memo[0][0] = tri[0][0];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < 2; k++) {
                    if (memo[i + 1][j + k] < memo[i][j] + tri[i + 1][j + k])
                        memo[i + 1][j + k] = memo[i][j] + tri[i + 1][j + k];
                }
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            if(result < memo[N-1][i]) result = memo[N-1][i];
        }

        System.out.println(result);

    }
}