import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 0.129 ~ 0.138
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]); // 남은 시간
        int L = Integer.parseInt(sa[1]); // 알코올 지속 시간

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        // L의 길이를 가지는 슬라이딩 윈도우
        int answer = 0;
        int sum = 0; // 슬라이딩 윈도우의 합

        for (int i = 0; i < L; i++) {
            sum += arr[i];
            if (sum >= 129 && sum <= 138) answer++;
        }

        for (int i = L; i < N; i++) {
            sum += arr[i];
            sum -= arr[i - L];

            if (sum >= 129 && sum <= 138) answer++;
        }

        System.out.println(answer);


    }

}


