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

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[][][] arr = new int[N+1][N+1][11];
        // 입력 받기
        for(int i=1; i<=N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(sa[j-1]);
                for(int k=1; k<=10; k++){
                    arr[i][j][k] = arr[i-1][j][k] + arr[i][j-1][k] - arr[i-1][j-1][k];
                }
                arr[i][j][num]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        s = bf.readLine();
        int Q = Integer.parseInt(s);
        for(int q=0; q<Q; q++){
            String[] sa = bf.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);

            int[] temp = new int[11];
            for(int i=1; i<=10; i++){
                temp[i] = arr[x2][y2][i];
            }

            for(int i=1; i<=10; i++){
                temp[i] = temp[i] - arr[x2][y1-1][i] - arr[x1-1][y2][i] + arr[x1-1][y1-1][i];
            }

            int count = 0;
            for(int i=1; i<=10; i++){
                if(temp[i] > 0) count++;
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
}

