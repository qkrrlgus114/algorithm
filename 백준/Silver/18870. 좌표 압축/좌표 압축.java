import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(sa[i]);
            set.add(n);
            list.add(n);
        }

        List<Integer> sortList = new ArrayList<>(set);
        Collections.sort(sortList);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(Integer num : sortList){
            map.put(num, index++);
        }

        List<Integer> result = new ArrayList<>();
        for(Integer num : list){
            result.add(map.get(num));
        }

        StringBuilder sb = new StringBuilder();

        for(Integer num : result){
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}