import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        List<Integer> ori = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        String[] sa = bf.readLine().split(" ");
        for(String temp : sa){
            ori.add(Integer.parseInt(temp));
            list.add(Integer.parseInt(temp));
        }

        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0), 0);

        for(int i=1; i<list.size(); i++){
            if(!list.get(i).equals(list.get(i-1))){
                int temp = map.get(list.get(i-1));
                map.put(list.get(i), temp + 1);
            }else{
                int temp = map.get(list.get(i-1));
                map.put(list.get(i), temp);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(Integer i : ori){
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
