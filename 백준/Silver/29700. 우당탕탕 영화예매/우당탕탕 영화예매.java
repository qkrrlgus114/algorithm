import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]); // 행
        int M = Integer.parseInt(sa[1]); // 열
        int K = Integer.parseInt(sa[2]); // 동아리원 수

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {

            int ticket = 0; // 이미 예약된 자리

            for (int j = 0; j < K; j++) {
                if (M > j) {
                    if (arr[i][j] == '1') ticket++;
                }
            }

            if (ticket == 0) answer++;

            // 슬라이딩 윈도우
            for (int j = K; j < M; j++) {
                // 슬라이딩 윈도우의 가장 오른쪽이 예메됐으면 증가
                if (arr[i][j] == '1') ticket++;
                // 슬라이딩 윈도우의 가장 왼쪽이 예매됐으면 감소
                if (arr[i][j - K] == '1') ticket--;

                if (ticket == 0) answer++;
            }
        }

        System.out.println(answer);
    }

}