import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<sa.length; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
