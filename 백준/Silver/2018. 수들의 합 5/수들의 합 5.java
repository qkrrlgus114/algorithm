import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int answer = 0;
        int sum = 1;

        int l = 1;
        int r = 1;

        while (r <= N) {
            if (N == sum) {
                answer++;
                r++;
                sum += r;
            } else if (N > sum) {
                r++;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }

        System.out.println(answer);
    }

}