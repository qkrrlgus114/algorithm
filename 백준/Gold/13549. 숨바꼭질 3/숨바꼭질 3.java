import org.w3c.dom.Node;

import java.awt.image.VolatileImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] result = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        bfs();

        System.out.println(result[K]);
    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K) break;
            if(cur * 2 <= 100000 && !visited[cur * 2]){
                visited[cur * 2] = true;
                result[cur * 2] = result[cur];
                q.add(cur * 2);
            }
            if(cur - 1 >= 0 && !visited[cur - 1]){
                visited[cur - 1] = true;
                result[cur - 1] = result[cur] + 1;
                q.add(cur - 1);
            }
            if(cur + 1 <= 100000 && !visited[cur + 1]){
                visited[cur + 1] = true;
                result[cur + 1] = result[cur] + 1;
                q.add(cur + 1);
            }
        }
    }
}