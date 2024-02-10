import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] graph = new int[5][8];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 5; i++) {
            char[] cinput = bf.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                graph[i][j] = cinput[j] - 48;
            }
        }

        String input = bf.readLine();
        int K = Integer.parseInt(input);
        int point = 0;

        for (int q = 0; q < K; q++) {
            String[] inputs = bf.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            int dir = Integer.parseInt(inputs[1]);
            int[] check = new int[5];
            // 오른쪽 1, 왼쪽 2
            if(dir == 1) check[num] = 1;
            else check[num] = 2;

            // 왼쪽으로 가면서 확인
            if (num > 1) {
                for (int i = num; i > 1; i--) {
                    if (graph[i - 1][2] != graph[i][6]) {
                        if(check[i] == 1) check[i - 1] = 2;
                        else if(check[i] == 2) check[i - 1] = 1;
                    } else {
                        break;
                    }
                }
            }

            // 오른쪽으로 가면서 확인
            for (int i = num; i < 4; i++) {
                if (graph[i][2] != graph[i + 1][6]) {
                    if(check[i] == 1) check[i + 1] = 2;
                    else if(check[i] == 2) check[i + 1] = 1;
                } else {
                    break;
                }
            }
//            System.out.println(Arrays.toString(check));

            for(int i=1; i<5; i++){
                if(check[i] == 1) right(i);
                else if(check[i] == 2) left(i);
            }

        }

        // 점수 확인
        for(int i=1; i<5; i++){
            if(graph[i][0] == 1){
                point += (int) Math.pow(2, i-1);
            }
        }
        System.out.println(point);
    }

    // 왼쪽으로 톱니 이동
    public static void left(int y) {
        int temp = graph[y][0];
        for (int i = 1; i < 8; i++) {
            graph[y][i - 1] = graph[y][i];
        }
        graph[y][7] = temp;
    }

    // 오른쪽으로 톱니 이동
    public static void right(int y) {
        int temp = graph[y][7];
        for (int i = 6; i >= 0; i--) {
            graph[y][i + 1] = graph[y][i];
        }
        graph[y][0] = temp;
    }
}