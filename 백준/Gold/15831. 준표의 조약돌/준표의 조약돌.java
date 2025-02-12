import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);
        int W = Integer.parseInt(sa[2]);

        int answer = 0;

        char[] arr = bf.readLine().toCharArray();

        int s = 0;
        int e = -1;
        int b = 0;
        int w = 0;

        while (e < N - 1) {
            e++;
            if (arr[e] == 'B') b++;
            else w++;
            // W개 이상, B개 이하라면
            if (w >= W && b <= B) {
                answer = Math.max(answer, e - s + 1);
            }
            // B개 초과라면 당겨줌
            else if (b > B) {
                while (b > B) {
                    if (arr[s] == 'B') b--;
                    else w--;
                    s++;
                }

                if (w >= W && b <= B) {
                    answer = Math.max(answer, e - s + 1);
                }
            }
        }

        System.out.println(answer);
    }
}