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

        // 정답용 리스트(정렬)
        List<Integer> list = new ArrayList<>();
        // 입력 수열 원본
        List<Integer> ori = new ArrayList<>();
        // 빈도수
        Map<Integer, Integer> map = new HashMap<>();


        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(sa[i]);
            list.add(temp);
            ori.add(temp);
            map.put(temp ,map.getOrDefault(temp, 0) + 1);
        }

        /*
        * 정렬
        * 1. 빈도수가 많은 순서
        * 2. 먼저 나온 순서
        * */

        Collections.sort(list, (o1, o2) -> {
            // 빈도수가 같으면
            if(map.get(o1) == map.get(o2)){
                return ori.indexOf(o1) - ori.indexOf(o2);
            }
            return map.get(o2) - map.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for(Integer temp : list){
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}
