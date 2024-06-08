import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] arr = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            String[] sa = bf.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            int d = Integer.parseInt(sa[2]);
            int g = Integer.parseInt(sa[3]);

            // 방향 구하기
            List<Integer> direction = getDirection(d, g);

            // 꼭짓점 그리기
            drawBoard(direction, y, x);
        }

        // 개수 카운팅
        int count = countBox();
        System.out.println(count);
    }

    // 방향 구하기
    private static List<Integer> getDirection(int d, int g){
        List<Integer> direction = new ArrayList<>();
        direction.add(d);

        for(int i=1; i<=g; i++){
            int size = direction.size();
            for(int j=size - 1; j >= 0; j--){
                int dir = (direction.get(j) + 1) % 4;
                direction.add(dir);
            }
        }

        return direction;
    }

    // 꼭짓점 그리기
    private static void drawBoard(List<Integer> directions, int y, int x){
        arr[y][x] = true;

        for(int i=0; i<directions.size(); i++){
            Integer direction = directions.get(i);

            switch(direction){
                case 0:
                    x += 1;
                    arr[y][x] = true;
                    break;
                case 1:
                    y -= 1;
                    arr[y][x] = true;
                    break;
                case 2:
                    x -= 1;
                    arr[y][x] = true;
                    break;
                case 3:
                    y += 1;
                    arr[y][x] = true;
                    break;
            }
        }
    }

    // 개수 파악하기
    private static int countBox(){
        int count = 0;

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]){
                    count++;
                }
            }
        }

        return count;
    }


}


