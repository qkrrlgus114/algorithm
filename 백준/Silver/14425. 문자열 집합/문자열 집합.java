import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        Map<String, Integer> map = new HashMap<>();
        String[] name = new String[N];

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            name[i] = s;
            map.put(s, 0);
        }

        for(int i=0; i<M; i++){
            String s = bf.readLine();
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
        }

        int result = 0;

        for(int i=0; i<N; i++){
            result += map.get(name[i]);
        }

        System.out.println(result);

    }
}
