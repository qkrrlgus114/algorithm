import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static boolean[] A;
    static int answer = Integer.MAX_VALUE;
    static int[] humans;
    static List<Integer>[] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new boolean[N];
        humans = new int[N];
        ground = new List[N];

        // 인구수
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            humans[i] = Integer.parseInt(sa[i]);
            ground[i] = new ArrayList<>();
        }

        // 구역 연결 계산
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            int size = Integer.parseInt(sa[0]);
            for (int j = 1; j <= size; j++) {
                ground[i].add(Integer.parseInt(sa[j]) - 1);
            }
        }

        // 구역을 나눌 수 있는 모든 경우의 수를 구해야함.(dfs)
        for (int i = 1; i < N; i++) {
            combination(0, 0, i);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 조합(시작, 깊이, 사이즈)
    public static void combination(int start, int depth, int size) {
        // 목표 도달
        if (size == depth) {
            // 2개의 선거구 연결 확인
            if (!bfs(true) || !bfs(false)) {
                return;
            }

            calculation();

            return;
        }

        for (int i = start; i < N; i++) {
            A[i] = true;
            combination(i + 1, depth + 1, size);
            A[i] = false;
        }
    }

    // 선거구 연결 확인(true = A, false = B)
    public static boolean bfs(boolean status) {
        int cnt = 1; // 총 선거구의 개수
        int totalCnt = 0;
        int idx = -1;
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (A[i] == status) {
                totalCnt++;
                if (idx == -1) idx = i;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int next : ground[poll]) {
                if (A[next] != status) continue;
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
                cnt++;
            }
        }

        return cnt == totalCnt;
    }

    public static void calculation() {
        int aValue = 0;
        int bValue = 0;

        for (int i = 0; i < N; i++) {
            if (A[i]) {
                aValue += humans[i];
            } else {
                bValue += humans[i];
            }
        }

        int abs = Math.abs(aValue - bValue);

        answer = Math.min(answer, abs);
    }

}