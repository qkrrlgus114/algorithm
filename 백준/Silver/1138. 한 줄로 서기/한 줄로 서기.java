import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] init = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int index = 1;

            while (true) {
                if (init[i] == 0 && result[index] == 0) {
                    result[index] = i;
                    break;
                } else if (result[index] == 0) {
                    init[i]--;
                }
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}