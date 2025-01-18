import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();
        char[] arr = word.toCharArray();

        /**
         * _만 있는 경우 -> C++
         * 대문자가 있는 경우 -> JAVA
         * 둘 다 있는 경우 -> ERROR
         * */

        // 65, 90, 97, 122

        boolean cPlus = false;
        boolean java = false;
        boolean chaneUnderScore = false;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == '_' && arr[i + 1] == '_') chaneUnderScore = true;
            if (i == 0 && (arr[i] == '_' || (arr[i] >= 65 && arr[i] <= 90))) chaneUnderScore = true;
            if (i == arr.length - 1 && arr[i] == '_') chaneUnderScore = true;
            if (arr[i] == '_') cPlus = true;
            else if (arr[i] >= 65 && arr[i] <= 90) java = true;
        }

        if ((cPlus && java) || chaneUnderScore) System.out.println("Error!");
            // 자바로 변환
        else if (cPlus) {
            for (int i = 0; i < arr.length; i++) {
                // 언더스코어가 아니면
                if (arr[i] != '_') {
                    continue;
                }

                // 다음 길이가 없다면 건너뜀
                if (i + 1 >= arr.length) continue;

                arr[i + 1] = (char) (arr[i + 1] - 32);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != '_') sb.append(arr[i]);
            }
        }
        // c++로 변환
        else if (java) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 97 && arr[i] <= 122) sb.append(arr[i]);
                else sb.append('_').append((char) (arr[i] + 32));
            }
        } else {
            sb.append(arr);
        }

        System.out.println(sb);

    }


}