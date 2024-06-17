import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(word);

        String reverseWord = String.valueOf(sb.reverse());

        if(word.equals(reverseWord)) System.out.println(1);
        else System.out.println(0);
    }
}

