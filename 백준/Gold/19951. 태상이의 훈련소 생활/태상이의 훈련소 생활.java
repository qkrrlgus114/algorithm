import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[] ground;
    static int[] sums;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        ground = new int[N + 1];
        sums = new int[N + 2];
        sa = bf.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            ground[i] = Integer.parseInt(sa[i - 1]);
        }

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int H = Integer.parseInt(sa[2]);

            sums[start] += H;
            sums[end + 1] += -H;
        }

        int value = 0;
        for (int i = 1; i <= N; i++) {
            value += sums[i];
            ground[i] += value;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(ground[i]).append(" ");
        }

        System.out.println(sb);

    }
}
