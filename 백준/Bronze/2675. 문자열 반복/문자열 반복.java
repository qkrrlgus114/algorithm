import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int k = 0; k < tc; k++){
            StringBuilder sb = new StringBuilder();
            String[] s = bf.readLine().split(" ");
            int repeatCount = Integer.parseInt(s[0]);
            String word = s[1];

            char[] wordList = new char[word.length()];
            for(int i=0; i<wordList.length; i++){
                wordList[i] = word.charAt(i);
                for(int j=0; j<repeatCount; j++){
                    sb.append(wordList[i]);
                }
            }
            System.out.println(sb.toString());

        }
    }
}
