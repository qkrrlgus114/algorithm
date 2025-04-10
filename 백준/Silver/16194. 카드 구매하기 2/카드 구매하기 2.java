import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] p = new int[1001];
        int[] D = new int[10001];
        String[] sa = bf.readLine().split(" ");
        for (int i = 1; i <= N; i++)
            p[i] = Integer.parseInt(sa[i - 1]);

        for (int i = 1; i <= N; i++) {
            D[i] = p[i];
            for (int j = 1; j <= i; j++) {
                D[i] = Math.min(D[i], D[i - j] + p[j]);
            }
        }

        System.out.println(D[N]);
    }

}

