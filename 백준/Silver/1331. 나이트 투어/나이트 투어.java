import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[36][36];

        // 이전 이동 값
        int bOne = Integer.MAX_VALUE;
        int bTwo = Integer.MAX_VALUE;

        // 초기 값
        int initOne = 0;
        int initTwo = 0;

        // 상태
        boolean status = true;

        for (int i = 0; i < 36; i++) {
            String s = bf.readLine();
            char[] array = s.toCharArray();
            int one = array[0] - 'A';
            int two = array[1] - '1';

            if (bOne == Integer.MAX_VALUE) {
                visited[one][two] = true;
                bOne = one;
                bTwo = two;
                initOne = one;
                initTwo = two;
                continue;
            }

            // 이미 방문했다면 Invalid
            if (visited[one][two]) {
                status = false;
                break;
            }

            // 왼쪽위부터 시계방향
            if (knightCheck(bOne, bTwo, one, two)) {
                visited[one][two] = true;
                bOne = one;
                bTwo = two;
            } else {
                status = false;
                break;
            }
        }

        if (!knightCheck(bOne, bTwo, initOne, initTwo)) {
            status = false;
        }


        System.out.println(status ? "Valid" : "Invalid");
    }

    public static boolean knightCheck(int bOne, int bTwo, int one, int two) {
        return (bOne - 2 == one && bTwo + 1 == two) ||
                (bOne - 1 == one && bTwo + 2 == two) ||
                (bOne + 1 == one && bTwo + 2 == two) ||
                (bOne + 2 == one && bTwo + 1 == two) ||
                (bOne + 2 == one && bTwo - 1 == two) ||
                (bOne + 1 == one && bTwo - 2 == two) ||
                (bOne - 1 == one && bTwo - 2 == two) ||
                (bOne - 2 == one && bTwo - 1 == two);
    }
}