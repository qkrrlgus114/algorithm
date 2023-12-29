import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static List<Integer>[] graph;
    static boolean[] check;
    // 정답 개수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        graph = new List[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        check = new boolean[N+1];

        for(int i=0; i<M; i++){
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1; i<N+1; i++){
            if(!check[i]){
                count++;
                bfs(i);
            }
        }

        System.out.println(count);
    }

    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        check[i] = true;

        while(q.size() != 0){
            int x = q.poll();
            for(int j=0; j<graph[x].size(); j++){
                int temp = graph[x].get(j);
                if(!check[temp]){
                    q.add(temp);
                    check[temp] = true;
                }
            }
        }
    }
}