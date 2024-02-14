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

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        N = Integer.parseInt(input);
        list = new String[N];
        list = bf.readLine().split(" ");
        boolean[] visited = new boolean[10];
        List<Integer> numbers = new ArrayList<>();

        for(int i=0; i<10; i++){
            numbers.add(i);
            visited[i] = true;
            dfs(0, visited, numbers);
            visited[i] = false;
            numbers.remove(0);
        }
        System.out.println(str_max);
        System.out.println(str_min);
    }

    public static void dfs(int depth, boolean[] visited, List<Integer> numbers){
        // 종료 조건
        if(depth == N){
            String temp = "";
            for(int i=0; i<numbers.size(); i++){
                temp += String.valueOf(numbers.get(i));
            }

            Long temp_long = Long.valueOf(temp);
            if(temp_long < min){
                min = temp_long;
                str_min = temp;
            }else if(temp_long > max){
                max = temp_long;
                str_max = temp;
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(visited[i]) continue;
            if(list[depth].equals("<")){
                if(numbers.get(depth) < i){
                    visited[i] = true;
                    numbers.add(i);
                    dfs(depth + 1, visited, numbers);
                    visited[i] = false;
                    numbers.remove(depth + 1);
                }
            }else if(list[depth].equals(">")){
                if(numbers.get(depth) > i){
                    visited[i] = true;
                    numbers.add(i);
                    dfs(depth + 1, visited, numbers);
                    visited[i] = false;
                    numbers.remove(depth + 1);
                }
            }
        }
    }

}