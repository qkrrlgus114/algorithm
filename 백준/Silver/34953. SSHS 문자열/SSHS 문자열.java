import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        if (N <= 3) {
            if (N == 1) System.out.println("S");
            else if (N == 2) System.out.println("SS");
            else System.out.println("SSS");
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append("SSHS");

            for (int i = 5; i <= N; i++) {
                if (i % 3 == 2 || i % 3 == 1) {
                    sb.append("S");
                } else {
                    sb.append("H");
                }
            }

            System.out.println(sb);
        }
    }
}