import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] ori = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                ori[i+1][j+1] = Integer.parseInt(sa[j]);
            }
        }

        int[][] prefix = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j+1] + ori[i+1][j+1] - prefix[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);

            int sum = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}