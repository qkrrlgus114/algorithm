import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] sa = bf.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            for (int i = 0; i < M; i++) bf.readLine();

            sb.append(N - 1).append("\n");
        }

        System.out.print(sb);
    }
}