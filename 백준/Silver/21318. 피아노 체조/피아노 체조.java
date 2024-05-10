import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        String[] sa = bf.readLine().split(" ");

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);

            if(arr[i-1] > arr[i]){
                sum[i] = sum[i-1] + 1;
            }else{
                sum[i] = sum[i-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        s = bf.readLine();
        int M = Integer.parseInt(s);
        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            int mistake = sum[end] - sum[start];
            sb.append(mistake).append("\n");
        }

        System.out.println(sb);




    }
}

