import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int answer = 0;

        while (N > 1) {
            int index = 0;
            int num = arr[0];
            for (int i = 1; i < N; i++) {
                if (num <= arr[i]) {
                    num = arr[i];
                    index = i;
                }
            }

            if (index != 0) {
                arr[0] += 1;
                arr[index] -= 1;
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

}
