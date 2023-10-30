import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 자신의 친구와 친구의 친구만 초대함.
 * 1번부터 시작. 방문체크 해주고
 * 1번이 가지고 있는 애들만 돌아야함.
 */

public class Main {

    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        graph = new LinkedList[N + 1];
        visited = new boolean[N + 1];

        for(int i=0; i<=N; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<M; i++){
            String[] str = bf.readLine().split(" ");
            int temp1 = Integer.parseInt(str[0]);
            int temp2 = Integer.parseInt(str[1]);

            graph[temp1].add(temp2);
            graph[temp2].add(temp1);
        }

        bfs(1);
        System.out.println(result);
    }

    public static void bfs(int start){
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, count});

        visited[start] = true;

        while(q.size() != 0){
            int[] temp = q.poll();
            int friend = temp[0];
            int friend_cnt = temp[1];
            if (friend_cnt <= 2){
                for(int i=0; i<graph[friend].size(); i++){
                    int w = graph[friend].get(i);
                    if (!visited[w]){
                        visited[w] = true;
                        q.add(new int[]{w, friend_cnt + 1});
                        result ++;
                    }
                }
            }
        }
    }
}