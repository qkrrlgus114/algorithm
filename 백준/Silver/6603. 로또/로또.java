import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     * 7 <= k <= 12
     *
     * 앞에 이미 골랐던 건 건너뛴다.
     * */

    static StringBuilder sb = new StringBuilder();
    static int[] temp = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] sa = bf.readLine().split(" ");
            if (sa.length == 1) break;

            int[] arr = new int[Integer.parseInt(sa[0])];
            for (int i = 1; i < sa.length; i++) {
                arr[i - 1] = Integer.parseInt(sa[i]);
            }

            choice(0, arr, 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void choice(int choiceNum, int[] arr, int idx) {
        if (choiceNum == 6) {
            // 계산
            for (int i = 0; i < 6; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            temp[choiceNum] = arr[i];
            choice(choiceNum + 1, arr, i + 1);
        }

    }


}