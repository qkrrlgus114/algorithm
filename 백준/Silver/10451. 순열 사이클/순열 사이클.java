import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String w = bf.readLine();
        int T = Integer.parseInt(w);

        for(int t=0; t<T; t++){
            w = bf.readLine();
            N = Integer.parseInt(w);

            list = new List[N+1];
            visited = new boolean[N+1];
            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }
            String[] sa = bf.readLine().split(" ");
            for(int i=1; i<N+1; i++){
                list[i].add(Integer.parseInt(sa[i-1]));
            }

            int count = 0;
            for(int i=1; i<N+1; i++){
                if(!visited[i]){
                    count++;
                    visited[i] = true;
                    dfs(i);
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int depth){
        int next = list[depth].get(0);
        if(!visited[next]){
            visited[next] = true;
            dfs(next);
        }
    }
}

