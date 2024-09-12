import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Set<Integer> set = new HashSet<>();

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(sa[i]));
        }

        int M = Integer.parseInt(bf.readLine());
        sa = bf.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            if(set.contains(Integer.parseInt(sa[i]))) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.println(sb);
    }
}
