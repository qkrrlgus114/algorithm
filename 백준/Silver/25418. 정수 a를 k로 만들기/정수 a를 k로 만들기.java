import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] answer = new int[1000001];
    static int A, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        A = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        bfs(A);

        System.out.println(answer[K]);
    }

    public static void bfs(int value) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{value, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int tempValue = temp[0];
            int cnt = temp[1];
            if (tempValue == K) break;

            if (tempValue + 1 <= K && answer[tempValue + 1] == 0) {
                answer[tempValue + 1] = cnt + 1;
                q.add(new int[]{tempValue + 1, cnt + 1});
            }

            if (tempValue * 2 <= K && answer[tempValue * 2] == 0) {
                answer[tempValue * 2] = cnt + 1;
                q.add(new int[]{tempValue * 2, cnt + 1});
            }

        }
    }
}