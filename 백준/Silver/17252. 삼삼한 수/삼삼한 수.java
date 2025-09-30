import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        if (N == 0) {
            System.out.println("NO");
        } else {
            while (true) {
                if (N <= 1) {
                    System.out.println("YES");
                    break;
                }
                int nam = N % 3;
                if (nam == 2) {
                    System.out.println("NO");
                    break;
                }
                N /= 3;
            }
        }
    }

}
