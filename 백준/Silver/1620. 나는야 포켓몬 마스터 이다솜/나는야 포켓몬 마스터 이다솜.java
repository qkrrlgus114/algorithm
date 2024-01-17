import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            map1.put(String.valueOf(i+1), s);
            map2.put(s, String.valueOf(i+1));
        }

        for(int i=0; i<M; i++){
            String s = bf.readLine();
            String poketmon = map1.get(s);
            if(poketmon == null){
                String index = map2.get(s);
                System.out.println(index);
            }else{
                System.out.println(poketmon);
            }
        }
    }

}
