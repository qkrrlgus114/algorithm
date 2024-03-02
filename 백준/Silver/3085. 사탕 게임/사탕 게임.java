import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static char[][] graph;
    static char[][] ori_graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        graph = new char[N][N];
        ori_graph = new char[N][N];


        for(int i=0; i<N; i++){
            s = bf.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = s.charAt(j);
                ori_graph[i][j] = graph[i][j];
            }
        }


        // 가로 위치가 다르면 사탕 바꿈
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(graph[i][j] != graph[i][j+1]) changeCnady(i, j, i, j+1, graph);
                backUp(ori_graph);
            }
        }

        // 세로 위치가 다르면 사탕 바꿈
        // 가로 위치가 다르면 사탕 바꿈
        for(int j=0; j<N; j++){
            for(int i=0; i<N-1; i++){
                if(graph[i][j] != graph[i+1][j]) changeCnady(i, j, i+1, j, graph);
                backUp(ori_graph);
            }
        }

        if(max == Integer.MIN_VALUE) System.out.println(N);
        else System.out.println(max);

    }

    // 바꾸고 계산하는 메서드
    public static void changeCnady(int y1, int x1, int y2, int x2, char[][] graph){
        // 서로 자리를 바꿈
        char temp = graph[y1][x1];
        graph[y1][x1] = graph[y2][x2];
        graph[y2][x2] = temp;

        // 가로 확인
        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=0; j<N-1; j++){
                if(graph[i][j] == graph[i][j+1]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        // 세로 확인
        for(int j=0; j<N; j++){
            int count = 1;
            for(int i=0; i<N-1; i++){
                if(graph[i][j] == graph[i+1][j]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
    }

    public static void backUp(char[][] back){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = back[i][j];
            }
        }
    }

}
