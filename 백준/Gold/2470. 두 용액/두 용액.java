import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int answer = 2000000001;
    static int result1, result2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        arr = new int[N];

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            binarySearch(0, N-1, arr[i]);
        }

        System.out.println(Math.min(result1, result2) + " " + Math.max(result1, result2));
    }

    public static void binarySearch(int start, int end, int target){
        if(start > end) return;

        int mid = (start + end) / 2;
        int value = arr[mid];

        if(value == target){
            return;
        }

        if(Math.abs(target + value) < answer){
            result1 = value;
            result2 = target;
            answer = Math.abs(result1 + result2);
        }

        if(value + target < 0){
            binarySearch(mid + 1, end, target);
        }else if(value + target > 0){
            binarySearch(start, mid - 1, target);
        }
    }
}