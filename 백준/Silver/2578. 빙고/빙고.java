import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int count = 0;
    static int result = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        visited = new boolean[5][5];
        for(int i=0; i<5; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        flag: for(int i=0; i<5; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<5; j++){
                bingoCheck(Integer.parseInt(sa[j]));
                if(check){
                    System.out.println((i*5) + (j+1));
                    break flag;
                }
            }
        }
    }

    public static void bingoCheck(int target){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j] == target){
                    visited[i][j] = true;
                    up(i,j);
                    down(i,j);
                    bingoCheck();
                    left(i,j);
                    right(i,j);
                    bingoCheck();
                    leftUp(i, j);
                    rightDown(i, j);
                    bingoCheck();
                    leftDown(i, j);
                    rightUp(i, j);
                    bingoCheck();
                }
            }
        }
    }

    public static void up(int y, int x){
        while(true){
            y -= 1;
            if(y >= 0){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void down(int y, int x){
        while(true){
            y += 1;
            if(y < 5){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void left(int y, int x){
        while(true){
            x -= 1;
            if(x >= 0){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void right(int y, int x){
        while(true){
            x += 1;
            if(x < 5){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void leftUp(int y, int x){
        while(true){
            y -= 1;
            x -= 1;
            if(x >= 0 && y >= 0){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void rightDown(int y, int x){
        while(true){
            y += 1;
            x += 1;
            if(x < 5 && y < 5){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void leftDown(int y, int x){
        while(true){
            y += 1;
            x -= 1;
            if(x >= 0 && y < 5){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void rightUp(int y, int x){
        while(true){
            y -= 1;
            x += 1;
            if(x < 5 && y >= 0){
                if(visited[y][x]) count++;
                else break;
            }else{
                break;
            }
        }
    }

    public static void bingoCheck(){
        if(count == 4){
            result++;
            if(result == 3){
                check = true;
                return;
            }
        }
        count = 0;
    }
}
