import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split("-");
        int result = 0;

        for(int i=0; i<s.length; i++){
            int temp = sum(s[i]);
            if(i==0) result += temp;
            else result -= temp;
        }

        System.out.println(result);
    }

    public static int sum(String s){
        String[] s1 = s.split("\\+");
        int sum = 0;
        for(int i=0; i<s1.length; i++){
            sum += Integer.parseInt(s1[i]);
        }

        return sum;
    }
}