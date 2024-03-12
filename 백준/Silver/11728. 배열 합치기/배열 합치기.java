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

        int[] arr_n = new int[N];
        int[] arr_m = new int[M];


        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr_n[i] = Integer.parseInt(sa[i]);
        }
        sa = bf.readLine().split(" ");
        for(int i=0; i<M; i++){
            arr_m[i] = Integer.parseInt(sa[i]);
        }

        StringBuilder sb = new StringBuilder();

        int l = 0;
        int r = 0;
         while(true){
             if(l >= N && r >= M) break;

             if(l >= N){
                 sb.append(arr_m[r]).append(" ");
                 r++;
             }else if(r >= M){
                 sb.append(arr_n[l]).append(" ");
                 l++;
             }else{
                 int n = arr_n[l];
                 int m = arr_m[r];
                 if(n > m){
                     sb.append(m).append(" ");
                     r++;
                 }else{
                     sb.append(n).append(" ");
                     l++;
                 }
             }
         }

        System.out.println(sb);

    }

}