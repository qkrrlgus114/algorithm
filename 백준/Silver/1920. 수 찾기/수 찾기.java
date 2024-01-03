import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        String[] list = bf.readLine().split(" ");
        A = new int[list.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(list[i]);
        }

        s = bf.readLine();
        int M = Integer.parseInt(s);
        list = bf.readLine().split(" ");
        B = new int[list.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(list[i]);
        }

        Arrays.sort(A);

        for (int i = 0; i < B.length; i++) {
            int result = binarySearch(0, A.length - 1, B[i]);
            System.out.println(result);
        }
    }

    public static int binarySearch(int start, int end, int target) {

        int mid = (start + end) / 2;

        if (start <= end) {
            if (A[mid] == target) {
                return 1;
            }

            if (target < A[mid]) {
                return binarySearch(start, mid - 1, target);
            }

            if (target > A[mid]) {
                return binarySearch(mid + 1, end, target);
            }
        }
        return 0;
    }
}