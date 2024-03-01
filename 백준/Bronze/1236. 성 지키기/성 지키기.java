import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        // 행 카운트
        int row_count = 0;
        // 열 카운트
        int col_count = 0;

        char[][] graph = new char[N][M];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = input.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            boolean check = false;
            for(int j=0; j<M; j++){
                if(graph[i][j] == 'X'){
                    check = true;
                    break;
                }
            }
            if(!check) row_count++;
        }

        for(int j=0; j<M; j++){
            boolean check = false;
            for(int i=0; i<N; i++){
                if(graph[i][j] == 'X'){
                    check = true;
                    break;
                }
            }
            if(!check) col_count++;
        }

        System.out.println(Math.max(col_count, row_count));


    }


}
