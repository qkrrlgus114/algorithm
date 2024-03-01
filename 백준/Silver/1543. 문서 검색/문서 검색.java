

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    /*
    * 어떤 단어가 총 몇 번 등장하는지 세려고 함.
    * 중복으로 세는 것은 뺀다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String paper = br.readLine();
        String word = br.readLine();

        int ori_length = paper.length();
        String replace = paper.replace(word, "");

        // 정답
        int result = ori_length - replace.length();
        System.out.println(result/word.length());
    }


}
