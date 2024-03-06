import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M, T;
    static int K, a, b;
    static char[][] graph;
    static char[][] copy;
    // 12시부터 시계 방향
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        T = Integer.parseInt(sa[2]);

        sa = bf.readLine().split(" ");
        K = Integer.parseInt(sa[0]);
        a = Integer.parseInt(sa[1]);
        b = Integer.parseInt(sa[2]);

        graph = new char[N][M];
        copy = new char[N][M];
        for(char[] c : copy) Arrays.fill(c, '.');

        for(int i=0; i<N; i++){
            char[] charArray = bf.readLine().toCharArray();
            for(int j=0; j<M; j++){
                graph[i][j] = charArray[j];
            }
        }

        while(T != 0){
            T--;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    // 주위 생명의 개수 구함
                    int value = search(i, j);
                    // 현재 생명이 있으면
                    if(graph[i][j] == '*'){
                        if(a <= value && b >= value) copy[i][j] = '*';
                        else if(value < a || value > b) copy[i][j] = '.';
                    }
                    // 현재 생명이 없으면
                    else{
                        if(value > a && b >= value) copy[i][j] = '*';
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    graph[i][j] = copy[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static int search(int y, int x){
        // 주위 생명의 개수
        int count = 0;

        for(int i=0; i<8; i++){
            int ndy = y + dy[i];
            int ndx = x + dx[i];
            for(int j=0; j<K; j++){
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) break;
                ndy += j;
                ndx += j;
                if(graph[ndy][ndx] == '*') count++;
            }
        }

        return count;
    }
}
