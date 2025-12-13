import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        // 정답
        int human = Integer.MAX_VALUE;
        int cnt = Integer.MAX_VALUE;

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int A = Integer.parseInt(sa[0]);
            int B = Integer.parseInt(sa[1]);

            list[A].add(B);
            list[B].add(A);
        }

        for (int i = 1; i < N + 1; i++) {
            // 해당 사람의 케빈 베이컨 수
            int[] result = new int[N + 1];
            Arrays.fill(result, Integer.MAX_VALUE);
            // 해당 사람의 방문 체크
            boolean[] visited = new boolean[N + 1];

            bfs(i, result, visited);

            // 해당 사람의 케빈 베이컨 수 합 계산
            int tempResult = 0;
            for (int j = 0; j < N + 1; j++) {
                if (result[j] == Integer.MAX_VALUE) continue;
                tempResult += result[j];
            }

            // 정답 갱신
            if (cnt > tempResult) {
                human = i;
                cnt = tempResult;
            }
        }

        System.out.println(human);
    }

    public static void bfs(int i, int[] result, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int num = temp[0];
            int cnt = temp[1];

            if (visited[num]) continue;
            visited[num] = true;
            if (i != num) {
                result[num] = Math.min(result[num], cnt);
            }

            for (int j = 0; j < list[num].size(); j++) {
                int next = list[num].get(j);
                q.add(new int[]{next, cnt + 1});
            }
        }
    }

}
