import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int count = 0;

        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'A']++;
        }

        int odd = 0;
        int num = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                odd++;
                num = i;
            }
            if(odd >= 2){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i] / 2; j++){
                sb.append((char)(i + 'A'));
            }
        }

        String first = sb.toString();
        String second = sb.reverse().toString();
        if(num != -1){
            first += (char)(num + 'A');
        }
        System.out.println(first + second);

    }
}