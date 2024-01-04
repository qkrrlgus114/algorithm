import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        back(0);
    }

    public static void back(int count){
        if(count == M){
            for(Integer r : result){
                System.out.print(r + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[count] = i + 1;
                back(count + 1);
                visited[i] = false;
            }
        }
    }


}