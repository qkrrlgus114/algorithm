import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N, M;
    // 집의 좌표
    static List<Home> homes = new ArrayList<>();
    // 치킨집의 좌표
    static List<Chick> chicks = new ArrayList<>();
    // 치킨집을 선택했는지
    static boolean[] visited;
    // 해당 치킨집과 집의 거리
    static int[][] distance;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(sa[j]);
                if (value == 1) {
                    homes.add(new Home(i, j));
                } else if (value == 2) {
                    chicks.add(new Chick(i, j));
                }
            }
        }


        distance = new int[chicks.size()][homes.size()];
        for (int i = 0; i < chicks.size(); i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        visited = new boolean[chicks.size()];

        recur(0, 0);

        System.out.println(answer);

    }

    public static void recur(int choice, int index) {
        // 최소의 치킨거리 파악
        if (choice > 0) {
            calculation();
        }
        if (choice >= M) {
            return;
        }


        for (int i = index; i < chicks.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            // 치킨 거리 미리 계산해서 넣어놓기
            if (distance[i][0] == Integer.MAX_VALUE) {
                for (int j = 0; j < homes.size(); j++) {
                    distance[i][j] = Math.abs(chicks.get(i).y - homes.get(j).y) + Math.abs(chicks.get(i).x - homes.get(j).x);
                }
            }
            recur(choice + 1, i + 1);
            visited[i] = false;
        }
    }

    // 치킨 거리 파악
    public static void calculation() {
        int sum = 0;
        for (int i = 0; i < homes.size(); i++) {
            int value = Integer.MAX_VALUE;
            for (int j = 0; j < chicks.size(); j++) {
                if (!visited[j]) continue;
                value = Math.min(value, distance[j][i]);
            }
            if (value != Integer.MAX_VALUE) {
                sum += value;
            }
        }

        if (sum != 0) {
            answer = Math.min(answer, sum);
        }
    }
}

class Home {
    int y;
    int x;

    public Home(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Chick {
    int y;
    int x;

    public Chick(int y, int x) {
        this.y = y;
        this.x = x;
    }
}