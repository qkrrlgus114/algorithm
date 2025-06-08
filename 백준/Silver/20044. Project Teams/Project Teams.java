import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()) * 2;
        int[] arr = new int[n];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(sa[i]);

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = arr[i] + arr[n - i - 1];
            if (min > sum)
                min = sum;
        }

        System.out.println(min);

    }
}
