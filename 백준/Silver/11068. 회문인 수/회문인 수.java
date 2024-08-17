import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
     * 1. 그 자체가 회문인지 확인
     * 2. 2 ~ 64진법까지 노가다 뛰면서 가능한지 판단.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder checkSb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());

            checkSb.append(N).reverse();
            if (N == Integer.parseInt(checkSb.toString())) {
                sb.append(1).append("\n");
            } else {
                if(checkBinary(N)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

            checkSb.setLength(0);
        }

        System.out.println(sb);
    }

    public static boolean checkBinary(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 64; i++) {
            int M = N;
            while (M != 0) {
                int temp = M % i;
                if (temp < 10) sb.append(temp);
                else {
                    sb.append((char) (temp - 10 + 'A'));
                }
                M /= i;
            }
            String a = sb.toString();
            String b = sb.reverse().toString();
            if(a.equals(b)) return true;
            sb.setLength(0);
        }

        return false;
    }
}