import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 인식률 = 인식한 문자의 수(R) / 전체 문자의 수(A)
     * <p>
     * 다음 줄 입력이 비어있다면 다음 문자다.
     * <p>
     * 1. A는 length()로 구한다.
     * 2. #은 charAt를 통해 개수 카운트를 진행
     * 3. 다음 입력이 공백이면 결과를 계산한다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < N; t++) {
            int A = 0;
            int cnt = 0;

            while (true) {
                String word = bf.readLine();
                if (word == null || word.isEmpty()) {
                    double ratio = (double) (A - cnt) / A;
                    double value = ratio * 100.0;
                    value = Double.parseDouble(String.format("%.1f", value));

                    if (value == Math.rint(value)) {
                        sb.append("Efficiency ratio is ").append((long) value).append("%.").append("\n");
                    } else {
                        sb.append("Efficiency ratio is ").append(value).append("%.").append("\n");
                    }
                    break;
                }

                A += word.length();

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == '#') cnt++;
                }
            }


        }
        System.out.println(sb);


    }

}