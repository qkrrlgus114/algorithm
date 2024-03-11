import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int result_one = 0;
    static int result_two = 0;
    static int value = Integer.MAX_VALUE;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        arr = new int[N];
        String[] sa = bf.readLine().split(" ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int l = 0;
        int r = N-1;
        while(true){
            if(l >= r) break;
            int sum = arr[l] + arr[r];
            // 0에 가까운 값 갱신
            if(Math.abs(sum) < value){
                value = Math.abs(sum);
                result_one = arr[l];
                result_two = arr[r];
                if(Math.abs(sum) == 0) break;
            }

            // 음수이면
            if(sum < 0){
                l++;
            }
            // 양수이면
            else if(sum > 0){
                r--;
            }
        }

        System.out.println(Math.min(result_one, result_two) + " " + Math.max(result_one, result_two));

    }

}