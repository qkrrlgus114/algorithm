import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[] arr;
    static int[] stepCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        String[] sa = bf.readLine().split(" ");
        arr = new int[N + 1];
        stepCounts = new int[N + 1];
        Arrays.fill(stepCounts, -1);

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(sa[i - 1]);
        }

        bfs();

        System.out.println(stepCounts[N]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        stepCounts[1] = 0;

        while (!q.isEmpty()) {
            int step = q.poll();
            int stepCount = stepCounts[step];
            int cur = arr[step];

            for (int i = step + 1; i <= cur + step; i++) {
                if(i > N) continue;
                if(stepCounts[i] != -1) continue;
                stepCounts[i] = stepCount + 1;
                q.add(i);
            }
        }
    }
}
