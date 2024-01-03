import java.awt.image.VolatileImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        // 리스트 초기화
        graph = new List[101];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 사다리, 뱀 값 입력
        for (int i = 0; i < N + M; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            // 단방향
            graph[start].add(end);
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cur = temp[0];
            int count = temp[1];

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                // 만약에 100이면 리턴
                if (next == 100) {
                    return count + 1;
                }
                // 아직 방문하지 않았고, 100을 초과하지 않으면
                if (!visited[next] && next < 100) {
                    // 리스트가 비어있지 않으면(즉 사다리나 뱀이 있다면)
                    if (!graph[next].isEmpty()) {
                        int go = graph[next].get(0);
                        if (!visited[go]) {
                            visited[go] = true;
                            q.add(new int[]{go, count + 1});
                        }
                    } else {
                        visited[next] = true;
                        q.add(new int[]{next, count + 1});
                    }
                }
            }
        }

        return 0;
    }
}