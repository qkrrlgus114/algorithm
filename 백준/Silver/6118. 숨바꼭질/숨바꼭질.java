import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static Map<Integer, Integer> map = new HashMap<>();
    static int N, M;
    static List<Integer>[] list;
    static int count = 0;
    static int distance = 0;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        list = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            list[start].add(end);
            list[end].add(start);
        }


        bfs();

        System.out.println(answer + " " + distance + " " + count);

    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cur = temp[0];
            int step = temp[1];

            if(step > distance){
                distance = step;
                count = 1;
                answer = cur;
            }else if(step == distance){
                if(answer > cur) answer = cur;
                count++;
            }

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                if(visited[next]) continue;

                visited[next] = true;
                q.add(new int[]{next, step + 1});
            }
        }
    }
}