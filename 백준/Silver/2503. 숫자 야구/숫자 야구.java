import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 1. 같은 자리에 있고 일치하면 스트라이크
     * 2. 다른 자리에 있고 일치하면 볼
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List<Min> minList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            minList.add(new Min(sa[0], Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
        }

        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) continue;
                    char[] young = new char[3];
                    young[0] = (char) (i + '0');
                    young[1] = (char) (j + '0');
                    young[2] = (char) (k + '0');
                    boolean status = true; // 정답이 되는지 여부

                    for (int q = 0; q < N; q++) {
                        Min min = minList.get(q);
                        char[] minNumber = min.number.toCharArray();
                        boolean[] check = new boolean[3]; // 이미 판단을 진행한 곳인지 확인
                        int strike = 0;
                        int ball = 0;

                        // 스트라이크 확인
                        if (young[0] == minNumber[0]) {
                            check[0] = true;
                            strike++;
                        }
                        if (young[1] == minNumber[1]) {
                            check[1] = true;
                            strike++;
                        }
                        if (young[2] == minNumber[2]) {
                            check[2] = true;
                            strike++;
                        }

                        // 볼 확인
                        if (young[0] == minNumber[1] && !check[0]) {
                            check[0] = true;
                            ball++;
                        }
                        if (young[0] == minNumber[2] && !check[0]) {
                            check[0] = true;
                            ball++;
                        }
                        if (young[1] == minNumber[0] && !check[1]) {
                            check[1] = true;
                            ball++;
                        }
                        if (young[1] == minNumber[2] && !check[1]) {
                            check[1] = true;
                            ball++;
                        }
                        if (young[2] == minNumber[0] && !check[2]) {
                            check[2] = true;
                            ball++;
                        }
                        if (young[2] == minNumber[1] && !check[2]) {
                            check[2] = true;
                            ball++;
                        }

                        if (min.ball != ball || min.strike != strike) {
                            status = false;
                            break;
                        }
                    }

                    if (status) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

class Min {
    String number;
    int strike;
    int ball;

    public Min(String number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}