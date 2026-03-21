import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int answer = Integer.MIN_VALUE;

        int[] tress = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            tress[i] = Integer.parseInt(sa[i]);
        }

        int s = 0;
        int e = 2000000000;
        while (s <= e) {
            int m = (s + e) / 2;

            long cutTrees = 0;
            for (int i = 0; i < tress.length; i++) {
                if (tress[i] <= m) continue;
                cutTrees += tress[i] - m;
            }

            if (cutTrees >= M) {
                answer = Math.max(answer, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(answer);
    }


}