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
        int S = Integer.parseInt(sa[1]);

        // 정답
        int min_length = Integer.MAX_VALUE;

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int l = 0;
        int r = 0;
        int sum = arr[l];
        while(true){
            if(l > r) break;

            if(sum >= S){
                if(r - l + 1 < min_length){
                    min_length = r - l + 1;
                }
                l++;
                sum -= arr[l-1];
            }else if(sum < S){
                r++;
                if(r >= N) break;
                sum += arr[r];
            }
        }
        if(min_length == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min_length);
    }

}