import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 모든 인원을 배정해라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int room1 = Integer.parseInt(sa[0]);
        int room2 = Integer.parseInt(sa[1]);
        int room3 = Integer.parseInt(sa[2]);
        int N = Integer.parseInt(sa[3]);

        // 방 하나로 처리되면
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    if ((room1 * i) + (room2 * j) + (room3 * k) == N) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(0);
    }
}
