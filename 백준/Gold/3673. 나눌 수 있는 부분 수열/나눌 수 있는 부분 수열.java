import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            String[] sa = bf.readLine().split(" ");
            int d = Integer.parseInt(sa[0]);
            int n = Integer.parseInt(sa[1]);

            sa = bf.readLine().split(" ");
            long[] sum = new long[n + 1];
            for(int i=1; i<=n; i++){
                sum[i] = sum[i - 1] + Integer.parseInt(sa[i - 1]);
            }

            long[] mod = new long[d + 1];
            mod[0] = 1;
            for(int i=1; i<=n; i++){
                mod[(int) (sum[i] % d)]++;
            }

            int answer = 0;
            for(int i=0; i<d; i++){
                if(mod[i] == 0) continue;
                answer += (mod[i] * (mod[i] - 1)) / 2;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}