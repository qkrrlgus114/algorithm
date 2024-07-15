import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    static int[] tree;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        tree = new int[N + 1];
        list = new List[N + 1];
        visited = new boolean[N + 1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(tree[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index){
        visited[index] = true;
        for(int cur : list[index]){
            if(visited[cur]) continue;
            visited[cur] = true;
            tree[cur] = index;
            dfs(cur);
        }
    }
}