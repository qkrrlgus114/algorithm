import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    * 1. 현재 위치랑 다음 위치를 같이 업데이트한다.
    * 2.
    * */

    static char[][] graph;
    static int y = 0;
    static int x = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        graph = new char[N][N];
        char[] commands = bf.readLine().toCharArray();

        for(int i=0; i<N; i++){
            Arrays.fill(graph[i], (char) 46);
        }

        for(int i=0; i<commands.length; i++){
            if(commands[i] == 'D' && y + 1 < N){
                moveY();
                y++;
                moveY();
            }else if(commands[i] == 'U' && y - 1 >= 0){
                moveY();
                y--;
                moveY();
            }else if(commands[i] == 'L' && x - 1 >= 0){
                moveX();
                x--;
                moveX();
            }else if(commands[i] == 'R' && x + 1 < N){
                moveX();
                x++;
                moveX();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void moveY(){
        if(graph[y][x] == '-' || graph[y][x] == '+'){
            graph[y][x] = '+';
        }else{
            graph[y][x] = '|';
        }
    }

    public static void moveX(){
        if(graph[y][x] == '|' || graph[y][x] == '+'){
            graph[y][x] = '+';
        }else{
            graph[y][x] = '-';
        }
    }

}