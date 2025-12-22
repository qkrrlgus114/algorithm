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
            
            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            char[][] arr = new char[N][M];

            for (int i = 0; i < N; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            int candy = 0;

            // 가로
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (arr[i][j] == '>' && arr[i][j + 1] == 'o' && arr[i][j + 2] == '<') candy++;
                }
            }

            // 세로
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N - 2; j++) {
                    if (arr[j][i] == 'v' && arr[j + 1][i] == 'o' && arr[j + 2][i] == '^') candy++;
                }
            }


            sb.append(candy).append("\n");
        }

        System.out.println(sb);
    }
}
