import com.sun.source.doctree.SummaryTree;

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
        int[][] arr = new int[N][N];
        int[][] sum_arr = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
                sum_arr[i+1][j+1] = arr[i][j];
            }
        }

        // 누적합 배열 생셩

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                sum_arr[i][j] += sum_arr[i-1][j] - sum_arr[i-1][j-1] + sum_arr[i][j-1];
            }
        }

        for(int t=0; t<M; t++){
            sa = bf.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);
            int sum = sum_arr[x2][y2] - sum_arr[x2][y1-1] - sum_arr[x1-1][y2] + sum_arr[x1-1][y1-1];
            System.out.println(sum);
        }
    }

}