import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static int R;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] result;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        graph = new List[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }



        for(int i=0; i<M; i++){
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1; i<graph.length; i++){
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        bfs();

        for(int i=1; i<result.length; i++){
            System.out.println(result[i]);
        }


    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        visited[R] = true;
        result[R] = count++;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = count++;
                    q.add(next);
                }
            }
        }
    }
}