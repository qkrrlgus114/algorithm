import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] list;
    static int N;
    static Long max = Long.MIN_VALUE;
    static Long min = Long.MAX_VALUE;
    static String str_min = "";
    static String str_max = "";
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        N = Integer.parseInt(input);
        list = new String[N];
        list = bf.readLine().split(" ");
        boolean[] visited = new boolean[10];
        numbers = new int[N + 1];

        for(int i=0; i<10; i++){
            numbers[0] = i;
            visited[i] = true;
            dfs(0, visited);
            visited[i] = false;
        }
        System.out.println(str_max);
        System.out.println(str_min);
    }

    public static void dfs(int depth, boolean[] visited){
        // 종료 조건
        if(depth == N){
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<numbers.length; i++){
                temp.append(numbers[i]);
            }

            Long temp_long = Long.valueOf(temp.toString());
            if(temp_long < min){
                min = temp_long;
                str_min = temp.toString();
            }else if(temp_long > max){
                max = temp_long;
                str_max = temp.toString();
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(visited[i]) continue;
            if(list[depth].equals("<")){
                if(numbers[depth] < i){
                    visited[i] = true;
                    numbers[depth + 1] = i;
                    dfs(depth + 1, visited);
                    visited[i] = false;
                }
            }else if(list[depth].equals(">")){
                if(numbers[depth] > i){
                    visited[i] = true;
                    numbers[depth + 1] = i;
                    dfs(depth + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

}