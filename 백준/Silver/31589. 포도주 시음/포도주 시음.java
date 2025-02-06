import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int l = 0;
        int lValue = 0;
        int r = N - 1;
        int rValue = 0;
        long result = 0;
        boolean rTurn = true;

        while (K != 0) {
            // 오른쪽 차례면
            if (rTurn) {
                rValue = arr[r];
                // 차이를 계산하고
                result += rValue - lValue;
                // r, K를 둘 다 뺀다
                r--;
                K--;
                // 왼쪽 턴으로 넘김
                rTurn = false;
            } else {
                lValue = arr[l++];
                K--;
                rTurn = true;
            }
        }

        System.out.println(result);
    }
}