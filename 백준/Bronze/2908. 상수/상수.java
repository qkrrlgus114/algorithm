import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split(" ");

        StringBuffer sb = new StringBuffer(line[0]);
        String One = sb.reverse().toString();
        sb = new StringBuffer(line[1]);
        String Two = sb.reverse().toString();

        int maxValue = Math.max(Integer.parseInt(One), Integer.parseInt(Two));
        System.out.println(maxValue);
    }
}