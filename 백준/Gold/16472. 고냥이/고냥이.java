import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] alpha = new char[28];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        // 현재 알파벳의 개수
        int count = 0;
        int result = 0;

        String word = bf.readLine();


        int l = 0;
        int r = 0;
        while(r < word.length()){
            alpha[word.charAt(r) - 97]++;
            // 더했는데 개수가 1이면 새로운 문자
            if(alpha[word.charAt(r) - 97] == 1) count++;
            // 문자 종류 확인
            if(count > N){
                while(count > N){
                    l++;
                    alpha[word.charAt(l-1) - 97]--;
                    if(alpha[word.charAt(l-1) - 97] == 0) break;
                }
                count--;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }

        System.out.println(result);
    }
}