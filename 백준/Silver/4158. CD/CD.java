import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int cnt = 0;
            String[] sa = bf.readLine().split(" ");

            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            if (N == 0 && M == 0) break;

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(bf.readLine());
                set.add(num);
            }

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(bf.readLine());
                if (set.contains(num)) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}