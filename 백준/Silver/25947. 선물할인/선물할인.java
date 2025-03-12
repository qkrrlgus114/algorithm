import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int n = Integer.parseInt(sa[0]);
        int b = Integer.parseInt(sa[1]);
        int a = Integer.parseInt(sa[2]);

        sa = bf.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int answer = 0;

        // 할인된 가격으로 우선 구매
        long cash = 0;
        for (int i = 0; i < a; i++) {
            cash += arr[i] / 2;
            if (cash <= b) {
                answer++;
            }
        }

        int s = 0;
        if (cash <= b) {
            for (int i = a; i < n; i++) {
                // 할인된 금액을 더해주고
                cash += arr[i] / 2;
                // s번째 금액을 원금으로 바꿔놓는다.(다시 반값을 더하면 원금이 됨)
                cash += arr[s] / 2;
                s++;

                if (cash <= b) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);

    }

}