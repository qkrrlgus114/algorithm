import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int result = 0;

        for(String word : s){
            if (!word.equals("")){
                result++;
            }
        }
        System.out.println(result);
    }
}
