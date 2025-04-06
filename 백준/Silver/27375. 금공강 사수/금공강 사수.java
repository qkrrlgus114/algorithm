import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static int N, K, answer;
    static List<Node> nodeList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            nodeList.add(new Node(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
        }

        nodeList.sort(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (o1.d == o2.d) {
                    if (o1.s == o2.s) {
                        return o1.e - o2.e;
                    }
                    return o1.s - o2.s;
                }
                return o1.d - o2.d;
            }
        });

        dfs(0, 0);

        System.out.println(answer);

    }

    public static void dfs(int sum, int depth) {
        // 종료 조건
        if (sum >= K || depth >= N) {
            if (sum == K) {
                answer++;
            } else {
                return;
            }
        }

        // 재귀 조건
        for (int i = depth; i < N; i++) {
            Node node = nodeList.get(i);
            // 금요일은 공강으로 건너뛴다.
            if (node.d == 5) continue;

            if (depth != 0 && node.d == nodeList.get(depth - 1).d && node.s <= nodeList.get(depth - 1).e && visited[depth - 1]) {
                continue;
            }
            visited[i] = true;
            dfs(sum + (node.e - node.s + 1), i + 1);
            visited[i] = false;
        }
    }

}

class Node {
    int d;
    int s;
    int e;

    public Node(int d, int s, int e) {
        this.d = d;
        this.s = s;
        this.e = e;
    }
}