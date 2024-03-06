import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);
        arr = new int[N];

        for(int i=0; i<N; i++) {
            s = bf.readLine();
            arr[i] = Integer.parseInt(s);
        }

        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                sum.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(sum);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int value = arr[i] - arr[j];
                boolean result = binarySearch(0, sum.size() - 1, value);
                if(result){
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);

    }

    public static boolean binarySearch(int low, int high, int value){
        if(low > high){
            return false;
        }

        int mid = (low + high) / 2;

        // 값이 왼쪽에 있으면
        if(sum.get(mid) > value){
            return binarySearch(low, mid-1, value);
        }

        // 값이 오른쪽에 있으면
        if(sum.get(mid) < value){
            return binarySearch(mid+1, high, value);
        }

        if(sum.get(mid) == value){
            return true;
        }

        return false;
    }
}
