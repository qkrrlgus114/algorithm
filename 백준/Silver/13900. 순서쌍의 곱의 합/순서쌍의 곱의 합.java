import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        long answer = 0;
        long temp = 0;

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(sa[i]);
            answer += temp * value;
            temp += value;
        }

        System.out.println(answer);
    }
}