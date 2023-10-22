import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split(" ");

        Long sum = 0L;

        for(int i=0; i<line.length; i++){
            sum += Long.valueOf(line[i]);
        }

        System.out.println(sum);
    }
}