import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(sa[i]);
        }

        int[][] result = new int[100001][2];
        boolean check = false;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");

            int seq = Integer.parseInt(sa[0]);
            minNum = Math.min(minNum, seq);
            int point = 0;
            for (int j = 1; j < sa.length; j++) {
                if ("O".equals(sa[j])) {
                    point += points[j - 1];
                    check = true;
                }
            }
            result[seq - 1][0] = seq;
            result[seq - 1][1] = point;
        }

        Arrays.sort(result, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        if (check) {
            System.out.println(result[0][0] + " " + result[0][1]);
        } else {
            System.out.println(minNum + " " + result[0][1]);
        }


    }

}
