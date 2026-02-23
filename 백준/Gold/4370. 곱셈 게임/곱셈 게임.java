import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     *
     * 1. 무조건 백준이가 먼저 시작
     * 2. (현재값 * (2~9))가 N보다 커야함.
     * 3. 백준이가 9를 곱함(최선) -> x >= n이 되면 백준이 승
     * 4. 3의 값에서 2를 곱함(최선) -> x >= n이 되면 동혁이 승?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = bf.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            Long target = Long.valueOf(line);
            long i = 1l;

            while (true) {
                if (i * 9 >= target) {
                    sb.append("Baekjoon wins.").append("\n");
                    break;
                } else {
                    i *= 9;
                    if (i * 2 >= target) {
                        sb.append("Donghyuk wins.").append("\n");
                        break;
                    }
                    i *= 2;
                }
            }
        }

        System.out.println(sb);

    }

}