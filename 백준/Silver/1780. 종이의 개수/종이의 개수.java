import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static int r1, r2, r3 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);
        graph = new int[N][N];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }


    public static void partition(int y, int x, int size){
        if(check(y, x, size)){
            if(graph[y][x] == -1) r1++;
            else if(graph[y][x] == 0) r2++;
            else r3++;

            return;
        }

        size = size / 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                partition(y + (i * size), x + (j * size), size);
            }
        }
    }

    public static boolean check(int y, int x, int size){
        int init = graph[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(init != graph[i][j]) return false;
            }
        }

        return true;
    }

}



