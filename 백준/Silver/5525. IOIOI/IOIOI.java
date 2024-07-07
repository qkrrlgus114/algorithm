import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int S = Integer.parseInt(bf.readLine());
        String M = bf.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        int count = 1;
        while(count <= N){
            sb.append("OI");
            count++;
        }

        int answer = 0;
        String target = sb.toString();
        String replace = target.substring(2, target.length());

        while(true){
            if(M.contains(target)){
                answer++;
                M = M.replaceFirst(target, replace);
            }else{
                break;
            }
        }

        System.out.println(answer);


    }


}
