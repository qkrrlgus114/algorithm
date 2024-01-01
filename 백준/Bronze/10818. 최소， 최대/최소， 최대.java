import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] s1 = bf.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<s1.length; i++){
            int temp = Integer.parseInt(s1[i]);
            if(max < temp) max = temp;
            if(min > temp) min = temp;
        }

        System.out.println(min + " " + max);

    }
}