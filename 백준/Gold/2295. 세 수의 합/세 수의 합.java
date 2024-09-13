import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static List<Integer> prefix = new ArrayList<>();
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                prefix.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(prefix);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean check = binarySearch(0, prefix.size() - 1, arr[i] - arr[j]);
                if(check) result = Math.max(result, arr[i]);
            }
        }

        System.out.println(result);
    }

    public static boolean binarySearch(int start, int end, int target) {
        if (start > end) return false;

        int mid = (start + end) / 2;
        int value = prefix.get(mid);

        if (value == target) {
            return true;
        } else if (value > target) {
            return binarySearch(start, mid - 1, target);
        } else {
            return binarySearch(mid + 1, end, target);
        }
    }
}
