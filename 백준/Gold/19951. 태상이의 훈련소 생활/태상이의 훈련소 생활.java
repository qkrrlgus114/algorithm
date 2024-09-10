import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] ground = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            ground[i] = Integer.parseInt(sa[i]);
        }

        int[] sand = new int[N + 1];

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int k = Integer.parseInt(sa[2]);

            sand[a - 1] += k;
            sand[b] += k * -1;
        }

        int mid = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            mid += sand[i];
            ground[i] += mid;

            sb.append(ground[i]).append(" ");
        }

        System.out.println(sb);



    }
}