import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        char[][] graph = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            graph[i] = s.toCharArray();
        }

        int colCount = 0;
        int rowCount = 0;

        for (int i = 0; i < N; i++) {
            boolean check = true;
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 'X'){
                    check = false;
                    break;
                }
            }
            if(check) colCount++;
        }

        for (int i = 0; i < M; i++) {
            boolean check = true;
            for (int j = 0; j < N; j++) {
                if(graph[j][i] == 'X'){
                    check = false;
                    break;
                }
            }
            if(check) rowCount++;
        }
        System.out.println(Math.max(rowCount, colCount));
    }
}