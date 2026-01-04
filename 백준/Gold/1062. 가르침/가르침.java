import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K;
    static boolean[] studyWord = new boolean[26];
    static int result;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = bf.readLine();
        }

        // 5개보다 크면 학습 가능
        if (K >= 5) {
            // acint는 고정으로 학습
            studyWord[0] = true;
            studyWord[2] = true;
            studyWord[8] = true;
            studyWord[13] = true;
            studyWord[19] = true;

            check(5, 0);
        }

        System.out.println(result);
    }

    public static void check(int studyAlphaCheck, int index) {
        // K개의 단어를 배웠으면 학습 확인
        if (studyAlphaCheck == K) {
            int cnt = 0;
            for (int i = 0; i < words.length; i++) {
                char[] wordArr = words[i].toCharArray();
                boolean checkStatus = true;
                for (char chr : wordArr) {
                    if (!studyWord[chr - 'a']) {
                        checkStatus = false;
                        break;
                    }
                }
                if (checkStatus) cnt++;
            }

            result = Math.max(result, cnt);

            return;
        }

        for (int i = index; i < 26; i++) {
            if (studyWord[i]) continue;

            studyWord[i] = true;
            check(studyAlphaCheck + 1, i + 1);
            studyWord[i] = false;
        }
    }
}
