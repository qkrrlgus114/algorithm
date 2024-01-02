import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;
    static int K;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        visited = new boolean[100002];

        int bfs = bfs();
        System.out.println(bfs);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cur = temp[0];
            int count = temp[1];
            if(cur == K){
                return count;
            }
            if (!visited[cur]) {
                visited[cur] = true;
                if (cur + 1 <= 100000) {
                    q.add(new int[]{cur + 1, count + 1});
                }
                if (cur - 1 >= 0) {
                    q.add(new int[]{cur - 1, count + 1});
                }
                if (cur * 2 <= 100000) {
                    q.add(new int[]{cur * 2, count + 1});
                }
            }
        }
        return 0;
    }
}