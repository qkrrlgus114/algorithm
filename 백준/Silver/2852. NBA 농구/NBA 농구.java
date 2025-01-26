import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int aTeamSecond;
    static int bTeamSecond;
    static int aPoint;
    static int bPoint;

    // 이기고 있던 시간
    static int aWinTime;
    static int bWinTime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int teamNumber = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            String minute = str.split(":")[0];
            String second = str.split(":")[1];

            int intSecond = changeSeconds(minute, second);

            calculator(teamNumber, intSecond);
        }

        if (aPoint > bPoint) {
            aWinTime += 2880 - aTeamSecond;
        } else if (aPoint < bPoint) {
            bWinTime += 2880 - bTeamSecond;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(changeMinuteAndSecond(aWinTime)).append("\n");
        sb.append(changeMinuteAndSecond(bWinTime)).append("\n");
        System.out.println(sb);
    }

    // 분:초 -> 초로 변환
    private static int changeSeconds(String strMinute, String strSecond) {
        int minute = Integer.parseInt(strMinute) * 60;
        int second = Integer.parseInt(strSecond);

        return minute + second;
    }

    // 초 -> 분:초로 변경
    private static String changeMinuteAndSecond(int second) {
        int minute = second / 60;
        second = second % 60;

        String strMinute = "";
        String strSecond = "";

        if (minute <= 9) {
            strMinute = "0" + minute;
        } else {
            strMinute = String.valueOf(minute);
        }

        if (second <= 9) {
            strSecond = "0" + second;
        } else {
            strSecond = String.valueOf(second);
        }

        return strMinute + ":" + strSecond;
    }

    private static void calculator(int teamNumber, int intSecond) {
        if (teamNumber == 1) {
            // b팀이 이기고 있었다면
            if (aPoint < bPoint && aPoint + 1 == bPoint) {
                aTeamSecond = intSecond;
                // b팀한테 이긴 시간을 더해준다.
                bWinTime += aTeamSecond - bTeamSecond;
            } else if (aPoint == bPoint) {
                aTeamSecond = intSecond;
            }
            // a팀에게 포인트 지급
            aPoint++;
            // 포인트가 같아지면 a팀의 시간 갱신
            if (aPoint == bPoint) {
                aTeamSecond = intSecond;
            }
        } else {
            // a팀이 이기고 있었다면
            if (aPoint > bPoint && bPoint + 1 == aPoint) {
                bTeamSecond = intSecond;
                // a팀한테 이긴 시간을 더해준다.
                aWinTime += bTeamSecond - aTeamSecond;
            } else if (aPoint == bPoint) {
                bTeamSecond = intSecond;
            }
            bPoint++;
        }
    }
}