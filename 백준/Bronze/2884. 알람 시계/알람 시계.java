import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = bf.readLine().split(" ");

        int H = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        if (M >= 45){
            sb.append(H + " " + (M - 45));
        }else{
            if (H == 0){
                sb.append("23 " + (60 - 45 + M));
            }else{
                sb.append(H - 1 + " " + (60 - 45 + M));
            }
        }
        System.out.println(sb.toString());
    }
}
