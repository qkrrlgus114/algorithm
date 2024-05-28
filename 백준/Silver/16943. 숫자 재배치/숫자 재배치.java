import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Long answer = -1L;
    static String A;
    static Long B;
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        A = sa[0];
        B = Long.parseLong(sa[1]);
        arr = new char[A.length()];
        visited = new boolean[A.length()];

        for(int i=0; i<A.length(); i++){
            arr[i] = A.charAt(i);
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth){
        // 종료 조건
        if(depth == A.length()){
            String temp = sb.toString();
            Long tempValue = Long.parseLong(temp);

            if(tempValue < B){
                answer = Math.max(answer, tempValue);
            }

            return;
        }

        // 재귀 조건
        for(int i=0; i<arr.length; i++){

            if(visited[i]) continue;
            // 0으로 시작하면 안 된다.
            if(depth == 0 && arr[i] == '0') continue;

            visited[i] = true;
            sb.append(arr[i]);
            dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

}


