import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int Q = Integer.parseInt(sa[1]);

        int[][] arr = new int[N + 1][3];

        for(int i=0; i<N; i++){
            int cow = Integer.parseInt(bf.readLine());

            if(cow == 1){
                arr[i+1][0] = arr[i][0] + 1;
                arr[i+1][1] = arr[i][1];
                arr[i+1][2] = arr[i][2];
            } else if(cow == 2){
                arr[i+1][0] = arr[i][0];
                arr[i+1][1] = arr[i][1] + 1;
                arr[i+1][2] = arr[i][2];
            } else{
                arr[i+1][0] = arr[i][0];
                arr[i+1][1] = arr[i][1];
                arr[i+1][2] = arr[i][2] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            sb.append(arr[end][0] - arr[start - 1][0]).append(" ").append(arr[end][1] - arr[start - 1][1]).append(" ").append(arr[end][2] - arr[start - 1][2]).append("\n");
        }

        System.out.println(sb);
    }
}
