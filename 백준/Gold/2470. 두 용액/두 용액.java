import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static Integer[] arr;
    static int min = Integer.MAX_VALUE;
    static int result_one = 0;
    static int result_two = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        arr = new Integer[N];

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            binarySearch(i+1, N-1, arr[i], i);
        }

        int a = Math.max(result_one, result_two);
        int b = Math.min(result_one, result_two);

        System.out.println(b + " " + a);

    }

    public static void binarySearch(int low, int high, int target, int index){
        if(low > high) return;

        int mid = (low + high) / 2;
        if(index == mid) return;

        int value = Math.abs(target + arr[mid]);
        if(min > value){
            min = value;
            result_one = target;
            result_two = arr[mid];
        }

        if(target + arr[mid] < 0){
            binarySearch(mid + 1, high, target, index);
        }

        if(target + arr[mid] > 0) {
            binarySearch(low, mid - 1, target, index);
        }
    }
}
