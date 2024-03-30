import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        N = Integer.parseInt(s);
        graph  = new int[N][N];

        for(int i=0; i<N; i++){
            s = bf.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        partition(0, 0, N);
        System.out.println(sb);
    }

    public static void partition(int y, int x, int size){
        if(check(y, x, size)){
            sb.append(graph[y][x]);
            return;
        }

        sb.append("(");

        size = size / 2;

        partition(y, x, size);
        partition(y, x+size, size);
        partition(y+size, x, size);
        partition(y+size, x+size, size);

        sb.append(")");
    }

    // 확인
    public static boolean check(int y, int x, int size){
        int init = graph[y][x];

        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(graph[i][j] != init) return false;
            }
        }

        return true;
    }

}



