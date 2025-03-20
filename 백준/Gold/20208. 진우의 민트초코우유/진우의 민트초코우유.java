import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M, H;
    static int milkCnt;
    static int answer;
    static int homeY, homeX;
    static List<Node> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        H = Integer.parseInt(sa[2]);

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(sa[j]) == 2) {
                    list.add(new Node(i, j));
                    milkCnt++;
                }
                if (Integer.parseInt(sa[j]) == 1) {
                    homeX = j;
                    homeY = i;
                }
            }
        }
        visited = new boolean[milkCnt];

        back(M, homeY, homeX, 0);

        System.out.println(answer);
    }

    public static void back(int health, int y, int x, int milk) {

        for (int i = 0; i < milkCnt; i++) {
            if (visited[i]) continue;
            Node node = list.get(i);
            // 이동하고 우유까지 먹음
            int afterHealth = health - (Math.abs(y - node.y) + Math.abs(x - node.x));
            // 그런데 체력이 0 미만이면
            if (afterHealth < 0) continue;
            afterHealth += H;
            visited[i] = true;
            // 집을 돌아갈 수 있다면?
            int homeHealth = afterHealth - (Math.abs(homeY - node.y) + Math.abs(homeX - node.x));
            if (homeHealth >= 0) {
                answer = Math.max(answer, milk + 1);
            }
            back(afterHealth, node.y, node.x, milk + 1);
            visited[i] = false;
        }
    }


}

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "y : " + y + ", x : " + x;
    }
}
