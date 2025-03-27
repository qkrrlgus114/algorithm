import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 2여 1남
     * N명의 여자, M명의 남자
     * K명의 인턴십
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int K = Integer.parseInt(sa[2]);

        int answer = 0;
        // 우선 남, 녀 최대의 팀을 뽑는다.
        while (true) {
            if (N - 2 >= 0 && M - 1 >= 0) {
                N -= 2;
                M -= 1;
                answer++;
            } else {
                break;
            }
        }

        // K명 미만이라면 팀을 하나씩 해체한다.
        while (N + M < K) {

            N += 2;
            M += 1;
            answer--;
        }

        System.out.println(answer);
    }
}
