import java.io.*;
import java.util.*;

public class Main {

    /*
     * x < M이면 x' = x+1, x >= M이면 x' = 1
     * y < N이면 y' = y+1, y >= N이면 y' = 1
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            String[] sa = bf.readLine().split(" ");
            int M = Integer.parseInt(sa[0]);
            int N = Integer.parseInt(sa[1]);
            int x = Integer.parseInt(sa[2]) - 1;
            int y = Integer.parseInt(sa[3]) - 1;
            boolean check = false;

            for (int i = x; i < (N * M); i += M) {
                if(i % N == y){
                    System.out.println(i + 1);
                    check = true;
                    break;
                }
            }

            if(!check){
                System.out.println(-1);
            }

        }
    }


}
