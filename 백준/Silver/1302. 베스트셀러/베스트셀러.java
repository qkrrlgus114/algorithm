import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            s = bf.readLine();
            list.add(s);
        }

        Collections.sort(list);

        int max_count = Integer.MIN_VALUE;
        int cur_count = 1;
        String result = list.get(0);
        for(int i=1; i<N; i++){
            if(!list.get(i).equals(list.get(i-1))) cur_count = 0;
            cur_count++;

            if(max_count < cur_count && list.get(i).equals(list.get(i-1))){
                max_count = cur_count;
                result = list.get(i);
            }
        }

        System.out.println(result);

    }
}
