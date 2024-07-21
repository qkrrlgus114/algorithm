import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        List<Long> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Long.parseLong(bf.readLine()));
        }

        Collections.sort(list);

        Map<Long, Integer> map = new HashMap<>();
        Long answer = 0L;
        int count = 0;
        for(int i=0; i<N; i++){
            Long num = list.get(i);
            int value = map.getOrDefault(num, 0) + 1;
            if(count < value){
                count = value;
                answer = num;
            }
            map.put(num, value);
        }

        System.out.println(answer);
    }
}