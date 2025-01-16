import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int sex = Integer.parseInt(sa[0]);
            int num = Integer.parseInt(sa[1]);

            if (sex == 1) man(num - 1, arr);
            else girl(num - 1, arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i % 20 == 0) sb.append("\n");
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    // 남자는 배수의 칸을 바꾼다.
    private static void man(int num, int[] arr) {
        for (int i = num; i < arr.length; i += num + 1) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    // 여자는 좌우로 이동하면서 확인한다.
    private static void girl(int num, int[] arr) {
        arr[num] = arr[num] == 0 ? 1 : 0;

        int back = num - 1;
        int front = num + 1;
        while (true) {
            // 칸을 넘었다면 끝
            if (back < 0 || front >= arr.length) return;

            // 둘이 같지 않다면 끝
            if (arr[back] != arr[front]) return;

            arr[back] = arr[front] = arr[back] == 0 ? 1 : 0;
            back--;
            front++;
        }
    }

}