import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자 구분자 입력 처리
        int charSliceCount = Integer.parseInt(bf.readLine());
        Set<Character> delimiters = new HashSet<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < charSliceCount; i++) {
            delimiters.add(st.nextToken().charAt(0));
        }

        // 숫자 구분자 입력 처리
        int numSliceCount = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < numSliceCount; i++) {
            delimiters.add(st.nextToken().charAt(0));
        }

        // 병합자 입력 처리
        int comCount = Integer.parseInt(bf.readLine());
        Set<Character> mergers = new HashSet<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < comCount; i++) {
            mergers.add(st.nextToken().charAt(0));
        }

        // 병합자는 구분자에서 제거
        delimiters.removeAll(mergers);

        // 기준 문자열 입력 처리
        int strLength = Integer.parseInt(bf.readLine());
        String str = bf.readLine();

        // 문자열 나누기
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (delimiters.contains(currentChar)) {
                sb.append(' ');
            } else {
                sb.append(currentChar);
            }
        }

        // 공백으로 분리된 결과 출력
        String[] result = sb.toString().trim().split("\\s+");
        sb.setLength(0); // StringBuilder 초기화
        for (String part : result) {
            if (!part.isEmpty()) {
                sb.append(part).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
