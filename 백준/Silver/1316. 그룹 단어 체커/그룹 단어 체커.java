import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());
        int result = 0;

        for(int k=0; k<tc; k++){
            String word = bf.readLine();
            // 카운트 배열
            int[] countList = new int[26];
            // 그룹 단어인지 체크
            boolean check = true;

            char[] wordList = new char[word.length()];
            for(int i=0; i<wordList.length; i++){
                wordList[i] = word.charAt(i);
                if (countList[(int) wordList[i] - 97] == 0){
                    countList[(int) wordList[i] - 97] = 1;
                }else{
                    if(i != 0 && wordList[i] == wordList[i-1]){
                        continue;
                    }else{
                        check = false;
                        break;
                    }
                }
            }

            if(check){
                result++;
            }
        }
        System.out.println(result);
    }
}
