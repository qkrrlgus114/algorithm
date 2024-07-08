import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String star = createStar(N);

        System.out.println(star);
    }

    private static String createStar(int N){
        StringBuilder sb = new StringBuilder();
        String star = "*";
        for(int i=1; i<=N; i++){
            sb.append(star).append("\n");
            star += "*";
        }

        return sb.toString();
    }

}
