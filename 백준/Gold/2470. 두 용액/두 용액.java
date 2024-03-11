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

        for(int i=0; i<N-1; i++){
            binarySearch(i+1, N-1, arr[i]);
        }

        System.out.println(Math.min(result_one, result_two) + " " + Math.max(result_one, result_two));


    }

    public static void binarySearch(int low, int high, int target){
        if(low > high) return;

        int mid = (low + high) / 2;

        int temp = Math.abs(arr[mid] + target);

        if(temp < value){
            value = temp;
            result_one = target;
            result_two = arr[mid];
        }

        if(target + arr[mid] < 0){
            binarySearch(mid + 1, high, target);
        }else if(target + arr[mid] > 0){
            binarySearch(low, mid - 1, target);
        }

    }
}