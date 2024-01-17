import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static int N;
    static int M;



    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);
        String[] sa = bf.readLine().split(" ");
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=0; i<N; i++){
            Long temp = Long.parseLong(sa[i]);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }else{
                map.put(temp, 1L);
            }
        }
        String m = bf.readLine();
        M = Integer.parseInt(m);

        sa = bf.readLine().split(" ");
        for(int i=0; i<M; i++){
            Long temp = Long.parseLong(sa[i]);
            if(map.containsKey(temp)){
                sb.append(map.get(temp) + " ");
            }else{
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());



    }
}