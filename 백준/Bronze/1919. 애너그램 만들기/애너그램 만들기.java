import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
    * 두 영단어를 비교한다.
    * 양쪽 단어의 문자를 지웠을 때 같아지는 경우가 생기도록 만들어야 한다.
    * 이때 제거해야 하는 최소 문자의 수를 구해야 한다.
    *
    * 두 단어의 char count를 비교해서 전부 일치하게 만들어주면 된다고 생각.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word1 = bf.readLine();
        String word2 = bf.readLine();

        int[] word1Count = new int[26];
        int[] word2Count = new int[26];

        for(char c : word1.toCharArray()){
            word1Count[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            word2Count[c - 'a']++;
        }

        int answer = 0;

        for(int i=0; i<26; i++){
            if(word1Count[i] != word2Count[i]){
                answer += Math.abs(word1Count[i] - word2Count[i]);
            }
        }

        System.out.println(answer);
    }
}