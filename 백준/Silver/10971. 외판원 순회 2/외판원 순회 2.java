import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int min_value = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        graph = new List[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<sa.length; j++){
                graph[i].add(Integer.parseInt(sa[j]));
            }
        }

        for(int i = 1; i <= N; i++){
            dfs(0, 0, i, i);
        }

        System.out.println(min_value);
    }

    // 몇 개 돌았는지, 총 합, 시작 도시, 현재 도시
    public static void dfs(int count, int sum, int start, int cur){
        // 종료 조건
        if(count == N && start == cur){
            min_value = Math.min(sum, min_value);
            return;
        }

        // 현재 도시에서 다음 도시까지의 비용 리스트
        List<Integer> list = graph[cur];
        for(int i=0; i<list.size(); i++){
            if(visited[i+1] || list.get(i) == 0) continue;
            int temp = list.get(i);
            visited[i+1] = true;
            dfs(count + 1, sum + temp, start, i+1);
            visited[i+1] = false;
        }
    }
}