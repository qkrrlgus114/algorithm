import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] arr;
    static int[] result;
    //    static boolean[] visited;
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
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        back(0, 0);
        System.out.println(sb.toString());
    }

    public static void back(int depth, int count) {
        if (count == M) {
            for(Integer i : result){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = depth; i < N; i++) {
            result[count] = i + 1;
            back(i, count + 1);
        }
    }
}