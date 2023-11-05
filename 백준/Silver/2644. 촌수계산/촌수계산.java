import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 촌수를 계산해야함.
 * 2개의 번호의 촌수 계산.
 * 양방향으로 넣어야 할 것 같음.
 * bfs로 풀면 되지 않을까?
 */

public class Main {

    static List<Integer>[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 전체 인원
        int N = Integer.parseInt(bf.readLine());

        // 구해야 하는 사람
        String[] s = bf.readLine().split(" ");
        int target_one = Integer.parseInt(s[0]);
        int target_two = Integer.parseInt(s[1]);

        // 관계의 수
        int M = Integer.parseInt(bf.readLine());
        arr = new List[N+1];
        for(int i=0; i<N+1; i++){
            arr[i] = new ArrayList<>();
        }

        // 리스트에 추가
        for(int i=0; i<M; i++){
            String[] s1 = bf.readLine().split(" ");

            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);

            arr[start].add(end);
            arr[end].add(start);
        }
        
        // 방문배열 초기화
        visited = new boolean[N+1];
        result = new int[N+1];

        bfs(target_one);

        if (result[target_two] != 0){
            System.out.println(result[target_two]);
        }else{
            System.out.println(-1);
        }

    }

    public static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, 0});
        visited[start] = true;

        while(q.size() != 0){
            int[] poll = q.poll();
            int cur = poll[0];
            int count = poll[1];
            for(int i=0; i<arr[cur].size(); i++){
                int temp = arr[cur].get(i);
                if (!visited[temp]){
                    result[temp] = count + 1;
                    q.add(new int[]{temp, count + 1});
                    visited[temp] = true;
                }
            }
        }
    }
}