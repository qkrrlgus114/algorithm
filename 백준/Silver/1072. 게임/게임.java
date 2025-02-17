import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int X = Integer.parseInt(sa[0]);
        int Y = Integer.parseInt(sa[1]);
        int Z = (int) ((long) Y * 100 / X);

        int l = 0;
        int r = 1000000000;
        long answer = Long.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;
            int value = (int) ((long) (Y + mid) * 100 / (X + mid));
            if (value > Z) {
                r = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                l = mid + 1;
            }
        }

        if (answer == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

}