import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine().toLowerCase();
        int[] count = new int[26];

        for(int i=0; i<s.length(); i++){
            int result = s.charAt(i);
            count[result - 97]++;
        }

        int result = 0;
        int maxIndex = 0;
        boolean check = false;

        for(int i=0; i<26; i++){
            if(count[i] > result && count[i] != 0){
                result = count[i];
                maxIndex = i;
                check = false;
            }else if(count[i] == result && count[i] != 0){
                check = true;
            }
        }
        if(!check){
            System.out.println((char)(maxIndex+65));
        }else{
            System.out.println("?");
        }
    }
}