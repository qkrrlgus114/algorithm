import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] arr = new int[N+1][M+1];


        // 입력
        for(int i=1; i<=N; i++){
            sa = bf.readLine().split(" ");
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
            }
        }

        // 누적합 구하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }

        String s = bf.readLine();
        int Q = Integer.parseInt(s);
        StringBuilder sb = new StringBuilder();

        for(int q=0; q<Q; q++){
            sa = bf.readLine().split(" ");

            int i = Integer.parseInt(sa[0]);
            int j = Integer.parseInt(sa[1]);
            int x = Integer.parseInt(sa[2]);
            int y = Integer.parseInt(sa[3]);

            int value = arr[x][y] - arr[i-1][y] - arr[x][j-1] + arr[i-1][j-1];
            sb.append(value).append("\n");

        }

        System.out.println(sb);

    }
}

