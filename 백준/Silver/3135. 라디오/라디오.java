import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int gap = Integer.MAX_VALUE;

        String[] sa = bf.readLine().split(" ");
        int a = Integer.parseInt(sa[0]);
        int b = Integer.parseInt(sa[1]);
        int n = Integer.parseInt(bf.readLine());
        int num = Math.abs(b - a);
        int[] arr = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            gap = Math.min(gap, Math.abs(b - arr[i]));
        }

        if (num <= gap) count = num;
        else count = gap + 1;

        System.out.println(count);


    }
}
