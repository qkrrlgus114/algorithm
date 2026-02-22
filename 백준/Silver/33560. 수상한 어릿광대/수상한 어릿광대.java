import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] gamePoint = new int[4];
    static int dice = 1; // 턴 획득 주사위 점수
    static int turnTime = 4; // 턴 소모 시간
    static int gameTime = 0; // 게임 전체 시간
    static int point = 0; // 현재 게임의 점수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] dices = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            // 시간 240을 초과하면 게임종료 및 초기화
            if (gameTime > 240) {
                calculatorGamePoint();
            }

            int diceNum = Integer.parseInt(dices[i]);

            diceCalculator(diceNum);

        }

        System.out.println(gamePoint[0]);
        System.out.println(gamePoint[1]);
        System.out.println(gamePoint[2]);
        System.out.println(gamePoint[3]);

    }

    // 주사위 경우의 수 계산
    private static void diceCalculator(int diceNum) {
        int plusTime = 0;
        switch (diceNum) {
            case 1:
                // 종료. 현재 점수로 보상 계산
                calculatorGamePoint();
                return;
            case 2:
                if (dice > 1) {
                    dice /= 2;
                } else {
                    turnTime += 2;
                }
                break;
            case 3:
                break;
            case 4:
                plusTime = 56;
                break;
            case 5:
                if (turnTime > 1) {
                    turnTime -= 1;
                }
                break;
            case 6:
                if (dice < 32) {
                    dice *= 2;
                }
        }

        // 주사위 점수 계산
        calculatorDicePoint();

        // 시간 계산
        calculatorTurnTime(plusTime);
    }

    // 주사위 점수 계산
    private static void calculatorDicePoint() {
        point += dice;
    }

    // 턴 시간 계산
    private static void calculatorTurnTime(int plusTime) {
        gameTime += turnTime + plusTime;
    }

    // 게임 점수 계산
    private static void calculatorGamePoint() {
        if (point >= 35 && point < 65) {
            gamePoint[0]++;
        } else if (point >= 65 && point < 95) {
            gamePoint[1]++;
        } else if (point >= 95 && point < 125) {
            gamePoint[2]++;
        } else if (point >= 125) {
            gamePoint[3]++;
        }
        point = 0;
        turnTime = 4;
        gameTime = 0;
        dice = 1;
    }

}