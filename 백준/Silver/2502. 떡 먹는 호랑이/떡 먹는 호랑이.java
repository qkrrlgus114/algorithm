import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int D = Integer.parseInt(sa[0]); // 넘어온 날
        int K = Integer.parseInt(sa[1]); // 떡의 개수

        int[] day = new int[D];
        day[D - 1] = K;

        // K - (k / 2)가 이전 날의 떡이 될 수 있는 경우의 수.
        for (int i = 1; i <= K / 2; i++) {
            day[D - 2] = K - i;
            boolean flag = true;
            for (int j = D - 3; j >= 0; j--) {
                day[j] = day[j + 2] - day[j + 1];
                // 만약의 떡이 1보다 작아지면 종료.(조건에 안맞음)
                if (day[j] < 1 || day[j] > day[j + 1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(day[0]);
                System.out.println(day[1]);
                break;
            }
        }
    }
}