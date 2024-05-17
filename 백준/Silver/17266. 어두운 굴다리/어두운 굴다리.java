import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        s = bf.readLine();
        int M = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[M];
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = 0;
        int l = 0;
        int r = N;

        while (l <= r) {
            int mid = (l + r) / 2;

            boolean check = true;
            int lastValue = 0;
            for(int i=0; i<M; i++){
                if((i == 0 && arr[i] - mid > 0) || lastValue < arr[i] - mid || (i == M-1 && arr[i] + mid < N)){
                    check = false;
                    break;
                }
                lastValue = arr[i] + mid;
            }

            if(check){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }

}

