import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        bfs();

        Stack<Integer> s = new Stack<>();
        s.push(M);
        int index = M;
        while(index != N){
            s.push(parent[index]);
            index = parent[index];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.size() - 1).append("\n");
        int size = s.size();
        for(int i=0; i<size; i++){
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb);

    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == M) break;

            if(cur - 1 >= 0 && !visited[cur - 1]){
                visited[cur - 1] = true;
                q.add(cur - 1);
                parent[cur - 1] = cur;
            }
            if(cur + 1 <= 100000 && !visited[cur + 1]){
                visited[cur + 1] = true;
                q.add(cur + 1);
                parent[cur + 1] = cur;
            }
            if(cur * 2 <= 100000 && !visited[cur * 2]){
                visited[cur * 2] = true;
                q.add(cur * 2);
                parent[cur * 2] = cur;
            }
        }

    }
}
