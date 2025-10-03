import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] yumi = new int[2];

        String[] sa = bf.readLine().split(" ");
        yumi[0] = Integer.parseInt(sa[0]);
        yumi[1] = Integer.parseInt(sa[1]);

        int[][] people = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String[] s = bf.readLine().split(" ");
            people[i][0] = Integer.parseInt(s[0]);
            people[i][1] = Integer.parseInt(s[1]);
        }

        int[][] orders = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 0, 2},
                {1, 2, 0},
                {2, 0, 1},
                {2, 1, 0}
        };

        double answer = Double.MAX_VALUE;
        for (int[] order : orders) {
            double distance = 0d;

            distance += getDistance(yumi, people[order[0]]);
            distance += getDistance(people[order[0]], people[order[1]]);
            distance += getDistance(people[order[1]], people[order[2]]);

            answer = Math.min(answer, distance);
        }

        int index = String.valueOf(answer).indexOf(".");
        String answerStr = String.valueOf(answer).substring(0, index);
        System.out.println(answerStr);
    }

    // 거리 구하기
    public static double getDistance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}