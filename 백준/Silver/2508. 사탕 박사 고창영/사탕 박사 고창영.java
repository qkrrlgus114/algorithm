import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            bf.readLine();
            String[] sa = bf.readLine().split(" ");
            int r = Integer.parseInt(sa[0]);
            int c = Integer.parseInt(sa[1]);

            char[][] arr = new char[r][c];

            for (int i = 0; i < r; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            int candy = 0;
            // 가로 사탕 계산
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c - 2; j++) {
                    if (arr[i][j] == '>' && arr[i][j + 1] == 'o' && arr[i][j + 2] == '<') {
                        candy++;
                    }
                }
            }

            // 가로 사탕 계산
            for (int j = 0; j < c; j++) {
                for (int i = 0; i < r - 2; i++) {
                    if (arr[i][j] == 'v' && arr[i + 1][j] == 'o' && arr[i + 2][j] == '^') {
                        candy++;
                    }
                }
            }

            sb.append(candy).append("\n");
        }
        System.out.println(sb);


    }

}
