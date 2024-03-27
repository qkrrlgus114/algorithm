import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int N, K;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        String s = bf.readLine();
        visited = new boolean[N];

        arr  = s.toCharArray();

        int result = 0;

        for(int i=0; i<N; i++){
            if(arr[i] == 'P'){
                for(int j=i-K; j<=i+K; j++){
                    if(j < 0 || j >= N || visited[j]) continue;
                    if(arr[j] == 'H'){
                        result++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }
}

