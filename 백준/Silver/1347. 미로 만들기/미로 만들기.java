import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0 ,-1};
    static int[] dy = {-1, 0, 1, 0};
    // 좌표 저장 리스트
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int T = Integer.parseInt(input);
        char[] inputs = bf.readLine().toCharArray();

        // 현재 위치
        int cur_dir = 2;
        // 현재 좌표
        int cur_x = 0;
        int cur_y = 0;
        // 초기 위치 삽입
        list.add(new int[]{0, 0});

        for(int i=0; i<inputs.length; i++){
            if(inputs[i] == 'R') cur_dir = (cur_dir + 1) % 4;
            else if(inputs[i] == 'L'){
                if(cur_dir == 0) cur_dir = 3;
                else cur_dir -= 1;
            }else{
                cur_x += dx[cur_dir];
                cur_y += dy[cur_dir];
                list.add(new int[]{cur_y, cur_x});
            }
        }

        int large_x = Integer.MIN_VALUE;
        int small_x = Integer.MAX_VALUE;
        int large_y = Integer.MIN_VALUE;
        int small_y = Integer.MAX_VALUE;

        // 돌면서 배열의 크기를 구하기 위해 최소 최대의 좌표를 구함.
        for(int i=0; i<list.size(); i++){
            int[] temp = list.get(i);
            if(temp[0] > large_y) large_y = temp[0];
            if(temp[0] < small_y) small_y = temp[0];
            if(temp[1] > large_x) large_x = temp[1];
            if(temp[1] < small_x) small_x = temp[1];
        }

        char[][] graph = new char[Math.abs(large_y) + Math.abs(small_y) + 1][Math.abs(large_x) + Math.abs(small_x) + 1];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                graph[i][j] = '#';
            }
        }

        for(int i=0; i<list.size(); i++){
            int[] temp = list.get(i);
            graph[temp[0] + Math.abs(small_y)][temp[1] + Math.abs(small_x)] = '.';
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }


    }

}