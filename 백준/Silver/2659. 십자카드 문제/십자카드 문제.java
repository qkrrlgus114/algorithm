import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] checkTimeNum = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 시계수 계산 진행
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        getTimeNumCalculator(i, j, k, l);
                    }
                }
            }
        }

        int result = 0;
        int curTimeNum = getTimeNumCalculator(nums[0], nums[1], nums[2], nums[3]);

        for (int i = 1111; i < curTimeNum; i++) {
            if (checkTimeNum[i]) {
                result++;
            }
        }

        System.out.println(result + 1);

    }

    // 시계수 계신기
    private static int getTimeNumCalculator(int a, int b, int c, int d) {
        int num1 = (a * 1000) + (b * 100) + (c * 10) + d;
        num1 = Math.min((b * 1000) + (c * 100) + (d * 10) + a, num1);
        num1 = Math.min((c * 1000) + (d * 100) + (a * 10) + b, num1);
        num1 = Math.min((d * 1000) + (a * 100) + (b * 10) + c, num1);

        // 시계수가 맞다고 체크
        checkTimeNum[num1] = true;

        return num1;
    }

}