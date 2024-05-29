import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] remote = new boolean[10];
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        Arrays.fill(remote, true);

        if (M != 0) {
            String[] sa = bf.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                remote[Integer.parseInt(sa[i])] = false;
            }
        }
        if (N == 100) {
            answer = 0;
        } else {
            // + 또는 - 버튼만으로 이동하는 경우의 수
            answer = Math.abs(N - 100);
            dfs(0);
        }

        System.out.println(answer);


    }

    private static void dfs(int count) {
        for (int i = 0; i < 10; i++) {
            if (!remote[i]) continue;

            sb.append(i);
            int value = Integer.parseInt(sb.toString());
            answer = Math.min(answer, sb.length() + Math.abs(value - N));

            if (count < 6) {
                dfs(count + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}


