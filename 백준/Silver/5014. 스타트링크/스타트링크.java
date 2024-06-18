import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 최대 F층
    // 스타트링크 G층
    // 현재 S층
    // 위로 U층
    // 아래로 D층

    static boolean[] visited;
    static int F, G, S, U, D;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        F = Integer.parseInt(sa[0]);
        S = Integer.parseInt(sa[1]);
        G = Integer.parseInt(sa[2]);
        U = Integer.parseInt(sa[3]);
        D = Integer.parseInt(sa[4]);

        visited = new boolean[F+1];
        visited[S] = true;

        bfs(S);

        if(result == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }


    }

    private static void bfs(int depth){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{depth, 0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            depth = temp[0];
            int count = temp[1];

            if(depth == G){
                result = count;
                return;
            }

            if(depth + U <= F && !visited[depth + U]){
                visited[depth + U] = true;
                q.add(new int[]{depth + U, count + 1});
            }

            if(depth - D >= 1 && !visited[depth - D]){
                visited[depth - D] = true;
                q.add(new int[]{depth - D, count + 1});
            }
        }
    }
}

