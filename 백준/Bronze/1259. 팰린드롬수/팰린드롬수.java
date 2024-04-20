import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = bf.readLine();
            if(s.equals("0")) break;
            sb = sb.append(s).reverse();
            if(sb.toString().equals(s)) System.out.println("yes");
            else System.out.println("no");
            sb.setLength(0);
        }
    }
}