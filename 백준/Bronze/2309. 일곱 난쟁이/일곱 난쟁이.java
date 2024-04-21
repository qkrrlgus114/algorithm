import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i=0; i<9; i++){
            list.add(Integer.parseInt(bf.readLine()));
            sum += list.get(i);
        }

        outer: for(int i=0; i<list.size() - 1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(sum - list.get(i) - list.get(j) == 100){
                    list.remove(j);
                    list.remove(i);
                    break outer;
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append("\n");
        }
        System.out.println(sb);


    }
}