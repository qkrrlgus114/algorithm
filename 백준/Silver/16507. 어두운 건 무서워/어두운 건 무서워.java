import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int Q = Integer.parseInt(sa[2]);

        int[][] arr = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            sa = bf.readLine().split(" ");
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
            }
        }

        // 누적합 생성
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            sa = bf.readLine().split(" ");
            int r1 = Integer.parseInt(sa[0]);
            int c1 = Integer.parseInt(sa[1]);
            int r2 = Integer.parseInt(sa[2]);
            int c2 = Integer.parseInt(sa[3]);

            int sum = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];
            int count = (c2 - c1 + 1) * (r2 - r1 + 1);
            sb.append(sum/count).append("\n");
        }

        System.out.println(sb);

    }
}

