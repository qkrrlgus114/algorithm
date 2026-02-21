import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 1. base 열의 개수와 target 행의 개수가 같아야 곱셈이 가능.
     * 2. 계산 결과는 base의 행렬 개수와 동일하게 나온다.
     * <p>
     * 입력 다 받고
     * 1. base 열의 개수, target 행의 개수 비교.
     * -> 다르면 곱셈 불가능 -1 출력
     * <p>
     * 2. 계산결과를 갱신하면서 저장
     * <p>
     * <p>
     * 1. baseRow baseCol이 0이면 처음 값, 0이 아니면 비교 진행
     */

    static int[][] base;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int baseRow = 0;
        int baseCol = 0;

        boolean status = true;


        for (int t = 0; t < N; t++) {
            String[] sa = bf.readLine().split(" ");
            int targetRow = Integer.parseInt(sa[0]);
            int targetCol = Integer.parseInt(sa[1]);

            // 초기 값이라면
            if (t == 0) {
                baseRow = targetRow;
                baseCol = targetCol;

                base = new int[baseRow][baseCol];
                for (int i = 0; i < baseRow; i++) {
                    sa = bf.readLine().split(" ");
                    for (int j = 0; j < baseCol; j++) {
                        base[i][j] = Integer.parseInt(sa[j]);
                    }
                }
            } else {
                // 곱이 불가능하면 -1 출력
                if (baseCol != targetRow) {
                    status = false;
                    break;
                }

                // 타겟 입력
                int[][] target = new int[targetRow][targetCol];
                for (int i = 0; i < targetRow; i++) {
                    sa = bf.readLine().split(" ");
                    for (int j = 0; j < targetCol; j++) {
                        target[i][j] = Integer.parseInt(sa[j]);
                    }
                }

                // 곱의 결과 저장
                int[][] newBase = new int[baseRow][targetCol];

                // base 행
                for (int i = 0; i < baseRow; i++) {
                    for (int k = 0; k < targetCol; k++) {
                        long sum = 0;
                        for (int j = 0; j < baseCol; j++) {
                            sum += (long) base[i][j] * target[j][k];
                        }
                        newBase[i][k] = (int) (sum % MOD);
                    }
                }

                base = newBase;
                baseCol = targetCol;
            }
        }

        if (!status) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int i = 0; i < baseRow; i++) {
                for (int j = 0; j < baseCol; j++) {
                    sum += base[i][j];
                    sum %= MOD;
                }
            }

            System.out.println(sum);
        }

    }

}