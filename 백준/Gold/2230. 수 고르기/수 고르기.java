import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            arr[i] = Integer.parseInt(s);
        }

        Arrays.sort(arr);

        int l = 0;
        int r = 0;
        int result = Integer.MAX_VALUE;
        while(true){
            if(l > r) break;

            int sum = Math.abs(arr[l] - arr[r]);

            if(sum >= M){
                result = Math.min(result, sum);
                l++;
            }else{
                r++;
                if(r >= N) break;
            }
        }

        System.out.println(result);

    }

}