import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        Map<String, String> siteAndPass = new HashMap<>();

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            String site = sa[0];
            String pass = sa[1];

            siteAndPass.put(site, pass);
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<M; j++){
            sb.append(siteAndPass.get(bf.readLine())).append("\n");
        }

        System.out.println(sb);
    }

}