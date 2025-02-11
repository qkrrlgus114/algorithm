import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        char[] catLanguage = bf.readLine().toCharArray();

        // 최대 길이
        int answer = 0;
        int[] alpha = new int[26];

        int s = 0;
        int e = -1;
        while (e < catLanguage.length - 1) {
            e++;
            // 이미 사용중인 알파벳의 종류라면
            if (alpha[catLanguage[e] - 'a'] != 0) {
                alpha[catLanguage[e] - 'a']++;
                answer = Math.max(answer, e - s + 1);
            } else {
                if (N != 0) {
                    N--;
                    alpha[catLanguage[e] - 'a']++;
                    answer = Math.max(answer, e - s + 1);
                } else {
                    while (true) {
                        if (alpha[catLanguage[s] - 'a'] == 1) {
                            alpha[catLanguage[s] - 'a']--;
                            N++;
                            s++;
                            break;
                        } else {
                            alpha[catLanguage[s] - 'a']--;
                            s++;
                        }
                    }
                    N--;
                    alpha[catLanguage[e] - 'a']++;
                    answer = Math.max(answer, e - s + 1);
                }
            }
        }

        System.out.println(answer);

    }
}