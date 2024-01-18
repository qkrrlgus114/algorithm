import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;
    static int[] visited;
    static int result = 0;
    static int fast = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        visited = new int[100001];

        for(int i=0; i<100001; i++){
            visited[i] = -1;
        }

        bfs(N);
        System.out.println(fast);
        System.out.println(result);
    }

    public static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = 0;
        boolean check = false;

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 여기에 들어오는 순간 빠른 경우가 됨.
            if (cur == K) {
                if(!check){
                    check = true;
                    fast = visited[cur];
                    result = 1;
                }else{
                    result++;
                }
                continue;
            }

            int[] next_step = {cur + 1, cur - 1, cur * 2};
            for(int next : next_step){
                if(next >= 0 && next < 100001){
                    if(visited[next] == -1 || visited[next] == visited[cur] + 1){
                        q.add(next);
                        visited[next] = visited[cur] + 1;
                    }
                }
            }
        }
    }

}