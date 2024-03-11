import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N, M;
    static int[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        arr = new int[N];

        int min = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            int temp = Integer.parseInt(s);

            min = Math.max(min, temp);
            max += temp;
            arr[i] = temp;
        }

        binarySearch(min, max);
        System.out.println(result);
    }

    public static void binarySearch(int low, int high){
        if(low > high){
            return;
        }

        int mid = (low + high) / 2;

        // 잔고
        int price = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            if(price - arr[i] >= 0){
                if(N - i == M - count){
                    price = mid;
                    count++;
                }
                price -= arr[i];
            }else if(price - arr[i] < 0){
                price = mid;
                count++;
                price -= arr[i];
            }
        }

        if(count > M){
            binarySearch(mid + 1, high);
        }else{
            result = Math.min(result, mid);
            binarySearch(low, mid - 1);
        }
    }


}