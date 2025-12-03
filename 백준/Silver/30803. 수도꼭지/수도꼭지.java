import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
     * 전체 물의 양을 구해놓음
     * 1
     *   (1) 수도꼭지 열려있음 -> 누적 물의 양 감소. 해당 수도꼭지 양 감소
     *   (2) 수도꼭지 닫혀있음 -> 해당 수도꼭지 양 감소
     *
     * 2
     *   (1) 수도꼭지 열려있음 -> 수도꼭지 잠금. 누적 물의 양 감소
     *   (2) 수도꼭지 닫혀있음 -> 수도꼭지 열음. 누적 물의 양 증가
     *
     * 1. 누적 물의 양 관리
     * 2. 수도꼭지 상태 관리
     * 3. 총 물의 양
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long totalWater = 0L;

        int N = Integer.parseInt(bf.readLine());
        long[] water = new long[N + 1];
        boolean[] status = new boolean[N + 1];
        Arrays.fill(status, true);

        StringBuilder sb = new StringBuilder();

        String[] sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            water[i + 1] = Integer.parseInt(sa[i]);
            totalWater += water[i + 1];
        }
        sb.append(totalWater).append("\n");

        int command = Integer.parseInt(bf.readLine());

        for (int i = 0; i < command; i++) {
            sa = bf.readLine().split(" ");

            int c = Integer.parseInt(sa[0]);

            if (c == 1) {
                int j = Integer.parseInt(sa[1]);
                int x = Integer.parseInt(sa[2]);

                if (status[j]) {
                    totalWater -= water[j];
                }
                water[j] = x;
                if (status[j]) {
                    totalWater += water[j];
                }
            } else {
                int j = Integer.parseInt(sa[1]);

                if (status[j]) {
                    status[j] = !status[j];
                    totalWater -= water[j];
                } else {
                    status[j] = !status[j];
                    totalWater += water[j];
                }
            }
            sb.append(totalWater).append("\n");
        }

        System.out.println(sb.toString());
    }


}
