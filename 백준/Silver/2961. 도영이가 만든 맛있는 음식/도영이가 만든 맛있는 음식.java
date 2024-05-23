import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] item;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        item = new int[N][2];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            item[i][0] = Integer.parseInt(sa[0]);
            item[i][1] = Integer.parseInt(sa[1]);
        }

        dfs(0, 0, 1, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int count, int sin, int ssn){
        if(count >= 1){
            int value = Math.abs(sin - ssn);
            if(Math.abs(answer) > value) answer = value;
        }

        for(int i=depth; i<N; i++){
            dfs(i + 1, count + 1,sin * item[i][0], ssn + item[i][1]);
        }
    }
}

