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
    static int k;
    static List<Integer>[] friends;
    static int[] price;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        k = Integer.parseInt(sa[2]);

        friends = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }
        price = new int[N + 1];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            price[i + 1] = Integer.parseInt(sa[i]);
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);

            if (s == e) continue;
            if (!friends[s].contains(e)) {
                friends[s].add(e);
            }
            if (!friends[e].contains(s)) {
                friends[e].add(s);
            }
        }


        int money = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            money += bfs(i);

        }

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                flag = false;
                break;
            }
        }

        if (flag && money <= k) {
            System.out.println(money);
        } else {
            System.out.println("Oh no");
        }
    }

    // 가장 저렴한 녀석을 찾으면 된다
    public static int bfs(int idx) {
        int money = Integer.MAX_VALUE;

        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        // 가격 갱신
        money = Math.min(money, price[idx]);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < friends[cur].size(); i++) {
                int next = friends[cur].get(i);

                if (visited[next]) continue;
                visited[next] = true;
                money = Math.min(money, price[next]);
                q.add(next);
            }
        }

        return money;
    }
}