import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] A;
    static int[] B;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int T = Integer.parseInt(s);

        for(int t=0; t<T; t++){
            String[] sa = bf.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            A = new int[N];
            B = new int[M];
            sa = bf.readLine().split(" ");
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(sa[i]);
            }
            sa = bf.readLine().split(" ");
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(sa[i]);
            }

            Arrays.sort(B);

            for(int i=0; i<N; i++){
                binarySearch(0, M-1, A[i]);
            }

            System.out.println(result);
            result = 0;
        }
    }

    public static void binarySearch(int low, int high, int target){
        if(low > high) return;

        int mid = (low + high) / 2;

        if(B[mid] < target){
            result += (mid - low + 1);
            binarySearch(mid + 1, high, target);
        }else{
            binarySearch(low, mid - 1, target);
        }
    }
}