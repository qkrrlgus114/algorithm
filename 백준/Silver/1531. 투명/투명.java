import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];

        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = 100 - Integer.parseInt(st.nextToken()) + 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = 100 - Integer.parseInt(st.nextToken()) + 1;

            for (int i = y2; i <= y1; i++) {
                for (int j = x1; j <= x2; j++) {
                    arr[i][j]++;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] > M) result++;
            }
        }

        System.out.println(result);
    }


}