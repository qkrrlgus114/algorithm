import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] sang = new int[N];
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sang[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(sang);

        int M = Integer.parseInt(bf.readLine());
        sa = bf.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(sa[i]);
            int count = upperBound(sang, target) - lowerBound(sang, target);
            sb.append(count).append(" ");
        }

        System.out.println(sb);

    }

    static int lowerBound(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] >= target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    static int upperBound(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}