import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            String[] sa = bf.readLine().split(" ");
            long N = Long.parseLong(sa[0]);
            long M = Long.parseLong(sa[1]);
            long result = 1;
            
            for (int j = 0; j < N; j++) {
                result *= (M - j);
                result /= (j + 1);
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}