import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][][] not = {
            {{1, 1}, {2, 1}, {3, 1}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {3, 0}, {3, 1}, {4, 0}, {4, 1}},
            {{1, 0}, {1, 1}, {3, 1}, {3, 2}},
            {{1, 0}, {1, 1}, {3, 0}, {3, 1}},
            {{0, 1}, {1, 1}, {3, 0}, {3, 1}, {4, 0}, {4, 1}},
            {{1, 1}, {1, 2}, {3, 0}, {3, 1}},
            {{1, 1}, {1, 2}, {3, 1}},
            {{1, 0}, {1, 1}, {2, 0}, {2, 1}, {3, 0}, {3, 1}, {4, 0}, {4, 1}},
            {{1, 1}, {3, 1}},
            {{1, 1}, {3, 0}, {3, 1}},
    };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[][][] num = new char[4][5][3];
        // 있으면 안되는 곳에 값이 있는지 확인한다.
        for (int i = 0; i < 5; i++) {
            String[] sa = bf.readLine().split(" ");
            num[0][i] = sa[0].toCharArray();
            num[1][i] = sa[1].toCharArray();
            num[2][i] = sa[2].toCharArray();
            num[3][i] = sa[3].toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            checkTime(num[i]);
        }

        String answer = sb.toString();
        answer = answer.substring(0, 2) + ":" + answer.substring(2, 4);
        System.out.println(answer);
    }

    public static void checkTime(char[][] num) {
        for (int i = 0; i < 10; i++) {
            boolean isNum = true;
            for (int j = 0; j < not[i].length; j++) {
                int[] index = not[i][j];

                if (num[index[0]][index[1]] == '#') {
                    isNum = false;
                    break;
                }
            }
            if (isNum) {
                sb.append(i);
                break;
            }
        }
    }
}