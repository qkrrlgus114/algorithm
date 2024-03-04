import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            s = bf.readLine();
            if(map.containsKey(s)){
                int temp = map.get(s);
                map.put(s, temp + 1);
            }else{
                map.put(s, 1);
            }
        }

        int max_count = 0;
        String result = "";

        for(Map.Entry<String, Integer> m : map.entrySet()){
            int value = m.getValue();
            String title = m.getKey();
            if(value > max_count){
                max_count = value;
                result = title;
            }else if(value == max_count && result.compareTo(title) > 0){
                result = title;
            }
        }

        System.out.println(result);
    }
}
