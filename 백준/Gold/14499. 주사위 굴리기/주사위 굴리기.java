import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int[][] graph;
    static int[] dice = new int[6];
    // 우 좌 상 하
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int dice_y = Integer.parseInt(inputs[2]);
        int dice_x = Integer.parseInt(inputs[3]);
        int K = Integer.parseInt(inputs[4]);

        graph = new int[N][M];

        for(int i=0; i<N; i++){
            inputs = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        inputs = bf.readLine().split(" ");

        for(int t=0; t<K; t++){
            int dir = Integer.parseInt(inputs[t]);
            int dice_ndy = dice_y + dy[dir];
            int dice_ndx = dice_x + dx[dir];
            if(dice_ndx < 0 || dice_ndy < 0 || dice_ndy >= N || dice_ndx >= M) continue;
            dice_x = dice_ndx;
            dice_y = dice_ndy;
            moveDice(dir);

            sb.append(dice[0]).append("\n");
            if(graph[dice_y][dice_x] == 0){
                graph[dice_y][dice_x] = dice[5];
            }else{
                dice[5] = graph[dice_y][dice_x];
                graph[dice_y][dice_x] = 0;
            }
        }

        System.out.println(sb.toString());

    }

    public static void moveDice(int dir){
        int temp1 = dice[0];
        int temp2 = dice[1];
        int temp3 = dice[2];
        int temp4 = dice[3];
        int temp5 = dice[4];
        int temp6 = dice[5];

        if(dir == 1){
            dice[2] = temp1;
            dice[5] = temp3;
            dice[3] = temp6;
            dice[0] = temp4;
        }else if(dir == 2){
            dice[0] = temp3;
            dice[2] = temp6;
            dice[5] = temp4;
            dice[3] = temp1;
        }else if(dir == 3){
            dice[4] = temp1;
            dice[5] = temp5;
            dice[1] = temp6;
            dice[0] = temp2;
        }else{
            dice[1] = temp1;
            dice[5] = temp2;
            dice[4] = temp6;
            dice[0] = temp5;
        }
    }

}