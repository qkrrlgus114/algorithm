import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class Main {
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        result = new int[M];
//        visited = new boolean[N];

        s = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        back( 0);
        System.out.print(sb.toString());
    }

    public static void back(int count) {
        if (count == M) {
            for (Integer i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        // 과거의 값
        int past = -1;

        for (int i = 0; i < N; i++) {
            if (past != arr[i]) {
                past = arr[i];
                result[count] = arr[i];
                back(count + 1);
//                visited[i] = false;
            }
        }
    }
}