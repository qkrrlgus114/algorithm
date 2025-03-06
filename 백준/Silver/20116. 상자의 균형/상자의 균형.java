import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int L = Integer.parseInt(sa[1]);

        double[] arr = new double[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(sa[i]);
        }

        double sum = 0; // 무게중심의 합
        int index = 1;
        boolean status = true;

        for (int i = N - 1; i > 0; i--) {
            sum += arr[i];
            double center = sum / index++;

            double leftL = arr[i - 1] - L;
            double rightL = arr[i - 1] + L;

            if (leftL < center && rightL > center) {
                // 밑에 상자가 범위를 벗어나는지 확인
                if (arr[i - 1] - L >= arr[i] + L || arr[i - 1] + L <= arr[i] - L) {
                    status = false;
                    break;
                }
            } else {
                status = false;
                break;
            }
        }

        System.out.println(status ? "stable" : "unstable");

    }

}